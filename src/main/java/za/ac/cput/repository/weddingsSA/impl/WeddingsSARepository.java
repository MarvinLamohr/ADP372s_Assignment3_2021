package za.ac.cput.repository.weddingsSA.impl;

import za.ac.cput.Entity.Customer;
import za.ac.cput.Entity.WeddingsSA;
import za.ac.cput.repository.customer.impl.CustomerRepository;
import za.ac.cput.repository.weddingsSA.IWeddingsSARepository;

import java.util.ArrayList;
import java.util.List;

public class WeddingsSARepository  implements IWeddingsSARepository {

    private static WeddingsSARepository repository = null;
    private List<WeddingsSA> WeddingsSADB = null;

    private WeddingsSARepository() {
        WeddingsSADB = new ArrayList<>();
    }

    public static WeddingsSARepository getRepository() {
        if (repository == null) {
            repository = new WeddingsSARepository();
        }
        return repository;
    }


    @Override
    public WeddingsSA create(WeddingsSA weddingsSA) {
        this.WeddingsSADB.add(weddingsSA);
        return null;
    }

    @Override
    public WeddingsSA read(String companyName) {
        for (WeddingsSA wed : WeddingsSADB) {
            if (wed.getCompanyName().equals(companyName)) {
                return wed;
            }
        }
        return null;
    }

    @Override
    public WeddingsSA update(WeddingsSA weddingsSA) {
        WeddingsSA AnotherCompany = read(weddingsSA.getCompanyName());
        if (AnotherCompany != null) {
            WeddingsSADB.remove(AnotherCompany);
            WeddingsSADB.add(weddingsSA);
        }return null;
    }

    @Override
    public WeddingsSA delete(String companyName) {
        WeddingsSA companyToDelete = read(companyName);
        if (companyToDelete == null)
            return null;
        WeddingsSADB.remove(companyToDelete);
        return null;
    }
}
