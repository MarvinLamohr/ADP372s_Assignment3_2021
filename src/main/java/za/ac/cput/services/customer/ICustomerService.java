package za.ac.cput.services.customer;

import za.ac.cput.entity.Customer;
import za.ac.cput.services.IService;

import java.util.List;

public interface ICustomerService extends IService<Customer,String> {

    public List<Customer> getAll();

}


