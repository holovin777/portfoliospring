package ninja.curriculum.portfoliospring.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/company")
public class CompanyController {
    private final CompanyService companyService;

    @Autowired
    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @GetMapping(path = "/all")
    public List<Company> getCompanies() {
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

    @PutMapping(path = "/{companyId}/update")
    public void updateCompany(@PathVariable Long companyId, @RequestParam(required = false) String name, @RequestParam(required = false) String nameIt, @RequestParam(required = false) String location, @RequestParam(required = false) String locationIt) {
        this.companyService.updateCompany(companyId, name, nameIt, location, locationIt);
    }

}
