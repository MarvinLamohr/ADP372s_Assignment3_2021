package za.ac.cput.services.weddingsSA;

import za.ac.cput.entity.Customer;
import za.ac.cput.entity.WeddingsSA;
import za.ac.cput.services.IService;

import java.util.List;

public interface IWeddingSAService extends IService<WeddingsSA,String> {
    public List<WeddingsSA> getAll();
}
