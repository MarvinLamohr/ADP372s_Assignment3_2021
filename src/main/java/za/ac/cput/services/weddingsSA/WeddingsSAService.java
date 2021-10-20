package za.ac.cput.services.weddingsSA;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.WeddingsSA;
import za.ac.cput.repository.weddingsSA.impl.WeddingsSARepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WeddingsSAService implements IWeddingSAService{



    @Autowired
    public WeddingsSARepository weddingsSARepository;


    public WeddingsSA create(WeddingsSA weddingsSA) {
        return this.weddingsSARepository.save(weddingsSA);
    }

    public WeddingsSA read(String companyName) {
        return this.weddingsSARepository.findById(companyName).orElse(null);
    }


    public WeddingsSA update(WeddingsSA weddingsSA) {
        return this.weddingsSARepository.save(weddingsSA);
    }

    public boolean delete(String companyName) {
        this.weddingsSARepository.deleteById(companyName);
        return false;
    }

    @Override
    public List<WeddingsSA> getAll(){return this.weddingsSARepository.findAll().stream().collect(Collectors.toList());}
}

