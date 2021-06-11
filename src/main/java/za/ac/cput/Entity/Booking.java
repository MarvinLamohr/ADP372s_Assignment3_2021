package za.ac.cput.Entity;

/*  Booking.java
 *  Entity for the booking
 *  Author: Ian Louw (216250773)
 *  Date: 11 June 2021
 */

public class Booking {
    private String name, address, database, date, status;
    private Double price;

    private Booking(Builder builder){
        this.name = builder.name;
        this.address = builder.address;
        this.database = builder.database;
        this.date = builder.date;
        this.price = builder.price;
        this.status = builder.status;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", database='" + database + '\'' +
                ", date='" + date + '\'' +
                ", status='" + status + '\'' +
                ", price=" + price +
                '}';
    }

    public static class Builder{

        private String name, address, database, date, status;
        private Double price;

        public Builder setName(String name) {
            this.name = name;

            return this;
        }

        public Builder setAddress(String address) {
            this.address = address;

            return this;
        }

        public Builder setDatabase(String database) {
            this.database = database;

            return this;
        }

        public Builder setDate(String date) {
            this.date = date;

            return this;
        }

        public Builder setStatus(String status) {
            this.status = status;

            return this;
        }

        public Builder setPrice(Double price) {
            this.price = price;

            return this;
        }

        public Booking build () {

            return new Booking(this);
        }

        public Builder copy(Booking booking) {
            this.name = booking.name;
            this.address = booking.address;
            this.database = booking.database;
            this.date = booking.date;
            this.price = booking.price;
            this.status = booking.status;

            return this;
        }
    }
}
