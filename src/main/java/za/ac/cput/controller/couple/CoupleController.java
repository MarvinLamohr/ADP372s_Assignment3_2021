package za.ac.cput.controller.couple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.entity.Contact;
import za.ac.cput.entity.Couple;
import za.ac.cput.factory.ContactFactory;
import za.ac.cput.factory.CoupleFactory;
import za.ac.cput.services.contact.ContactService;
import za.ac.cput.services.couple.CoupleService;

import java.util.Set;

@RequestMapping("/couple")
public class CoupleController {
    @Autowired
    private CoupleService coupleService;

    @PostMapping("/create")
    public Couple create(@RequestBody Couple couple){
        Couple newCouple = CoupleFactory.createCouple( couple.getCoupleSurname(), couple.getAddress(),couple.getGender(),couple.getAge());
        return  coupleService.create(newCouple);
    }
    @GetMapping("/read/{id}")
    public Couple read(@PathVariable String id){
        return coupleService.read(id);
    }

    @PostMapping("/update")
    public Couple  update( @RequestBody  Couple couple){
        return coupleService.update(couple);
    }
    @PostMapping("/delete/{id}")
    public void delete(@PathVariable String id){
        coupleService.delete(id);

    }

    @GetMapping("/getall")
    public Set<Couple> getAll(){
        return coupleService.getAll();
    }
}