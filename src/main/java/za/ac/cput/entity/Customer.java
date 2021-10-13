package za.ac.cput.entity;

/**
 * Customer.java
 * This is an Entity for Customer
 *
 * Lefu Kumeke - 218147856
 */

public class Customer {

    private String customerName;
    private String customerID;
    private String address;
    private int age;
    private int contact;

    private Customer(Builder builder){

        this.customerName = builder.customerName;
        this.customerID = builder.customerID;
        this.address = builder.address;
        this.age = builder.age;
        this.contact = builder.contact;
    }
    public String getCustomerID() {
        return customerID;
    }
    public String getCustomerName() {
        return customerName;
    }
    public String getAddress() {
        return address;
    }
    public int getAge() {
        return age;
    }
    public int getContact() {
        return contact;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerName='" + customerName + '\'' +
                "customerID='" + customerID + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                ", contact=" + contact +
                '}';
    }

    public static class Builder{

        private String customerName;
        private String customerID;
        private String address;
        private int age;
        private int contact;

        public Builder setCustomerName(String customerName) {
            this.customerName = customerName;

            return this;
        }
        public Builder setcustomerID(String customerID) {
            this.customerID = customerID;

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
            this.customerID = customer.customerID;
            this.address = customer.address;
            this.age = customer.age;
            this.contact = customer.contact;

            return this;

        }

    }


}
