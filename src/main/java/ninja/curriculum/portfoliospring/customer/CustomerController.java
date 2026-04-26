package ninja.curriculum.portfoliospring.customer;

import ninja.curriculum.portfoliospring.qualification.Qualification;
import ninja.curriculum.portfoliospring.social.Social;
import ninja.curriculum.portfoliospring.workingexperience.WorkingExperience;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "/api/v1/customer")
public class CustomerController {

    private final CustomerService customerService;

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

    @GetMapping(path = "public/all")
    public List<Customer> getPublicCustomers() {
        return this.customerService.getPublicCustomers();
    }

    @GetMapping(path = "public/{slug}")
    public Customer getPublicCustomerBySlug(@PathVariable String slug) {
        return this.customerService.getPublicCustomerBySlug(slug);
    }

    @GetMapping(path = "{customerId}/working-experience/all")
    public List<WorkingExperience> getWorkingExperiences(@PathVariable UUID customerId) {
        return this.customerService.getWorkingExperiences(customerId);
    }

    @GetMapping(path = "{customerId}/social/all")
    public List<Social> getSocials(@PathVariable UUID customerId) {
        return this.customerService.getSocials(customerId);
    }

    @GetMapping(path = "{customerId}/qualification/all")
    public List<Qualification> getQualifications(@PathVariable UUID customerId) {
        return this.customerService.getQualifications(customerId);
    }

    @PutMapping(path = "{customerId}/update")
    public void updateCustomer(@PathVariable UUID customerId,
                               @RequestBody CustomerUpdateRequest request) {
        this.customerService.updateCustomer(customerId, request);
    }

}