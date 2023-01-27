package ninja.curriculum.portfoliospring.customer;

import ninja.curriculum.portfoliospring.certificate.Certificate;
import ninja.curriculum.portfoliospring.qualification.Qualification;
import ninja.curriculum.portfoliospring.workingexperience.WorkingExperience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "api/v1/customer")
public class CustomerController {

    private final CustomerService customerService;

    @Autowired
    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping(path = "all")
    public List<Customer> getCustomers() {
        return this.customerService.getCustomers();
    }

    @PostMapping
    public void addCustomer(@RequestBody Customer customer) {
        this.customerService.addCustomer(customer);
    }

    @GetMapping(path = "{customerId}")
    public Customer getCustomer(@PathVariable UUID customerId) {
        return this.customerService.getCustomer(customerId);
    }

    @GetMapping(path = "{customerId}/working-experience/all")
    public List<WorkingExperience> getWorkingExperiences(@PathVariable UUID customerId) {
        return this.customerService.getWorkingExperiences(customerId);
    }

    @GetMapping(path = "{customerId}/qualification/all")
    public List<Qualification> getQualifications(@PathVariable UUID customerId) {
        return this.customerService.getQualifications(customerId);
    }

    @GetMapping(path = "{customerId}/certificate/all")
    public List<Certificate> getCertificates(@PathVariable UUID customerId) {
        return this.customerService.getCertificates(customerId);
    }
}
