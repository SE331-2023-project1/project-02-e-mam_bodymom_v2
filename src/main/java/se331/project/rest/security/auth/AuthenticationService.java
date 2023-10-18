package se331.project.rest.security.auth;



import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import se331.project.rest.entity.Student;
import se331.project.rest.entity.Teacher;
import se331.project.rest.repository.StudentRepository;
import se331.project.rest.repository.TeacherRepository;
import se331.project.rest.security.config.JwtService;
import se331.project.rest.security.token.Token;
import se331.project.rest.security.token.TokenRepository;
import se331.project.rest.security.token.TokenType;
import se331.project.rest.security.user.Role;
import se331.project.rest.security.user.User;
import se331.project.rest.security.user.UserRepository;
import se331.project.rest.util.LabMapper;

import java.io.IOException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
  private final UserRepository repository;
  private final TokenRepository tokenRepository;
  private final PasswordEncoder passwordEncoder;
  private final JwtService jwtService;
  private final AuthenticationManager authenticationManager;
  private final StudentRepository studentRepository;
  private final TeacherRepository teacherRepository;

  public AuthenticationResponse registerStudent(RegisterRequest request) {

    User userStudent = User.builder()
            .username(request.getUsername())
            .firstname(request.getFirstname())
            .lastname(request.getLastname())
            .email(request.getEmail())
            .password(passwordEncoder.encode(request.getPassword()))
            .roles(List.of(Role.ROLE_STUDENT))
            .build();
    var savedUser = repository.save(userStudent);
    Student student = new Student();
    student.setUser(savedUser);
    studentRepository.save(student);
    var jwtToken = jwtService.generateToken(userStudent);
    var refreshToken = jwtService.generateRefreshToken(userStudent);
    saveUserToken(savedUser, jwtToken);

    return AuthenticationResponse.builder()
        .accessToken(jwtToken)
        .refreshToken(refreshToken)
        .build();
  }

  public AuthenticationResponse registerTeacher(RegisterRequest request) {

    User userTeacher = User.builder()
            .username(request.getUsername())
            .firstname(request.getFirstname())
            .lastname(request.getLastname())
            .email(request.getEmail())
            .password(passwordEncoder.encode(request.getPassword()))
            .roles(List.of(Role.ROLE_TEACHER))
            .build();
    var savedUser = repository.save(userTeacher);
    Teacher teacher = new Teacher();
    teacher.setUser(savedUser);
    teacherRepository.save(teacher);
    var jwtToken = jwtService.generateToken(userTeacher);
    var refreshToken = jwtService.generateRefreshToken(userTeacher);
    saveUserToken(savedUser, jwtToken);

    return AuthenticationResponse.builder()
            .accessToken(jwtToken)
            .refreshToken(refreshToken)
            .build();
  }

  public AuthenticationResponse authenticate(AuthenticationRequest request) {
    authenticationManager.authenticate(
            new UsernamePasswordAuthenticationToken(
                    request.getUsername(),
                    request.getPassword()
            )
    );
    User user = repository.findByUsername(request.getUsername())
            .orElseThrow();

    String jwtToken = jwtService.generateToken(user);
    String refreshToken = jwtService.generateRefreshToken(user);
    List<Role> userRoles = user.getRoles();
    Integer id = user.getId();
    if (user.getTeacher() != null) {
      Long teacherId = user.getTeacher().getId();
      id = Math.toIntExact(teacherId);
    } else if (user.getStudent() != null){
      Long studentId = user.getStudent().getId();
      id = Math.toIntExact(studentId);
    }

//    revokeAllUserTokens(user);
    saveUserToken(user, jwtToken);
//    System.out.println(user);
    return AuthenticationResponse.builder()
            .accessToken(jwtToken)
            .refreshToken(refreshToken)
            .userRole(userRoles)
            .id(id)
//            .user(LabMapper.INSTANCE.getOrganizerAuthDTO(user.getOrganizer()))
            .build();
  }

  private void saveUserToken(User user, String jwtToken) {
    Token token = Token.builder()
            .user(user)
            .token(jwtToken)
            .tokenType(TokenType.BEARER)
            .expired(false)
            .revoked(false)
            .build();
    tokenRepository.save(token);
  }

  private void revokeAllUserTokens(User user) {
    List<Token> validUserTokens = tokenRepository.findAllValidTokenByUser(user.getId());
    if (validUserTokens.isEmpty())
      return;
    validUserTokens.forEach(token -> {
      token.setExpired(true);
      token.setRevoked(true);
    });
    tokenRepository.saveAll(validUserTokens);
  }

  public void refreshToken(
          HttpServletRequest request,
          HttpServletResponse response
  ) throws IOException {
    final String authHeader = request.getHeader(HttpHeaders.AUTHORIZATION);
    final String refreshToken;
    final String userEmail;
    if (authHeader == null ||!authHeader.startsWith("Bearer ")) {
      return;
    }
    refreshToken = authHeader.substring(7);
    userEmail = jwtService.extractUsername(refreshToken);
    if (userEmail != null) {
      User user = this.repository.findByUsername(userEmail)
              .orElseThrow();
      if (jwtService.isTokenValid(refreshToken, user)) {
        String accessToken = jwtService.generateToken(user);
        revokeAllUserTokens(user);
        saveUserToken(user, accessToken);
        AuthenticationResponse authResponse = AuthenticationResponse.builder()
                .accessToken(accessToken)
                .refreshToken(refreshToken)
                .build();
        new ObjectMapper().writeValue(response.getOutputStream(), authResponse);
      }
    }
  }
}
