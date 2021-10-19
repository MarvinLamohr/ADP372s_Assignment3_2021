package za.ac.cput.services.couple;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import za.ac.cput.entity.Couple;
import za.ac.cput.repository.couple.CoupleRepository;


import java.util.Set;
import java.util.stream.Collectors;

@Service
public class CoupleService implements ICoupleService {
    private static za.ac.cput.services.couple.CoupleService service = null;

    @Autowired
    private CoupleRepository repository = null;
    @Override
    public Couple create(Couple couple) {
        return this.repository.save(couple);
    }


    @Override
    public Couple read(String coupleId) {
        return this.repository.findById(coupleId).orElse(null);
    }
    @Override
    public Couple update(Couple couple) {
        if (this.repository.existsById(couple.getCoupleId()))
            return this.repository.save(couple);
        return null;
    }
    @Override
    public boolean delete(String coupleId) {

        this.repository.deleteById(coupleId);
        if (this.repository.existsById(coupleId))
            return false;
        else
            return true;
    }
    @Override
    public Set<Couple> getAll() {
        return this.repository.findAll().stream().collect(Collectors.toSet());
    }
}
