package za.ac.cput.controller.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.entity.Customer;
import za.ac.cput.factory.CustomerFactory;
import za.ac.cput.services.customer.CustomerService;

@RestController
@RequestMapping

public class CustomerController {

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Customer create(Customer customer) {
        Customer newCustomer = CustomerFactory.createCustomer(customer.getCustomerID(), customer.getCustomerName(), customer.getAddress(), customer.getAge(), customer.getContact());
        return customerService.create(newCustomer);


    }

    @GetMapping("/read")
    public Customer read(@RequestBody Customer customer){
        return customerService.read(customer.getCustomerID());
    }

    @PostMapping("/update")
    public Customer update(@RequestBody Customer customer){
        return customerService.update(customer);
    }

    @PostMapping
    public void delete(@RequestBody Customer customer){
        customerService.delete(customer.getCustomerID());
    }
}