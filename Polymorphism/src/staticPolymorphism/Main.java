package staticPolymorphism;

public class Main {
    public static void main(String[] args) {
        Address workAddress = new Address();
        workAddress.setDetails(20, 22);
        workAddress.setDetails("Avalansei");
        workAddress.setDetails("Avalansei", "nr.20-22", "Bucharest");
        workAddress.setDetails("Avalansei", "nr.20-22", 710048);
        workAddress.setDetails("Avalansei", "nr.20-22", "710048");
        workAddress.setDetails("Avalansei", "Bucharest", "sector 4", "710048", "nr.20-22");
    }
}
