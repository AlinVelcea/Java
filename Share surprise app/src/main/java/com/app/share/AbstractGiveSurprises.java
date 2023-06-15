package com.app.share;

import com.app.container.BagFactoryOptimizeAccess;
import com.app.storage.IBag;
import com.app.surprise.ISurprise;

import java.util.concurrent.TimeUnit;

/**
 * We will implement a mechanism to share surprises.
 */
public abstract class AbstractGiveSurprises {
    private IBag bag;
    private int waitTime;

    /**
     * The constructor will receive 2 parameters:
     * @param bagType - type of container.
     * @param waitTime - a waiting time.
     */
    public AbstractGiveSurprises(String bagType, int waitTime) {
        this.bag = BagFactoryOptimizeAccess.getInstance().makeBag(bagType);
        this.waitTime = waitTime;
    }

    public IBag getBag() {
        return this.bag;
    }

    /**
     * Add a new surprise in the bag.
     */
    public void put(ISurprise newSurprise) {
        System.out.println("Add surprise: " + newSurprise);
        this.bag.put(newSurprise);
    }

    /**
     * Move all surprises from the
     * @param surprise (bag)
     * to this bag.
     */
    public void put(IBag surprise) {
        while (!surprise.isEmpty()) {
            this.bag.put(surprise.takeOut());
        }
    }

    public void put(ISurprise[] surprises) {
        for (ISurprise surprise : surprises) {
            System.out.println("Add surprise: " + surprise);
            this.bag.put(surprise);
        }
    }

    /**
     * Give the surprise
     */
    public void give() {
        if (this.bag.isEmpty()) {
            System.out.println("The bag is empty!");
        } else {
            this.bag.takeOut().enjoy();
            this.giveWithPassion();
        }
    }

    /**
     * It offers all the surprises from the bag, one at a time.
     * After each surprise offered, a corresponding 'waitTime' is expected.
     */
    public void giveAll() {
        if (this.bag.isEmpty()) {
            System.out.println("The bag is empty!");
        } else {
            takeOutSurprisesFromBagWithWaitTime();
        }

    }

    private void takeOutSurprisesFromBagWithWaitTime() {
        while (!this.bag.isEmpty()) {
            this.bag.takeOut().enjoy();
            try {
                TimeUnit.SECONDS.sleep(this.waitTime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        this.giveWithPassion();
    }

    /**
     * @return if the container is empty.
     */
    public boolean isEmpty() {
        return this.bag.isEmpty();
    }

    /**
     * @return the size of the bag
     */
    public int size() {
        return this.bag.size();
    }

    /**
     * An abstract method, which takes the place of an action that
     * will be performed after each surprise is offered.
     *
     * This method will be called immediately after giving a surprise,
     * regardless of the method called for sharing surprises (give() or giveAll()).
     *
     * The method will be visible only inside the package and on the inheritance chain.
     */
    protected abstract void giveWithPassion();
}
