package za.ac.cput.services.address;

import za.ac.cput.entity.Address;
import za.ac.cput.entity.Employee;
import za.ac.cput.services.IService;

import java.util.List;

public interface IAddressService extends IService<Address,String> {
    List<Address> getAll();

}
