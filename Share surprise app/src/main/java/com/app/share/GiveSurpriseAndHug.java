package com.app.share;

public class GiveSurpriseAndHug extends AbstractGiveSurprises {

    public GiveSurpriseAndHug(String bagType, int waitTime) {
        super(bagType, waitTime);
    }

    /**
     * It will implement the abstract method, displaying an appropriate message.
     */
    @Override
    public void giveWithPassion() {
        System.out.println("Warm wishes and a big hug!");

    }
}
