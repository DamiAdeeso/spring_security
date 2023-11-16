package com.kint.springsecurity;

import com.kint.springsecurity.entity.Role;
import com.kint.springsecurity.entity.User;
import com.kint.springsecurity.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class SpringsecurityApplication implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;
	@Autowired
	private PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(SpringsecurityApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User adminAccount = userRepository.findByRole(Role.ADMIN);
		if (adminAccount == null) {
			User user = new User();
			user.setFirstName("admin");
			user.setSecondName("admin");
			user.setEmail("admin");
			user.setPassword(new BCryptPasswordEncoder().encode("adminx	"));
			user.setRole(Role.ADMIN);
			userRepository.save(user);
		}
	}
}