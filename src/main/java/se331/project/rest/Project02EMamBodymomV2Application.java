package se331.project.rest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
public class Project02EMamBodymomV2Application {

	public static void main(String[] args) {
		SpringApplication.run(Project02EMamBodymomV2Application.class, args);
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
						.allowedOrigins("http://localhost:3000").exposedHeaders("x-total-count")
						.allowedOrigins("http://18.208.106.67:8001").exposedHeaders("x-total-count")
						.allowedMethods("GET","POST","PUT","DELETE","HEAD","OPITOINS")
						.allowCredentials(true)
						.allowedOrigins("*")
						.allowedHeaders("Origin","Authorization","application/json","Content-Type");

			}
		};
	}

}
