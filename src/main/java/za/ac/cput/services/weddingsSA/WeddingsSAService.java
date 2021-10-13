package za.ac.cput.services.weddingsSA;

import za.ac.cput.Entity.WeddingsSA;
import za.ac.cput.repository.weddingsSA.impl.WeddingsSARepository;

public class WeddingsSAService {

    private static WeddingsSAService service;
    private WeddingsSARepository repository;


    private WeddingsSAService() {
        this.repository = WeddingsSARepository.getRepository();
    }

    public static WeddingsSAService getService() {
        if (service == null) {
            service = new WeddingsSAService();
        }
        return service;
    }

    public WeddingsSA create(WeddingsSA weddingsSA) {
        return this.repository.create(weddingsSA);
    }

    public WeddingsSA read(String companyName) {
        return this.repository.read(companyName);
    }


    public WeddingsSA update(WeddingsSA weddingsSA) {
        return this.repository.update(weddingsSA);
    }

    public boolean delete(String companyName) {
        this.repository.delete(companyName);
        return false;
    }
}

