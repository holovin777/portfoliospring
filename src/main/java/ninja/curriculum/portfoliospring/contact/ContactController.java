package ninja.curriculum.portfoliospring.contact;

import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

@RestController
@RequestMapping("/api/v1/contact")
public class ContactController {

    private final ContactRepository repo;

    public ContactController(ContactRepository repo) {
        this.repo = repo;
    }

    // Simple DTO for incoming data
    public static class ContactRequest {
        @NotBlank public String name;
        @Email @NotBlank public String email;
        @NotBlank public String message;
    }

    @PostMapping(consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<String> sendMessage(@Valid @RequestBody ContactRequest req) {
        ContactMessage msg = new ContactMessage();
        msg.setName(req.name);
        msg.setEmail(req.email);
        msg.setMessage(req.message);
        repo.save(msg);

        return ResponseEntity.ok("Message saved successfully!");
    }
}
