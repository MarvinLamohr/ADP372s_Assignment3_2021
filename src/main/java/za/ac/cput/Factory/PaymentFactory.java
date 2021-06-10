package za.ac.cput.Factory;

import za.ac.cput.Entity.Payment;

public class PaymentFactory {
    public static Payment createPayment(int amount) {

        Payment payment = new Payment.Builder()
                            .setAmount(amount)
                            .build();

        return payment;
    }
}
