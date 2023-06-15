package registrationManagementSystem;

import java.io.Serializable;

public class Guest implements Serializable {
    private String lastName;
    private String firstName;
    private String email;
    private String phoneNumber;

    public Guest(String lastName, String firstName, String email, String phoneNumber) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public boolean hasFullName(String lastName, String firstName) {
        return (this.lastName.equalsIgnoreCase(lastName)
                && this.firstName.equalsIgnoreCase(firstName));
    }

    public boolean hasEmail(String email) {
        return this.email.equalsIgnoreCase(email);
    }

    public boolean hasPhoneNumber(String phoneNumber) {
        return this.phoneNumber.equalsIgnoreCase(phoneNumber);
    }

    public boolean hasDetails(String chars) {
        return this.lastName.toLowerCase().contains(chars)
                || this.firstName.toLowerCase().contains(chars)
                || this.email.toLowerCase().contains(chars)
                || this.phoneNumber.toLowerCase().contains(chars);
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString(){
        return "Guest details: " +
                "name: " + this.lastName + " " + this.firstName +
                ", email: " + this.email +
                ", phone number: " + this.phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null) {
            return false;
        }

        if (this.getClass() != o.getClass()) {
            return false;
        }

        Guest guest = (Guest) o;
        return this.lastName.equals(guest.lastName) &&
                this.firstName.equals(guest.firstName) &&
                this.email.equals(guest.email) &&
                this.phoneNumber.equals(guest.phoneNumber);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = super.hashCode();
        result = result * prime + ((lastName == null) ? 0 : lastName.hashCode());
        result = result * prime + ((firstName == null) ? 0 : firstName.hashCode());
        result = result * prime + ((email == null) ? 0 : email.hashCode());
        result = result * prime + ((phoneNumber == null) ? 0 : phoneNumber.hashCode());
        return result;
    }
}
