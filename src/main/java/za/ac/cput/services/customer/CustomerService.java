package za.ac.cput.services.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.Customer;
import za.ac.cput.repository.customer.impl.CustomerRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService implements ICustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer create(Customer customer)
    {
        return this.customerRepository.save(customer);
    }

    @Override
    public Customer read(String customerID)
    {
        return this.customerRepository.findById(customerID).orElse(null);
    }

    @Override
    public Customer update(Customer customer)
    {
        return this.customerRepository.save(customer);
    }

    @Override
    public boolean delete(String customerID)
    {
        this.customerRepository.deleteById(customerID);
        return false;
    }

    @Override
    public List<Customer> getAll(){return this.customerRepository.findAll().stream().collect(Collectors.toList());}


}

