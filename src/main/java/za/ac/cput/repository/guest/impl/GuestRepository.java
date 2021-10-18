package za.ac.cput.repository.guest.impl;



import org.springframework.data.jpa.repository.JpaRepository;
import za.ac.cput.entity.Guest;
import za.ac.cput.repository.guest.IGuestRepository;

import java.util.ArrayList;
import java.util.List;

public interface GuestRepository extends JpaRepository<Guest, Integer> {

}
