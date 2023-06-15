package com.app.surprise;

import java.util.ArrayList;
import java.util.Random;

/**
 * The surprise contains a random number of candies, of a certain type.
 */
public class Candies implements ISurprise {
    private static final ArrayList<String> candiesList = createCandiesTypes();
    private static final Random random = new Random();
    private int candiesNumber;
    private String candy;

    /**
     * The constructor will receive the number of candies and their type.
     */
    public Candies(int candiesNumber, String candy) {
        this.candiesNumber = candiesNumber;
        this.candy = candy;
    }

    /**
     * Collection of types of candies
     *
     * @return the collection of candies
     */
    private static ArrayList<String> createCandiesTypes() {
        ArrayList<String> candiesList = new ArrayList<>();
        candiesList.add("Hershey");
        candiesList.add("Bar-Hershey");
        candiesList.add("Milk Chocolate");
        candiesList.add("Twix");
        candiesList.add("Mars");
        candiesList.add("Snickers");
        candiesList.add("Milk Duds");
        candiesList.add("Milky Way");
        candiesList.add("M&Ms");
        candiesList.add("Kit Kat");
        candiesList.add("Chocolate Covered Raisins");
        candiesList.add("Chocolate Covered Cherries");
        candiesList.add("Skittles");
        candiesList.add("Baby Ruth");
        candiesList.add("Almond Joy");
        candiesList.add("Krackle");
        return candiesList;
    }

    /**
     * 2 random numbers are generated to decide the type of candies and their number.
     * Subsequently, it will create a corresponding (new) surprise.
     *
     * @return a new candy surprise
     */
    public static Candies generate() {
        int candyType = random.nextInt(candiesList.size());
        int candiesNumber = random.nextInt(candiesList.size());
        return new Candies(candiesNumber, candiesList.get(candyType));
    }

    /**
     * When executing the surprise, a relevant message will be displayed,
     * depending on the internal state of the surprise object.
     */
    @Override
    public void enjoy() {
        System.out.println("Enjoy candy surprise: " + this.candiesNumber + " " + this.candy);
    }

    @Override
    public String toString() {
        return "Candy surprise: " + this.candiesNumber + " " + this.candy;
    }
}
