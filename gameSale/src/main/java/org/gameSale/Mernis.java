package org.gameSale;

public class Mernis {
    private boolean isCitizen;
    private static final Citizen[]  citizens = {
            new Mernis.Citizen("21212139588", "Mert", "Deniz", "1999" ),
            new Mernis.Citizen("12121229388", "Samet", "Yılmaz", "17/10/1998" ),
    };
    public void verifyIfCitizen(User user){
        for (int i=0; i<citizens.length;i++) {
            if (citizens[i].nationalIdentity.equals(user.getNationalIdentity())
                    && citizens[i].dateOfBirth.equals(user.getDateOfBirth())
                    && citizens[i].firstName.equals(user.getFirstName())
                    && citizens[i].lastName.equals(user.getLastName())) {
                isCitizen = true;
                break;
            }
            else {
                isCitizen = false;
            }
        }
        if (isCitizen) {
            System.out.println("-------------");
            System.out.println(user.getFirstName() + " kullanıcısı e-Devlet tarafından onaylandı.");
            System.out.println("-------------");
        }
        else {
            System.out.println("-------------");
            System.out.println(user.getFirstName() + " kullanıcısı e-Devlet tarafından onaylanamadı.");
            System.out.println("-------------");
        }


    }


    private static class Citizen{
        private String nationalIdentity;
        private String firstName;
        private String lastName;
        private String dateOfBirth;


        public Citizen(String nationalIdentity, String firstName, String lastName, String dateOfBirth) {
            this.nationalIdentity = nationalIdentity;
            this.firstName = firstName;
            this.lastName = lastName;
            this.dateOfBirth = dateOfBirth;
        }

        public String getNationalIdentity() {
            return nationalIdentity;
        }

        public void setNationalIdentity(String nationalIdentity) {
            this.nationalIdentity = nationalIdentity;
        }

        public String getFirstName() {
            return firstName;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public String getLastName() {
            return lastName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        public String getDateOfBirth() {
            return dateOfBirth;
        }

        public void setDateOfBirth(String dateOfBirth) {
            this.dateOfBirth = dateOfBirth;
        }
    }

}
