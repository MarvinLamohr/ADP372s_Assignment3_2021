
/* Event.java
   Entity for the Event
   Author: Marvin Lamohr (214273830)
   Date: 07 June 2021
 */

package za.ac.cput.entity;

import javax.persistence.Entity;

@Entity
public class Event {

    private String eventName, eventID, guestList,date;
    private int capacity;

    private Event(Builder builder){

        this.eventID = builder.eventID;
        this.eventName = builder.eventName;
        this.capacity = builder.capacity;
        this.date = builder.date;
        this.guestList = builder.guestList;
}

    public String getEventName() {
        return eventName;
    }

    public String getEventID() {
        return eventID;
    }

    public String getGuestList() {
        return guestList;
    }

    public String getDate() {
        return date;
    }

    public int getCapacity() {
        return capacity;
    }

    @Override
    public String toString() {
        return "Event{" +
                "eventName='" + eventName + '\'' +
                ", eventID='" + eventID + '\'' +
                ", guestList='" + guestList + '\'' +
                ", capacity=" + capacity +
                ", date=" + date +
                '}';
    }


    public static class Builder{

        private String eventName, eventID, guestList, date;
        private int capacity;

        public Builder setEventName(String eventName) {
            this.eventName = eventName;

            return this;
        }

        public Builder setEventID(String eventID) {
            this.eventID = eventID;

            return this;
        }

        public Builder setGuestList(String guestList) {
            this.guestList = guestList;

            return this;
        }

        public Builder setCapacity(int capacity) {
            this.capacity = capacity;

            return this;
        }

        public Builder setDate(String date) {
            this.date = date;

            return this;
        }

        public Event build(){

            return new Event(this);

        }

        public Builder copy(Event event){
            this.eventName = event.eventName;
            this.eventID = event.eventID;
            this.guestList = event.guestList;
            this.capacity = event.capacity;
            this.date = event.date;

            return this;
        }

    }
}