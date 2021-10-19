package za.ac.cput.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Guest.java
 *
 *
 * Mogamat Yaseen Levy - 218003323
 */
@Entity
public class Guest {
    @Id
    private int guestAmount;

    private Guest(Builder builder){
        this.guestAmount = builder.guestAmount;
    }

    public Guest() {

    }

    public void setGuestAmount(int guestAmount) {
        this.guestAmount = guestAmount;
    }

    public int getGuestAmount() {
        return guestAmount;
    }

    public static class Builder{
        private int guestAmount;

        public Builder setGuestAmount(int guestAmount) {
            this.guestAmount = guestAmount;

            return this;
        }

        public Guest build () {

            return new Guest(this);
        }

        public Builder copy(Guest guest) {
            this.guestAmount = guest.guestAmount;

            return this;
        }
    }
}
