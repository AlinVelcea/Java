package storage;

import surprise.ISurprise;

import java.util.ArrayList;

/**
 * An abstract class symbolizes a functionally incomplete class.
 * Although it is not allowed to create "abstract" objects, it is allowed to use abstract references.
 * They will be able to indicate objects belonging to "normal" classes, which extend the abstract class.
 */
public abstract class AbstractBag implements IBag {

    protected ArrayList<ISurprise> bagOfSurprises = new ArrayList<>();

    @Override
    public void put(ISurprise newSurprise) {
        this.bagOfSurprises.add(newSurprise);
    }

    @Override
    public void put(IBag bagOfSurprises) {
        while (!bagOfSurprises.isEmpty()){
            this.bagOfSurprises.add(bagOfSurprises.takeOut());
        }
    }

    @Override
    public boolean isEmpty() {
        return this.bagOfSurprises.isEmpty();
    }

    @Override
    public int size() {
        return this.bagOfSurprises.size();
    }


}
