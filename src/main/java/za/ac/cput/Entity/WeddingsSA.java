package za.ac.cput.Entity;

/**
 * WeddingsSA.java
 * This is an Entity for WeddingsSA
 *
 * Lefu Kumeke - 218147856
 */

public class WeddingsSA {

    private String companyName;
    private int contact;

    private WeddingsSA(Builder builder) {

        this.companyName = builder.companyName;
        this.contact = builder.contact;
    }

    @Override
    public String toString() {
        return "WeddingsSA{" +
                "companyName='" + companyName + '\'' +
                ", contact=" + contact +
                '}';
    }

    public static class Builder {

        private String companyName;
        private int contact;


        public Builder setCompanyName(String companyName) {
            this.companyName = companyName;

            return this;
        }

        public Builder setContact(int contact) {
            this.contact = contact;

            return this;
        }

        public WeddingsSA build() {

            return new WeddingsSA(this);

        }

        public Builder copy(WeddingsSA weddingsSA) {

            this.companyName = weddingsSA.companyName;
            this.contact = weddingsSA.contact;

            return this;


        }}
    }
