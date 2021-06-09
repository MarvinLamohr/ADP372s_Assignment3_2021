
/* EventFactory.java
   Factory for the Event
   Author: Marvin Lamohr (214273830)
   Date: 11 June 2021
 */

package za.ac.cput.Factory;

import za.ac.cput.Entity.Event;

import java.util.Date;

public class EventFactory {

    public static Event createEvent(String eventName, String eventID, String guestList, int capacity, Date date){


        Event event = new Event.Builder().
                          setEventName(eventName).
                          setEventID(eventID).
                          setGuestList(guestList).
                          setCapacity(capacity).
                          setDate(date).
                          build();

                          return event;
    }

}
