package za.ac.cput.controller.address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import za.ac.cput.entity.Address;
import za.ac.cput.factory.AddressFactory;
import za.ac.cput.services.address.AddressService;

import java.util.List;

@RestController
@RequestMapping("/address")
public class AddressController {
    @Autowired
    private AddressService addressService;

    @PostMapping("/create")
    public Address created(@RequestBody Address address){
        Address newAddress = AddressFactory.createAddress(address.getStreetAddress(),address.getPostalAddress());
        return addressService.create(newAddress);
    }

    @GetMapping("/read")
    public Address read(@RequestBody Address address){
        return addressService.read(address.getStreetAddress());

    }
    @PostMapping("/update")
    public Address update(Address address){
        return addressService.update(address);
    }

    @DeleteMapping("/delete")
    public void delete(@RequestBody String streetAddress){
        addressService.delete(streetAddress );
    }

    @GetMapping("/getall")
    public List<Address> getAll(){
        return addressService.getAll();
    }




}
