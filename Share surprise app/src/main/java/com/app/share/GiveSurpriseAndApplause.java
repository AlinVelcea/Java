package com.app.share;

public class GiveSurpriseAndApplause extends AbstractGiveSurprises {

    public GiveSurpriseAndApplause(String bagType, int waitTime) {
        super(bagType, waitTime);
    }

    /**
     * It will implement the abstract method, displaying an appropriate message.
     */
    @Override
    public void giveWithPassion() {
        System.out.println("Loud applause to you… For it is in giving that we receive.");
    }
}
