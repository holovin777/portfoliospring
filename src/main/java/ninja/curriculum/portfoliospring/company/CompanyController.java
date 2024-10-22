package ninja.curriculum.portfoliospring.company;

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

@RestController
@RequestMapping(path = "/api/v1/company")
public class CompanyController {
	private final CompanyService companyService;

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

	@DeleteMapping(path = "/delete/{companyId}")
	public void removeCompany(@PathVariable Long companyId) {
		this.companyService.removeCompany(companyId);
	}

	@PutMapping(path = "/{companyId}/update")
	public void updateCompany(@PathVariable Long companyId, @RequestParam(required = false) String name,
			@RequestParam(required = false) String nameIt, @RequestParam(required = false) String location,
			@RequestParam(required = false) String locationIt, @RequestParam(required = false) String website) {
		this.companyService.updateCompany(companyId, name, nameIt, location, locationIt, website);
	}

}
