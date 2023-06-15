package dynamicPolymorphism;

public class Horse extends Animal {

    @Override
    public void eat() {
        System.out.println("The natural diet of the horse is pasture grass and tender plants.");
    }
}
