package dynamicPolymorphism;

public class Dog extends Animal {

    @Override
    public void eat() {
        System.out.println("Generally, a dog eats food bought by man.");
    }
}
