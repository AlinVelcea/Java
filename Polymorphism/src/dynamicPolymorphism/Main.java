package dynamicPolymorphism;

public class Main {

    public static void main(String[] args) {
        Animal laika = new Dog();
        Animal pureBloodHorse = new Horse();
        Animal carphatianBear = new Animal();
        Bear winnieThePooh = new Bear();

        laika.eat();
        pureBloodHorse.eat();
        carphatianBear.eat();
        winnieThePooh.eat();
    }
}
