
public class VehicleMain {
    public static void main(String[] args) {
        System.out.println("###############################TESTING####################################");
        OnRoad car = new OnRoad("FDFL8KMFSDLKM6", 2, "Sporty", 4, 2);
        OnRoad moto = new OnRoad("FDFL8KMFLLLLLL", 1, "Yamaha", 2, 0);

        System.out.println(car.goTO(21.3, 12.88));
        System.out.println(car.addFuel(28.12));
        car.getSerialNumber();
        car.printInfo();
        System.out.println("###############################TESTING####################################");

        System.out.println(moto.goTO(11.3, 32.88));
        System.out.println(moto.addFuel(10.12));
        moto.getSerialNumber();
        moto.printInfo();
        System.out.println("###############################TESTING####################################");

        OnWater boat = new OnWater("F8GFDG86D87GGD", 20, "Waves", 2, 2000);
        System.out.println(boat.goTO(11.8, 4.33));
        System.out.println(boat.addFuel(148.05));
        boat.getSerialNumber();
        boat.printInfo();
        System.out.println("###############################TESTING####################################");

        OnAir plane = new OnAir("GJR96GDF98DF9ND", 120, "Bluesky", 4, true);
        OnAir plane1 = new OnAir("GJR96GDF98DXXXX", 20, "Bluesky2", 2, false);

        System.out.println(plane.goTO(41.3, 120.88));
        System.out.println(plane.addFuel(3000.5));
        plane.getSerialNumber();
        plane.printInfo();
        System.out.println("###############################TESTING####################################");

        System.out.println(plane1.goTO(41.3, 120.88));
        System.out.println(plane1.addFuel(3000.5));
        plane1.getSerialNumber();
        plane1.printInfo();


        System.out.println("###############################TESTING####################################");
        OnRoad car1 = new OnRoad("ASJHSA3842NDSKJ" , 4, "ASDF");
        System.out.println(car1.getSerialNumber());
        car1.printInfo();

    }
}
