package za.ac.cput.services.customer;

import za.ac.cput.Entity.Customer;
import za.ac.cput.repository.customer.impl.CustomerRepository;


public class CustomerService {
    private static CustomerService service;
    private CustomerRepository repository;


    private CustomerService() {
        this.repository = CustomerRepository.getRepository();
    }

    public static CustomerService getService() {
        if (service == null) {
            service = new CustomerService();
        }
        return service;
    }

    public Customer create(Customer customer) {
        return this.repository.create(customer);
    }

    public Customer read(String customerID) {
        return this.repository.read(customerID);
    }


    public Customer update(Customer customer) {
        return this.repository.update(customer);
    }

    public boolean delete(String customerID) {
        this.repository.delete(customerID);
        return false;
    }
}
