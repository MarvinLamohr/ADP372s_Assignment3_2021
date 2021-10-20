package za.ac.cput.repository.event;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import za.ac.cput.entity.Event;

@Repository
public interface EventRepository extends JpaRepository<Event,String> {

}
