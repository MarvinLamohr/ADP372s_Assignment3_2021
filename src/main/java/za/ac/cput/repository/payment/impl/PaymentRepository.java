package za.ac.cput.repository.payment.impl;


import za.ac.cput.Entity.Payment;

import za.ac.cput.repository.payment.IPaymentRepository;

import java.util.ArrayList;
import java.util.List;

public class PaymentRepository implements IPaymentRepository {

    private static PaymentRepository repository = null;
    private List<Payment> paymentDB = null;
    private PaymentRepository(){
        paymentDB = new ArrayList<Payment>();
    }

    public static PaymentRepository getRepository(){
        if(repository == null){
            repository=new PaymentRepository();
        }
        return repository;
    }

    @Override
    public Payment create(Payment payment) {
        this.paymentDB.add(payment);
        return payment;
    }

    @Override
    public Payment read(Integer payAmount) {
        for(Payment pay: paymentDB)
            if(pay.getAmount() == payAmount){
                return pay;
            }
        return null;
    }

    @Override
    public Payment update(Payment payment) {
        Payment oldPayment= read(payment.getAmount());
        if(oldPayment != null){
            paymentDB.remove(oldPayment);
            paymentDB.add(payment);
            return payment;
        }
        return null;
    }

    @Override
    public boolean delete(Integer payAmount) {
        Payment paymentToDelete = read(payAmount);
        if(paymentToDelete == null)
            return null;
        paymentDB.remove(paymentToDelete);
        return null;
    }
}
