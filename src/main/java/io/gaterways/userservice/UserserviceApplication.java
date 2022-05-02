package io.gaterways.userservice;

import io.gaterways.userservice.domain.Role;
import io.gaterways.userservice.domain.User;
import io.gaterways.userservice.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.ArrayList;

@SpringBootApplication
public class UserserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(UserserviceApplication.class, args);
	}

	@Bean
	PasswordEncoder passwordEncoder(){
		return new BCryptPasswordEncoder();
	}
	@Bean
	CommandLineRunner run(UserService userService){
		return args -> {
			userService.saveRole(new Role(null, "ROLE_USER"));
			userService.saveRole(new Role(null, "ROLE_MANAGER"));
			userService.saveRole(new Role(null, "ROLE_ADMIN"));
			userService.saveRole(new Role(null, "ROLE_SUPER_ADMIN"));

			userService.saveUser(new User(null, "Baba lee", "babalee", "12345678", new ArrayList<>()));
			userService.saveUser(new User(null, "Al Ameen", "alameen", "12345678", new ArrayList<>()));
			userService.saveUser(new User(null, "Moussa Diagne", "moussa", "12345678", new ArrayList<>()));
			userService.saveUser(new User(null, "Lamine Drame", "drame", "12345678", new ArrayList<>()));

			userService.addRoleToUser("drame", "ROLE_USER");
			userService.addRoleToUser("drame", "ROLE_MANAGER");
			userService.addRoleToUser("alameen", "ROLE_MANAGER");
			userService.addRoleToUser("moussa", "ROLE_ADMIN");
			userService.addRoleToUser("babalee", "ROLE_SUPER_ADMIN");
			userService.addRoleToUser("babalee", "ROLE_ADMIN");
			userService.addRoleToUser("babalee", "ROLE_USER");


		};
	}
}
