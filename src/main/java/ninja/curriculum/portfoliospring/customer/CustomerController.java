package ninja.curriculum.portfoliospring.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
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

    @PutMapping(path = "{customerId}/add-working-experience")
    public void addWorkingExperience(@PathVariable UUID customerId, @RequestParam Long positionAtWorkId, @RequestParam Long companyId, @RequestParam LocalDate startedWork, @RequestParam(required = false) LocalDate finishedWork) {
        this.customerService.addWorkingExperience(customerId, positionAtWorkId, companyId, startedWork, finishedWork);
    }

    @PutMapping(path = "{customerId}/add-school-qualification")
    public void addSchoolQualification(@PathVariable UUID customerId, @RequestParam Long schoolId, @RequestParam LocalDate startedStudying, @RequestParam(required = false) LocalDate finishedStudying) {
        this.customerService.addSchoolQualification(customerId, schoolId, startedStudying, finishedStudying);
    }

    @PutMapping(path = "{customerId}/add-collage-qualification")
    public void addCollageQualification(@PathVariable UUID customerId, @RequestParam Long collegeId, @RequestParam LocalDate startedStudying, @RequestParam(required = false) LocalDate finishedStudying) {
        this.customerService.addCollegeQualification(customerId, collegeId, startedStudying, finishedStudying);
    }
}
