/* Address.java
    Entity for the Address
    Author: Mawande Langa (219074054)
    Date: 11/06/2021

 */
package za.ac.cput.entity;

public class Address {

    private  String streetAddress,postalAddress;


    private Address(Builder builder) {
        this.streetAddress = builder.streetAddress;
        this.postalAddress = builder.postalAddress;
    }

    private Address(){

    }

    @Override
    public String toString() {
        return "Address{" +
                "streetAddress='" + streetAddress + '\'' +
                ", postalAddress='" + postalAddress + '\'' +
                '}';
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public String getPostalAddress() {
        return postalAddress;
    }

    public static class Builder{

        private  String streetAddress,postalAddress;

        public Builder setStreetAddress(String streetAddress) {
            this.streetAddress = streetAddress;
            return this;
        }

        public Builder setPostalAddress(String postalAddress) {
            this.postalAddress = postalAddress;
            return this;
        }

        public Address build(){
            return new Address(this);
        }

        public Builder copy(Address address){
            this.streetAddress = address.streetAddress;
            this.postalAddress = address.postalAddress;
            return this;
        }
    }
}
