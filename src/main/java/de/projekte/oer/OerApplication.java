package de.projekte.oer;

import de.projekte.oer.dao.MemberRepository;
import de.projekte.oer.dao.RoleRepository;
import de.projekte.oer.entity.Member;
import de.projekte.oer.entity.Role;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
public class OerApplication {

	public static void main(String[] args) {
		SpringApplication.run(OerApplication.class, args);
	}

	@Bean
	public CommandLineRunner createDefaultAdmin(MemberRepository memberRepository,
												RoleRepository roleRepository,
												PasswordEncoder passwordEncoder) {
		return args -> {
			String adminUserId = "admin";
			if (!memberRepository.existsById(adminUserId)) {
				Member admin = new Member();
				admin.setUserId(adminUserId);
				// Standard-Passwort "admin", verschlüsselt mit dem delegierenden PasswordEncoder
				admin.setPw(passwordEncoder.encode("admin"));
				admin.setFirstName("Admin");
				admin.setLastName("Admin");
				admin.setEmail("admin@admin.de");
				admin.setActive(true);
				memberRepository.save(admin);

				Role adminRole = new Role();
				adminRole.setUserId(adminUserId);
				adminRole.setRole("ROLE_ADMIN");
				roleRepository.save(adminRole);

				Role managerRole = new Role();
				managerRole.setUserId(adminUserId);
				managerRole.setRole("ROLE_MANAGER");
				roleRepository.save(managerRole);

				Role employeeRole = new Role();
				employeeRole.setUserId(adminUserId);
				employeeRole.setRole("ROLE_EMPLOYEE");
				roleRepository.save(employeeRole);
			}
		};
	}
}
