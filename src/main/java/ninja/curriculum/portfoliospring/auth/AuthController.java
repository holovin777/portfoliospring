package ninja.curriculum.portfoliospring.auth;

import ninja.curriculum.portfoliospring.appuser.AppUser;
import ninja.curriculum.portfoliospring.appuser.AppUserRepository;
import ninja.curriculum.portfoliospring.security.JwtService;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final AppUserRepository appUserRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public AuthController(
            AppUserRepository appUserRepository,
            PasswordEncoder passwordEncoder,
            JwtService jwtService
    ) {
        this.appUserRepository = appUserRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtService = jwtService;
    }

    @PostMapping("/login")
    public LoginResponse login(@RequestBody LoginRequest request) {
        AppUser appUser = appUserRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid credentials"));

        if (!Boolean.TRUE.equals(appUser.getEnabled())) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "User disabled");
        }

        if (!passwordEncoder.matches(request.getPassword(), appUser.getPassword())) {
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Invalid credentials");
        }

        String token = jwtService.generateToken(appUser);

        return new LoginResponse(
                token,
                appUser.getEmail(),
                appUser.getRole().name(),
                appUser.getCustomer() != null ? appUser.getCustomer().getId() : null
        );
    }
}
