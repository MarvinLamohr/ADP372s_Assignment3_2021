/* CoupleFactory.java
   Factory for the CoupleFactory
   Author: Asive Madladla (217068332)
   Date: 07 June 2021
 */
package za.ac.cput.factory;

import za.ac.cput.entity.Couple;

public class CoupleFactory {
    public static Couple createCouple(String coupleSurname, String address, String gender, String age){
        Couple couple = new Couple.Builder()
                .setCoupleSurname(coupleSurname)
                .setAddress(address)
                .setGender(gender)
                .setAge(age)
                .build();
        return couple;
    }
    }

