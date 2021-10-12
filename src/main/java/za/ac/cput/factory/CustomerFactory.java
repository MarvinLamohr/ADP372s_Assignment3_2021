package za.ac.cput.factory;

import za.ac.cput.entity.Customer;

/**
 * CustomerFactory.java
 * Factory for the Customer
 *
 * Lefu Kumeke - 218147856
 *
 */


public class CustomerFactory{

public static Customer createCustomer(String customerName, String address, int age, int contact){

    Customer customer = new Customer.Builder()
                        .setCustomerName(customerName)
                        .setAddress(address)
                        .setAge(age)
                        .setContact(contact)
                        .build();


    return customer;
}


}
