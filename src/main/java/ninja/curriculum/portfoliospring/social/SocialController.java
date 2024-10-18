package ninja.curriculum.portfoliospring.social;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ninja.curriculum.portfoliospring.customer.Customer;

@RestController
@RequestMapping("api/v1/social")

public class SocialController {
    private final SocialService socialService;

    public SocialController(SocialService socialService) {
        this.socialService = socialService;
    }

    @GetMapping(path = "all")
    List<Social> getSocials() {
        return socialService.getSocials();
    }

    @GetMapping(path = "{socialId}")
    public Social getSocial(@PathVariable Long socialId) {
        return this.socialService.getSocial(socialId);
    }

    @PostMapping
    public void setSocial(@RequestBody Social social) {
        this.socialService.setSocial(social);
    }

    @DeleteMapping(path="{socialId}")
    public void deleteSocial(@PathVariable Long socialId) {
        this.socialService.deleteSocial(socialId);
    }

    @PutMapping(path = "{socialId}/update")
    public void updateSocial(
            @PathVariable Long socialId,
            @RequestParam(required = false) Customer socialCustomer,
            @RequestParam(required = false) String socialLink,
            @RequestParam(required = false) String socialImageLink,
            @RequestParam(required = false) String socialDescription
    )
    {
        this.socialService.updateSocial(socialId, socialCustomer, socialLink, socialImageLink, socialDescription);
    }
}
