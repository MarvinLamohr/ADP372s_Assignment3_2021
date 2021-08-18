package za.ac.cput.Entity;
/**
 * Guest.java
 *
 *
 * Mogamat Yaseen Levy - 218003323
 */
public class Guest {
    private int guestAmount;

    private Guest(Builder builder){
        this.guestAmount = builder.guestAmount;
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
