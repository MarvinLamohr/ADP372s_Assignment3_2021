package za.ac.cput.services.weddingsSA;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.Customer;
import za.ac.cput.entity.WeddingsSA;
import za.ac.cput.repository.weddingsSA.impl.WeddingsSARepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WeddingsSAService implements IWeddingSAService{

    private static WeddingsSAService service= null;

    @Autowired
    private WeddingsSARepository repository;


    public static WeddingsSAService getService() {

        if (service == null)
        {
            service = new WeddingsSAService();
        }
        return service;
    }

    public WeddingsSA create(WeddingsSA weddingsSA) {
        return this.repository.save(weddingsSA);
    }

    public WeddingsSA read(String companyName) {
        return this.repository.findById(companyName).orElse(null);
    }


    public WeddingsSA update(WeddingsSA weddingsSA) {
        if(this.repository.existsById(weddingsSA.getCompanyName()))
            return this.repository.save(weddingsSA);
        return null;
    }

    public boolean delete(String companyName) {

        this.repository.deleteById(companyName);
        if(this.repository.existsById(companyName))
            return false;
        else
            return true;
    }

    @Override
    public List<WeddingsSA> getAll(){return this.repository.findAll().stream().collect(Collectors.toList());}
}

