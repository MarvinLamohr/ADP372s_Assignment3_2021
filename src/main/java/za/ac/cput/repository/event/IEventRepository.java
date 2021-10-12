package za.ac.cput.repository.event;

import za.ac.cput.entity.Event;
import za.ac.cput.repository.IRepository;

import java.util.List;

public interface IEventRepository extends IRepository<Event,String> {

public List<Event> getAll();

}
