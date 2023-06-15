package com.app.storage;

import com.app.surprise.ISurprise;

/**
 * This bag will give the gifts in reverse order of introduction (LIFO - last in first out)
 */
public class LIFOBag extends AbstractBag implements IBag {

    /**
     * @return last surprise that enter inside the bag and remove it from the bag
     */
    @Override
    public ISurprise takeOut() {
        if (this.bagOfSurprises.isEmpty()) {
            return null;
        }
        return this.bagOfSurprises.remove(this.bagOfSurprises.size() - 1);
    }
}
