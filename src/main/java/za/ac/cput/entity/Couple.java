/* Couple.java
   Entity for the Couple
   Author: Asive Madladla (217068332)
   Date: 07 June 2021
 */
package za.ac.cput.entity;

public class Couple {

    private String coupleSurname,address, gender;
    private int age;



    private  Couple(Couple.Builder builder){

        this. coupleSurname = builder.coupleSurname;
        this.address = builder.address;
        this.gender= builder.gender;
        this.age = builder.age;
    }
    @Override
    public String toString() {
        return "Couple{" +
                "coupleSurname='" + coupleSurname + '\'' +
                ", address='" + address + '\'' +
                ", gender='" + gender + '\'' +
                ", age=" + age +
                '}';
    }
    public static class Builder {
        private String coupleSurname, address, gender;
        private int age;

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

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public Couple build() {

            return new Couple(this);

        }

        public Couple.Builder copy(Couple couple) {
            this.coupleSurname = couple.coupleSurname;
            this.address = couple.address;
            this.gender = couple.gender;
            this.age = couple.age;

            return this;
        }
    }
}

