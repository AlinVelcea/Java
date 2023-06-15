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
        GiveSurpriseAndApplause applause = new GiveSurpriseAndApplause("RANDOM", 3);

        // Put surprises into the bag
        applause.put(new Candies(8, "Snickers"));
        applause.put(new FortuneCookie("test"));

        // Test size before giving surprises
        Assert.assertEquals(2, applause.size());

        // Test giving a surprise
        ISurprise surprise = applause.give();
        Assert.assertNotNull(surprise);

        // Test size after giving a surprise
        Assert.assertEquals(1, applause.size());

        // Test giving all surprises
        applause.giveAll();

        // Test size after giving all surprises
        Assert.assertEquals(0, applause.size());

        // Test checking if the bag is empty
        Assert.assertTrue(applause.isEmpty());
    }

    @Test
    public void testGiveSurpriseAndHug() {
        GiveSurpriseAndHug hug = new GiveSurpriseAndHug("FIFO", 5);

        // Put surprises into the bag
        hug.put(new MinionToy());
        hug.put(new Candies());

        // Test size before giving surprises
        Assert.assertEquals(2, hug.size());

        // Test giving all surprises
        hug.giveAll();

        // Test size after giving all surprises
        Assert.assertEquals(0, hug.size());

        // Test checking if the bag is empty
        Assert.assertTrue(hug.isEmpty());
    }

    @Test
    public void testGiveSurpriseAndSing() {
        GiveSurpriseAndSing sing = new GiveSurpriseAndSing("LIFO", 2);

        // Put surprises into the bag
        sing.put(new MinionToy());
        sing.put(new Candies());

        // Test size before giving surprises
        Assert.assertEquals(2, sing.size());

        // Test giving a surprise
        ISurprise surprise = sing.give();
        Assert.assertNotNull(surprise);

        // Test size after giving a surprise
        Assert.assertEquals(1, sing.size());

        // Test giving all surprises
        sing.giveAll();

        // Test size after giving all surprises
        Assert.assertEquals(0, sing.size());

        // Test checking if the bag is empty
        Assert.assertTrue(sing.isEmpty());
    }
}
