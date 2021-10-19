package za.ac.cput.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * Payment.java
 *
 *
 * Mogamat Yaseen Levy - 218003323
 */
@Entity
public class Payment {

    @Id
    private int amount;

    public Payment() {

    }

    @Override
    public String toString() {
        return "Payment{" +
                "amount=" + amount +
                '}';
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

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
