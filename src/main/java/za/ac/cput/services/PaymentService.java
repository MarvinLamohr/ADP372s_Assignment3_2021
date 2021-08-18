package za.ac.cput.services;


import za.ac.cput.Entity.Payment;
import za.ac.cput.repository.payment.impl.PaymentRepository;
import za.ac.cput.services.payment.IPaymentService;

public class PaymentService implements IPaymentService {

    private static PaymentService service;
    private PaymentRepository repository;

    private PaymentService() {
        this.repository = PaymentRepository.getRepository();
    }

    public static PaymentService getService(){
        if(service == null) {
            service = new PaymentService();
        }
        return service;
    }

    @Override
    public Payment create(Payment payment) {
        return this.repository.create(payment);
    }
    @Override
    public Payment read(Integer payAmount) {
        return this.repository.read(payAmount);
    }

    @Override
    public Payment update(Payment payment) {
        return this.repository.update(payment);
    }
    @Override
    public boolean delete(Integer payment) {
        this.repository.delete(payment);
        return false;
    }
}
