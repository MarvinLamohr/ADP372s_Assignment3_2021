package za.ac.cput.Entity;

public class Payment {
    private int amount;

    private Payment(Builder builder){
        this.amount = builder.amount;
    }

    public static class Builder{
        private int amount;

        public Builder setAmount(int amount) {
            this.amount = amount;

            return this;
        }

        public Payment build () {

            return new Payment(this);
        }

        public Builder copy(Payment payment) {
            this.amount = payment.amount;

            return this;
        }
    }
}
