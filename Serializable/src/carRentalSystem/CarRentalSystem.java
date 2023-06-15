package carRentalSystem;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CarRentalSystem implements Serializable {

    private static final Scanner sc = new Scanner(System.in);
    private Map<String, String> rentedCars = new HashMap<>(1000, 0.5f);
    private Map<String, RentedCars> owner = new HashMap<>(100, 0.5f);
    private final static String RENTEDFILE = "rentedCars.dat";
    private final static String OWNERFILE = "owner.dat";
    private final File rentedCarsFile = new File(RENTEDFILE);
    private final File ownerFile = new File(OWNERFILE);

    private static final long serialVersionUID = 1L;

    public static void writeToBinaryFile(Map<String, String> rentedCars,
            Map<String, RentedCars> owner) throws IOException {
        try (ObjectOutputStream binaryFileOutRentedCars = new ObjectOutputStream(
                new BufferedOutputStream(new FileOutputStream(RENTEDFILE)));
                ObjectOutputStream binaryFileOutOwner = new ObjectOutputStream(
                        new BufferedOutputStream(new FileOutputStream(OWNERFILE)))) {
            binaryFileOutRentedCars.writeObject(rentedCars);
            binaryFileOutOwner.writeObject(owner);
        }
    }

    public static Map<String, String> readFromBinaryFileRentedCars() throws IOException {
        Map<String, String> data = null;

        try (ObjectInputStream binaryFileInRentedCars = new ObjectInputStream(
                new BufferedInputStream(new FileInputStream(RENTEDFILE)))) {
            data = (Map<String, String>) binaryFileInRentedCars.readObject();
        } catch (ClassNotFoundException e) {
            System.out.println("A class not found exception: " + e.getMessage());
        }
        return data;
    }

    public static Map<String, RentedCars> readFromBinaryFileOwner() throws IOException {
        Map<String, RentedCars> data = null;

        try (ObjectInputStream binaryFileInOwner = new ObjectInputStream(
                new BufferedInputStream(new FileInputStream(OWNERFILE)))) {
            data = (Map<String, RentedCars>) binaryFileInOwner.readObject();
        } catch (ClassNotFoundException e) {
            System.out.println("A class not found exception: " + e.getMessage());
        }

        return data;
    }

    private static String getPlateNo() {
        System.out.println("Enter the plate number:");
        return sc.nextLine();
    }

    private static String getOwnerName() {
        System.out.println("Enter the name of the owner:");
        return sc.nextLine();
    }

    private boolean isCarRent(String plateNo) {
        return this.rentedCars.containsKey(plateNo);
    }

    private String getCarRent(String plateNo) {
        return (this.rentedCars.get(plateNo) == null ? "Unknown owner!" : this.rentedCars.get(plateNo));
    }

    private void rentCar(String plateNo, String ownerName) {
        if (isCarRent(plateNo)) {
            System.out.println("The car is rented!");
        } else {
            this.rentedCars.put(plateNo, ownerName);
            if (this.owner.containsKey(ownerName)) {
                this.owner.get(ownerName).addCar(plateNo);
            } else {
                this.owner.put(ownerName, new RentedCars(plateNo));
            }
        }
    }

    private void returnCar(String plateNo) {
        try {
            String ownerName = this.rentedCars.remove(plateNo);
            this.owner.get(ownerName).removeCar(plateNo);
            System.out.println("You return the car successfully!");
        } catch (NullPointerException e) {
            System.out.println("The car is not rented, so you can't return");
        }
    }

    private int totalRented() {
        return this.rentedCars.size();
    }

    private void showAllRentedCars() {
        if (this.rentedCars.isEmpty()) {
            System.out.println("No cars rented.");
        } else {
            for (String id : this.rentedCars.keySet()) {
                System.out.println("Car id: " + id + " is rented by " + getCarRent(id) + ".");
            }
        }
    }

    private int getCarsNo(String ownerName) {
        try {
            return this.owner.get(ownerName).getCarsNo();
        } catch (NullPointerException e) {
            return 0;
        }
    }

    private void getCarsList(String ownerName) {
        if (this.owner.containsKey(ownerName)) {
            for (String id : this.owner.get(ownerName).getCarsList()) {
                System.out.println("Car id: " + id + ".");
            }
        } else {
            System.out.println("No cars rented by owner.");
        }
    }

    private static void printCommandsList() {
        System.out.println("help             - Show commands");
        System.out.println("add              - Add a new pair (car, owner)");
        System.out.println("check            - Check if a car exists");
        System.out.println("remove           - Remove an existing car from " +
                "hashtable");
        System.out.println("getOwner         - Show the current owner of the " +
                "car");
        System.out.println("totalRented      - Show total rented cars");
        System.out.println("showAllRented    - Show all rented cars and " +
                "owners");
        System.out.println("getCarsNo        - Show cars rented by owner");
        System.out.println("getCarsList      - Show cars id rented by owner");
        System.out.println("reset            - Reset binary file");
        System.out.println("quit             - Close the app");
    }

    public void run() throws IOException {
        if (!rentedCarsFile.exists() && !ownerFile.exists()) {
            CarRentalSystem.writeToBinaryFile(rentedCars, owner);
        } else {
            rentedCars = CarRentalSystem.readFromBinaryFileRentedCars();
            owner = CarRentalSystem.readFromBinaryFileOwner();
        }
        boolean quit = false;
        while (!quit) {
            System.out.println("Wait command: (help - show commands)");
            String command = sc.nextLine();
            switch (command) {
                case "help" -> printCommandsList();
                case "add" -> rentCar(getPlateNo(), getOwnerName());
                case "check" -> System.out.println(isCarRent(getPlateNo()));
                case "remove" -> returnCar(getPlateNo());
                case "getOwner" -> System.out.println(getCarRent(getPlateNo()));
                case "totalRented" -> System.out.println(totalRented());
                case "showAllRented" -> showAllRentedCars();
                case "getCarsNo" -> System.out.println(getCarsNo(getOwnerName()));
                case "getCarsList" -> getCarsList(getOwnerName());
                case "reset" -> resetBinaryFile();
                case "quit" -> {
                    CarRentalSystem.writeToBinaryFile(rentedCars, owner);
                    System.out.println("Bye-bye");
                    quit = true;
                }
                default -> {
                    System.out.println("Unknown command. Choose from:");
                    printCommandsList();
                }
            }
        }
    }

    private void resetBinaryFile() {
        rentedCars.clear();
        owner.clear();
        rentedCarsFile.delete();
        ownerFile.delete();
        System.out.println("Binary files reset successfully.");
    }

    public static void main(String[] args) throws IOException {
        new CarRentalSystem().run();
    }
}
