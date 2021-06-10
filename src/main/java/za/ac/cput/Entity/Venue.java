/* Venue.java
    Entity for the Venue
    Author: Mawande Langa (219074054)
    Date: 11/06/2021

 */

package za.ac.cput.Entity;

public class Venue {
    private String venueName,venueLocation;
    private int venueCapacity;

    private Venue(Builder builder) {
        this.venueName = builder.venueName;
        this.venueCapacity = builder.venueCapacity;
        this.venueLocation = builder.venueLocation;
    }

    @Override
    public String toString() {
        return "Venue{" +
                "venueName='" + venueName + '\'' +
                ", venueCapacity='" + venueCapacity + '\'' +
                ", venueLocation='" + venueLocation + '\'' +
                '}';
    }


    public static class Builder{
        private String venueName,venueLocation;
        private int venueCapacity;


        public Builder setVenueName(String venueName) {
            this.venueName = venueName;
            return this;
        }

        public Builder setVenueCapacity(int venueCapacity) {
            this.venueCapacity = venueCapacity;
            return this;
        }

        public Builder setVenueLocation(String venueLocation) {
            this.venueLocation = venueLocation;
            return this;
        }



        public Venue build(){
            return new Venue(this);
        }

        public Builder copy(Venue venue){

            this.venueName = venue.venueName;
            this.venueCapacity = venue.venueCapacity;
            this.venueLocation = venue.venueLocation;

            return this;
        }
    }
}
