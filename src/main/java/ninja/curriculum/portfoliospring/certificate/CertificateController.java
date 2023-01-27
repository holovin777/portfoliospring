package ninja.curriculum.portfoliospring.certificate;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "api/v1/certificate")
public class CertificateController {
    private final CertificateService certificateService;
    public CertificateController(CertificateService certificateService) {
        this.certificateService = certificateService;
    }
    @PostMapping
    public void addCertificate(@RequestBody Certificate certificate) {
        System.out.println("Hello " + certificate);
        this.certificateService.addCertificate(certificate);
    }
}
