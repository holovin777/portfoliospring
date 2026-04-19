package ninja.curriculum.portfoliospring.config;

import ninja.curriculum.portfoliospring.appuser.AppUser;
import ninja.curriculum.portfoliospring.appuser.AppUserRepository;
import ninja.curriculum.portfoliospring.appuser.Role;
import ninja.curriculum.portfoliospring.customer.Customer;
import ninja.curriculum.portfoliospring.customer.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.UUID;

@Configuration
public class DataInitializer {

    @Bean
    CommandLineRunner initData(
            AppUserRepository appUserRepository,
            CustomerRepository customerRepository,
            PasswordEncoder passwordEncoder
    ) {
        return args -> {
            if (appUserRepository.count() == 0) {
                Customer customer = customerRepository.findAll().stream().findFirst().orElse(null);

                if (customer != null) {
                    AppUser appUser = new AppUser();
                    appUser.setId(UUID.randomUUID());
                    appUser.setEmail("admin@localhost.com");
                    appUser.setPassword(passwordEncoder.encode("change-me-now"));
                    appUser.setRole(Role.ADMIN);
                    appUser.setEnabled(true);
                    appUser.setCustomer(customer);

                    appUserRepository.save(appUser);
                }
            }
        };
    }
}
