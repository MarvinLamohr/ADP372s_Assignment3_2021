package za.ac.cput.Entity;

/**
 * Customer.java
 * This is an Entity for Customer
 *
 * Lefu Kumeke - 218147856
 */

public class Customer {

    private String customerName;
    private String address;
    private int age;
    private int contact;

    private Customer(Builder builder){

        this.customerName = builder.customerName;
        this.address = builder.address;
        this.age = builder.age;
        this.contact = builder.contact;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerName='" + customerName + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                ", contact=" + contact +
                '}';
    }

    public static class Builder{

        private String customerName;
        private String address;
        private int age;
        private int contact;

        public Builder setCustomerName(String customerName) {
            this.customerName = customerName;

            return this;
        }

        public Builder setAddress(String address) {
            this.address = address;

            return this;
        }

        public Builder setAge(int age) {
            this.age = age;

            return this;
        }

        public Builder setContact(int contact) {
            this.contact = contact;

            return this;
        }

        public Customer build(){

            return new Customer(this);

        }

        public Builder copy(Customer customer){

            this.customerName = customer.customerName;
            this.address = customer.address;
            this.age = customer.age;
            this.contact = customer.contact;

            return this;

        }

    }


}
