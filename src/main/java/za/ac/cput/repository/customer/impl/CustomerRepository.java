package za.ac.cput.repository.customer.impl;

import za.ac.cput.Entity.Customer;
import za.ac.cput.repository.customer.ICustomerRepository;

import java.util.ArrayList;
import java.util.List;

public class CustomerRepository implements ICustomerRepository {

    private static CustomerRepository repository = null;
    private List<Customer> customerDB = null;

    private CustomerRepository() {
        customerDB = new ArrayList<>();
    }

    public static CustomerRepository getRepository() {
        if (repository == null) {
            repository = new CustomerRepository();
        }
        return repository;
    }


    @Override
    public Customer create(Customer customer) {
        this.customerDB.add(customer);
        return customer;
    }



    @Override
    public Customer read(String customerID) {
        for (Customer cust : customerDB) {
            if (cust.getCustomerID().equals(customerID)) {
                return cust;
            }
        }
        return null;
    }

    @Override
    public Customer update(Customer customer) {
        Customer AnotherCustomer = read(customer.getCustomerID());
        if (AnotherCustomer != null) {
            customerDB.remove(AnotherCustomer);
            customerDB.add(customer);
        }
        return null;
    }

    @Override
    public Customer delete(String customerID) {
        Customer customerToDelete = read(customerID);
        if (customerToDelete == null)
            return null;
        customerDB.remove(customerToDelete);
        return customerToDelete;

    }

}
