package staticPolymorphism;

public class Address {
    public void setDetails(String street) {
        System.out.println("Street address: " + street);
    }

    public void setDetails(int number, int number1) {
        System.out.println("Number address: " + number + "-" + number1);
    }

    public void setDetails(String street, int number, String city) {
        System.out.println("Address details: " + street + ", " +  number + ", " + city);
    }

    public void setDetails(String street, String city, int zipCode) {
        System.out.println("3 address details (street, city, zipCode): " + street + ", " +  zipCode + ", " + city);
    }

    public void setDetails(String street, String city, String zipCode) {
        System.out.println("String zipCode contains: "  + street + ", " +  zipCode + ", " + city);
    }

    public void setDetails(String street, String city, String sector, String zipCode, String number) {
        System.out.println("All address: " + street + ", " + number + ", " + sector +", " + city + ", " + zipCode );
    }
}
