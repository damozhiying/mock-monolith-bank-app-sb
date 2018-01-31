package com.kubepay.bank;

import java.util.Arrays;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.kubepay.bank.dao.security.PrivilegeRepository;
import com.kubepay.bank.dao.security.RoleRepository;
import com.kubepay.bank.dao.security.UserRepository;
import com.kubepay.bank.entity.security.Privilege;
import com.kubepay.bank.entity.security.Role;
import com.kubepay.bank.entity.security.User;

@SpringBootApplication
@EnableTransactionManagement
@EnableJpaRepositories(basePackages= {"com.kubepay.bank.dao", "com.kubepay.bank.dao.entity.master",
"com.kubepay.bank.dao.security"})
@ComponentScan(basePackages = "com.kubepay.bank")
@EntityScan(basePackages= {"com.kubepay.bank.entity", "com.kubepay.bank.entity.master",
        "com.kubepay.bank.entity.security"})
@EnableJpaAuditing(modifyOnCreate=true)
public class ConceptBankMockApplication {


	public static void main(String[] args) {
		SpringApplication.run(ConceptBankMockApplication.class, args);
	}

	@Bean
    public CommandLineRunner demo(PrivilegeRepository privilegeRepository, RoleRepository roleRepository,
            UserRepository userRepository) {
        return (args) -> {

            Privilege newP = privilegeRepository.save(new Privilege("Hello Privilege"));

            Role role = new Role("Hello Role");
            role.setPrivileges(Arrays.asList(newP));
            Role newRole = roleRepository.save(role);

            User user = new User("abhiesa@kubepay.com", "password");
            user.setRoles(Arrays.asList(newRole));
            userRepository.save(user);

        };
    }

	@Bean
    AuditorAware<String> auditorProvider() {
        return new AuditorAwareImpl();
    }


}

class AuditorAwareImpl implements AuditorAware<String> {

    @Override
    public String getCurrentAuditor() {
        return "system";
    }

}


