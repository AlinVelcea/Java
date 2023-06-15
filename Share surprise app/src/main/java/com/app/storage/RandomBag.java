package com.app.storage;

import com.app.surprise.ISurprise;

import java.util.Random;

/**
 * This bag will give the gifts inside in a random order.
 */
public class RandomBag extends AbstractBag implements IBag {
    private static Random random = new Random();

    /**
     * @return the random surprise
     */
    @Override
    public ISurprise takeOut() {
        if (this.bagOfSurprises.isEmpty()) {
            return null;
        }
        int index = random.nextInt(this.bagOfSurprises.size());
        return this.bagOfSurprises.remove(index);
    }
}
