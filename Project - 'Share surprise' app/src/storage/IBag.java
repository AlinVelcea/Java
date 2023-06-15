package storage;

import surprise.ISurprise;

/**
 * Interfaces are an essential component of generic programming,
 * which helps us to define specialized methods on a certain characteristic of objects,
 * but which can receive as a parameter any type of objects that have in common a certain interface.
 *
 * So, in our case, all surprises will be stored in various types of containers,
 * which will dictate the storage and especially the order in which the surprises will be divided.
 * An interface will be used that will define the concrete communication protocol.
 */
public interface IBag {

    // adds a surprise in the bag
    void put(ISurprise newSurprise);

    // adds all the surprises from another IBag
    //   -> the 'bagOfSurprises' will be empty() afterwards
    void put(IBag bagOfSurprises);

    // removes a surprise from the bag and returns it
    ISurprise takeOut();

    // Checks if the bag is empty or not
    boolean isEmpty();

    // Returns the number of surprises
    int size();
}
