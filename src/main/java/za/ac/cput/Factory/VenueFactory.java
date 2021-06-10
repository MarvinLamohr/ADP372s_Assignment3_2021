/* Venue.java
    Author: Mawande Langa (219074054)
    Date: 11/06/2021

 */
package za.ac.cput.Factory;

import za.ac.cput.Entity.Venue;

public class VenueFactory {

    public static Venue createVenue(String venueName,String venueLocation,int venueCapacity){
        Venue venue = new Venue.Builder()
                .setVenueName(venueName)
                .setVenueLocation(venueLocation)
                .setVenueCapacity(venueCapacity)
                .build();
                return venue;

    }
}
