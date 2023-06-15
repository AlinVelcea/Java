public class OnWater extends Vehicle {

    private int noEngines = 2;
    private int cargoCapacity;

    public OnWater(String serialNumber, int noPersons){
        super(serialNumber, noPersons);
    }

    public OnWater(String serialNumber, int noPersons, String name){
        super(serialNumber, noPersons, name);
    }

    public OnWater(String serialNumber, int noPersons, String name, int noEngines){
        this(serialNumber, noPersons, name);
        this.noEngines = noEngines;
    }

    public OnWater(String serialNumber, int noPersons, String name, int noEngines, int cargoCapacity){
        this(serialNumber, noPersons, name, noEngines);
        this.cargoCapacity = cargoCapacity;
    }

    @Override
    public boolean goTO(double positionX, double positionY) {
        System.out.println("Sailing the vessel to coordinates: [" + positionX + ", " + positionY + "]");
        return true;
    }

    @Override
    public boolean addFuel(double amount) {
        System.out.println("Adding " + amount + " l of fuel to the vessel");
        return true;
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("Vessel properties: " +
                "\n\t- number of engines: " + this.noEngines +
                "\n\t- cargo capacity: " + this.cargoCapacity);
    }
}
