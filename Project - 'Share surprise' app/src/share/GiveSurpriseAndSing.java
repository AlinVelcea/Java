package share;

import storage.IBag;

public class GiveSurpriseAndSing extends AbstractGiveSurprises {

    public GiveSurpriseAndSing(String bagType, int waitTime) {
        super(bagType, waitTime);
    }

    /**
     * It will implement the abstract method, displaying an appropriate message.
     */
    @Override
    public void giveWithPassion() {
        System.out.println("Singing a nice song, full of joy and genuine excitement…");
    }
}
