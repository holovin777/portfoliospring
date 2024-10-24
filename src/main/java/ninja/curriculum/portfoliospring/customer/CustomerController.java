package ninja.curriculum.portfoliospring.customer;

import ninja.curriculum.portfoliospring.qualification.Qualification;
import ninja.curriculum.portfoliospring.social.Social;
import ninja.curriculum.portfoliospring.workingexperience.WorkingExperience;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(path = "api/v1/customer")
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
                               @RequestParam(required = false) String phoneNumber,
                               @RequestParam(required = false) String website,
                               @RequestParam(required = false) String blog,
                               @RequestParam(required = false) LocalDate birthday,
                               @RequestParam(required = false) String email,
                               @RequestParam(required = false) String residence,
                               @RequestParam(required = false) String residenceIt,
                               @RequestParam(required = false) String desiredProfession,
                               @RequestParam(required = false) String description,
                               @RequestParam(required = false) String descriptionIt,
                               @RequestParam(required = false) String drivingLicense,
                               @RequestParam(required = false) Boolean protectedCategory) {
        this.customerService.updateCustomer(
                customerId,
                phoneNumber,
                website,
                blog,
                birthday,
                email,
                residence,
                residenceIt,
                desiredProfession,
                description,
                descriptionIt,
                drivingLicense,
                protectedCategory
        );
    }

}