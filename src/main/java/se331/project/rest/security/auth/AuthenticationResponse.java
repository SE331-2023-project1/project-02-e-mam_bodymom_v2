package se331.project.rest.security.auth;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
//import se331.project.rest.entity.Organizer;
//import se331.project.rest.entity.OrganizerAuthDTO;
//import se331.project.rest.entity.OrganizerDTO;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AuthenticationResponse {

  @JsonProperty("access_token")
  private String accessToken;
  @JsonProperty("refresh_token")
  private String refreshToken;
//  private OrganizerAuthDTO user;
}
