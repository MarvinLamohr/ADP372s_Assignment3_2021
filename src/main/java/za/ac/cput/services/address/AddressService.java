package za.ac.cput.services.address;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.Address;
import za.ac.cput.repository.address.AddressRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AddressService implements IAddressService{

    @Autowired
    private AddressRepository repository;

    @Override
    public Address create(Address address) {
        return this.repository.save(address);
    }
    @Override
    public Address read(String streetAddress) {
        return this.repository.findById(streetAddress).orElse(null);
    }

    @Override
    public Address update(Address address) {
        if (this.repository.existsById(address.getStreetAddress()))
            return this.repository.save(address);
        return null;
    }

    @Override
    public void delete(String streetAddress) {
        this.repository.deleteById(streetAddress);

    }

    @Override
    public List<Address> getAll() {
        return this.repository.findAll().stream().collect(Collectors.toList());
    }
}
