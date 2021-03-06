package za.ac.cput.controller.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.entity.Payment;
import za.ac.cput.factory.PaymentFactory;
import za.ac.cput.services.payment.PaymentService;

@RestController
@RequestMapping
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public Payment create (Payment payment){
        Payment newPayment = PaymentFactory.createPayment(payment.getAmount());
        return paymentService.create(newPayment);
    }

    @GetMapping("/read")
    public Payment read(@RequestBody Payment payment){
        return paymentService.read(payment.getAmount());
    }

    @PostMapping("/update")
    public Payment update(@RequestBody Payment payment){
        return paymentService.update(payment);
    }

    @PostMapping
    public void delete(@RequestBody Payment payment){
        paymentService.delete(payment.getAmount());
    }
}
