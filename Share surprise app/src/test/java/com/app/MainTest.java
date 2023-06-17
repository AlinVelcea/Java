package com.app;

import com.app.share.GiveSurpriseAndApplause;
import com.app.share.GiveSurpriseAndHug;
import com.app.share.GiveSurpriseAndSing;
import com.app.surprise.Candies;
import com.app.surprise.FortuneCookie;


import com.app.surprise.ISurprise;
import com.app.surprise.MinionToy;
import org.junit.Assert;
import org.junit.Test;

public class MainTest {
    @Test
    public void testGiveSurpriseAndApplause() {
        GiveSurpriseAndApplause giveSurpriseAndApplause = new GiveSurpriseAndApplause("FIFO", 1);
        giveSurpriseAndApplause.put(new GatherSurprises().gather());
        giveSurpriseAndApplause.put(new GatherSurprises().gather());
        giveSurpriseAndApplause.put(new GatherSurprises().gather());
        giveSurpriseAndApplause.giveAll();
    }

    @Test
    public void testGiveSurpriseAndHug() {
        GiveSurpriseAndHug giveSurpriseAndHug = new GiveSurpriseAndHug("LIFO", 1);
        giveSurpriseAndHug.put(new GatherSurprises().gather());
        giveSurpriseAndHug.put(new GatherSurprises().gather());
        giveSurpriseAndHug.put(new GatherSurprises().gather());
        giveSurpriseAndHug.giveAll();
    }

    @Test
    public void testGiveSurpriseAndSing() {
        GiveSurpriseAndSing giveSurpriseAndSing = new GiveSurpriseAndSing("RANDOM", 1);
        giveSurpriseAndSing.put(new GatherSurprises().gather());
        giveSurpriseAndSing.put(new GatherSurprises().gather());
        giveSurpriseAndSing.put(new GatherSurprises().gather());
        giveSurpriseAndSing.giveAll();
    }

    // write for each type of surprise a test
    @Test
    public void testCandies() {
        ISurprise surprise = new Candies(3, "FIFO");
        Assert.assertEquals("Candies", surprise.getType());
    }

    @Test
    public void testFortuneCookie() {
        ISurprise surprise = new FortuneCookie("FIFO");
        Assert.assertEquals("FortuneCookie", surprise.getType());
    }

    @Test
    public void testMinionToy() {
        ISurprise surprise = new MinionToy("FIFO");
        Assert.assertEquals("MinionToy", surprise.getType());
    }

    @Test
    public void testGatherSurprises() {
        GatherSurprises gatherSurprises = new GatherSurprises();
        Assert.assertNotNull(gatherSurprises.gather());
    }

    @Test
    public void testGiveSurpriseAndApplause2() {
        GiveSurpriseAndApplause giveSurpriseAndApplause = new GiveSurpriseAndApplause("FIFO", 1);
        giveSurpriseAndApplause.put(new GatherSurprises().gather());
        giveSurpriseAndApplause.put(new GatherSurprises().gather());
        giveSurpriseAndApplause.put(new GatherSurprises().gather());
        giveSurpriseAndApplause.giveAll();
    }

}
