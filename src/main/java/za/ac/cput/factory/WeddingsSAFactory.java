package za.ac.cput.factory;

import za.ac.cput.entity.WeddingsSA;

/**
 * WeddingsSAFactory.java
 * Factory for  WeddingsSA
 *
 * Lefu Kumeke - 218147856
 */


public class WeddingsSAFactory {

    public static WeddingsSA createWeddingsSA( String companyName, int contact){

        WeddingsSA weddingsSA = new WeddingsSA.Builder()
                                .setCompanyName(companyName)
                                .setContact(contact)
                                .build();

        return weddingsSA;
    }
}
