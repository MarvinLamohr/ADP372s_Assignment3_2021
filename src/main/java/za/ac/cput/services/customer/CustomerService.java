package za.ac.cput.services.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.Customer;
import za.ac.cput.repository.customer.impl.CustomerRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService implements ICustomerService {
    private static CustomerService service= null;

    @Autowired
    private CustomerRepository repository;

    public static CustomerService getService()
    {
        if (service == null)
        {
            service = new CustomerService();
        }
        return service;
    }

    @Override
    public Customer create(Customer customer)
    {
        return this.repository.save(customer);
    }

    @Override
    public Customer read(String customerID)
    {
        return this.repository.findById(customerID).orElse(null);
    }

    @Override
    public Customer update(Customer customer)
    {
        if(this.repository.existsById(customer.getCustomerID()))
            return this.repository.save(customer);
        return null;
    }

    @Override
    public boolean delete(String customerID)
    {
        this.repository.deleteById(customerID);
        if(this.repository.existsById(customerID))
            return false;
        else
            return true;
    }

    @Override
    public List<Customer> getAll(){return this.repository.findAll().stream().collect(Collectors.toList());}


}

