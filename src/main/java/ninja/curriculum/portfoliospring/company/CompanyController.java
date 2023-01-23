package ninja.curriculum.portfoliospring.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "api/v1/company")
public class CompanyController {
    private final CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping(path = "all")
    public List<Company> getCompanys() {
        return this.companyService.getCompanies();
    }

    @PostMapping
    public void addCompany(@RequestBody Company company) {
        this.companyService.addCompany(company);
    }

    @GetMapping(path = "{companyId}")
    public Company getCompany(@PathVariable Long companyId) {
        return this.companyService.getCompany(companyId);
    }

}
