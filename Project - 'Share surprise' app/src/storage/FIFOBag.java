package storage;

import surprise.ISurprise;

/**
 * This bag will give the gifts in the order in which they were placed (FIFO - first in first out)
 */
public class FIFOBag extends AbstractBag implements IBag {

    /**
     * @return first surprise that enter in the bag and remove it from the bag
     */
    @Override
    public ISurprise takeOut() {
        if (this.bagOfSurprises.isEmpty()) {
            return null;
        }
        return this.bagOfSurprises.remove(0);
    }
}
