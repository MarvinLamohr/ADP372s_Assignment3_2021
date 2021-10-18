package za.ac.cput.repository.customer.impl;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.entity.Customer;

@Repository
public interface  CustomerRepository extends JpaRepository<Customer, String>  {

}
