package carRentalSystem;

import java.io.*;
import java.util.ArrayList;

public class RentedCars implements Serializable {
    private int carsNo;
    private final ArrayList<String> carsList = new ArrayList<>();

    public RentedCars(String id) {
        carsNo++;
        carsList.add(id);
    }

    public int getCarsNo() {
        return carsNo;
    }

    public ArrayList<String> getCarsList() {
        return carsList;
    }

    public void addCar(String id) {
        this.carsNo++;
        this.carsList.add(id);
    }

    public void removeCar(String id) {
        this.carsNo--;
        this.carsList.remove(id);
    }
}
