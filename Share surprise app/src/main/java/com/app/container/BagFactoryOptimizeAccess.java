package com.app.container;

import com.app.storage.FIFOBag;
import com.app.storage.IBag;
import com.app.storage.LIFOBag;
import com.app.storage.RandomBag;

/**
 * Within the application, the creation of the bag will be done
 * through an instance of the class that implements 'IBagFactory'
 * We will build containers optimized for the speed of accessing the elements.
 */
public class BagFactoryOptimizeAccess implements IBagFactory {

    private static BagFactoryOptimizeAccess singleton = null;

    public static BagFactoryOptimizeAccess getInstance() {
        if (singleton == null) {
            singleton = new BagFactoryOptimizeAccess();
        }
        return singleton;
    }

    /**
     * Depending on the value of the String, a new collection will be created.
     * @param type - a string with the type of the bag
     * @return the bag type object
     */
    @Override
    public IBag makeBag(String type) {
        if (type.equalsIgnoreCase("RANDOM")) {
            return new RandomBag();
        }

        if (type.equalsIgnoreCase("FIFO")) {
            return new FIFOBag();
        }

        if (type.equalsIgnoreCase("LIFO")) {
            return new LIFOBag();
        }
        return null;
    }
}
