package za.ac.cput.Entity;

public class Guest {
    private int guestAmount;

    private Guest(Builder builder){
        this.guestAmount = builder.guestAmount;
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
