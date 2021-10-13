package za.ac.cput.controller.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.Entity.Payment;
import za.ac.cput.Factory.PaymentFactory;
import za.ac.cput.services.PaymentService;

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
    public String delete(@RequestBody Payment payment){
        if(paymentService.delete(payment.getAmount()))
            return "Payment deleted successfully";

        else
            return "Payment could not be deleted";

    }
}
