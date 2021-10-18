package za.ac.cput.services.payment;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.Payment;
import za.ac.cput.repository.payment.impl.PaymentRepository;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class PaymentService implements IPaymentService {

    private static PaymentService service = null;

    @Autowired
    private PaymentRepository repository;



    public static PaymentService getService(){
        if(service == null) {
            service = new PaymentService();
        }
        return service;
    }


    public Payment create(Payment payment) {
        return this.repository.save(payment);
    }

    public Payment read(Integer payAmount) {
        return this.repository.findById(payAmount).orElse(null);
    }


    public Payment update(Payment payment) {
        if(this.repository.existsById(payment.getAmount()))
            return this.repository.save(payment);
        return null;
    }

    public boolean delete(Integer payment) {
        this.repository.deleteById(payment);
        if(this.repository.existsById(payment))
            return false;
        else
            return true;
    }


   // @Override
    public List<Payment> getAll(){return this.repository.findAll().stream().collect(Collectors.toList());}


}
