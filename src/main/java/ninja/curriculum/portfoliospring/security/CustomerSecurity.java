package ninja.curriculum.portfoliospring.security;

import ninja.curriculum.portfoliospring.appuser.AppUserRepository;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component("customerSecurity")
public class CustomerSecurity {

    private final AppUserRepository appUserRepository;

    public CustomerSecurity(AppUserRepository appUserRepository) {
        this.appUserRepository = appUserRepository;
    }

    public boolean isOwner(UUID customerId, String email) {
        return appUserRepository.findByEmail(email)
                .map(appUser -> appUser.getCustomer() != null
                        && customerId.equals(appUser.getCustomer().getId()))
                .orElse(false);
    }
}
