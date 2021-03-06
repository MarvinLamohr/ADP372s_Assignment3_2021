
/* Event.java
   Entity for the Event
   Author: Marvin Lamohr (214273830)
   Date: 07 June 2021
 */

package za.ac.cput.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Event {

    private String eventName;
    @Id
    private String eventID;
    private String date;

    private Event(Builder builder){

        this.eventName = builder.eventName;
        this.eventID = builder.eventID;
        this.date = builder.date;
    }

    public String getEventName() {
        return eventName;
    }

    public String getEventID() {
        return eventID;
    }

    public String getDate() {
        return date;
    }


    @Override
    public String toString() {
        return "Event{" +
                "eventName='" + eventName + '\'' +
                ", eventID='" + eventID + '\'' +
                ", date=" + date +
                '}';
    }


    public static class Builder{

        private String eventName, eventID, date;

        public Builder setEventName(String eventName) {
            this.eventName = eventName;

            return this;
        }

        public Builder setEventID(String eventID) {
            this.eventID = eventID;

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
            this.date = event.date;

            return this;
        }

    }
}