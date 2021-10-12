
/* EventFactory.java
   Factory for the Event
   Author: Marvin Lamohr (214273830)
   Date: 11 June 2021
 */

package za.ac.cput.factory;

import za.ac.cput.entity.Event;

import za.ac.cput.util.GenericHelper;

public class EventFactory {

    public static Event createEvent(String eventName, String eventID, String guestList, int capacity, String date){

        String eventId = GenericHelper.generateId();

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
