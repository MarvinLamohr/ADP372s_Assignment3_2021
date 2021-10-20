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
    private CoupleRepository coupleRepository;
    @Override
    public Couple create(Couple couple) {
        return this.coupleRepository.save(couple);
    }


    @Override
    public Couple read(String coupleId) {
        return this.coupleRepository.findById(coupleId).orElse(null);
    }
    @Override
    public Couple update(Couple couple) {
        if (this.coupleRepository.existsById(couple.getCoupleId()))
            return this.coupleRepository.save(couple);
        return null;
    }
    @Override
    public boolean delete(String coupleId) {
        this.coupleRepository.deleteById(coupleId);
        return false;
    }

    public Set<Couple> getAll() {
        return this.coupleRepository.findAll().stream().collect(Collectors.toSet());
    }
}
