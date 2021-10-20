/* Couple.java
   Entity for the Couple
   Author: Asive Madladla (217068332)
   Date: 07 June 2021
 */
package za.ac.cput.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.io.Serializable;

@Entity
public class Couple {

    @Id
    private String coupleId;
    private String coupleSurname;
    private String address;
    private String gender;
    private String age;



    private  Couple(Couple.Builder builder){
        this. coupleId = builder.build().coupleId;
        this. coupleSurname = builder.coupleSurname;
        this.address = builder.address;
        this.gender= builder.gender;
        this.age = builder.age;
    }

    public Couple() {

    }

    @Override
    public String toString() {
        return "Couple{" +
                "coupleId='" + coupleId + '\'' +
                "coupleSurname='" + coupleSurname + '\'' +
                ", address='" + address + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                '}';
    }

    public String getCoupleId() {
        return coupleId;
    }

    public String getCoupleSurname() {
        return coupleSurname;
    }

    public String getAddress() {
        return address;
    }

    public String getGender() {
        return gender;
    }

    public String getAge() {
        return age;
    }

    public static class Builder {
        private String coupleId,coupleSurname, address, gender;
        private String age;

        public Builder setCoupleId(String coupleId) {
            this.coupleId = coupleId;
            return this;
        }
        public Builder setCoupleSurname(String coupleSurname) {
            this.coupleSurname = coupleSurname;
            return this;
        }

        public Builder setAddress(String address) {
            this.address = address;
            return this;
        }

        public Builder setGender(String gender) {
            this.gender = gender;
            return this;
        }

        public Builder setAge(String age) {
            this.age = age;
            return this;
        }

        public Couple build() {

            return new Couple(this);

        }

        public Couple.Builder copy(Couple couple) {
            this.coupleId = couple.coupleId;
            this.coupleSurname = couple.coupleSurname;
            this.address = couple.address;
            this.gender = couple.gender;
            this.age = couple.age;

            return this;
        }
    }
}

