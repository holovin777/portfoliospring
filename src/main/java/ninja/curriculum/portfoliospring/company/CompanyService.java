package ninja.curriculum.portfoliospring.company;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
public class CompanyService {
    private final CompanyRepository companyRepository;

    @Autowired
    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public List<Company> getCompanies() {
        return this.companyRepository.findAll();
    }

    @Transactional
    public void addCompany(Company company) {
        Optional<Company> companyOptional = companyRepository.findByLocation(company.getLocation());
        if (companyOptional.isPresent()) {
            throw new IllegalStateException("Company " + company.getName() + " in " + company.getLocation() + " doesn't exists");
        }
        this.companyRepository.save(company);
    }

    public Company getCompany(Long companyId) {
        Optional<Company> companyOptional = companyRepository.findById(companyId);
        if (companyOptional.isPresent()) {
            return companyOptional.get();
        }
        throw new IllegalStateException("Company with id " + companyId + " doesn't exists");
    }

    @Transactional
    public void updateCompany(Long companyId, String name, String nameIt, String location, String locationIt) {
        Optional<Company> companyOptional = this.companyRepository.findById(companyId);
        if (companyOptional.isPresent()) {
            Company company = companyOptional.get();
            if (name != null) {
                company.setName(name);
                this.companyRepository.save(company);
            }
            if (nameIt != null) {
                company.setNameIt(nameIt);
                this.companyRepository.save(company);
            }
            if (location != null) {
                company.setLocation(location);
                this.companyRepository.save(company);
            }
            if (locationIt != null) {
                company.setLocationIt(locationIt);
                this.companyRepository.save(company);
            }
        } else {
            throw new IllegalStateException("Company with id " + companyId + " doesn't exists");
        }
    }
}
