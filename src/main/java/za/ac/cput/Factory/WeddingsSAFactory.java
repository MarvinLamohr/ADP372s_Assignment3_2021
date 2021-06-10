package za.ac.cput.Factory;

import za.ac.cput.Entity.WeddingsSA;

/**
 * WeddingsSAFactory.java
 * This is an Entity for WeddingsSA
 *
 * Lefu Kumeke - 218147856
 */


public class WeddingsSAFactory {

    public static WeddingsSA createWeddingsSA( String companyName, int contact){

        WeddingsSA weddingsSA = new WeddingsSA.Builder().
                                setCompanyName(companyName).
                                setContact(contact).
                                build();

                                return weddingsSA;
    }
}
