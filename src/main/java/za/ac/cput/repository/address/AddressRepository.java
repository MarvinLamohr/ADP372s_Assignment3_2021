package za.ac.cput.repository.address;

import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.entity.Address;

public interface AddressRepository extends JpaRepository<Address,String> {
}
