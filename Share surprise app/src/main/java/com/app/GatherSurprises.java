package com.app;

import com.app.surprise.Candies;
import com.app.surprise.FortuneCookie;
import com.app.surprise.ISurprise;
import com.app.surprise.MinionToy;
import java.util.Random;

/**
 * The 'GatherSurprise' class will generate a set of random surprises.
 * The class should not allow the creation of courts or inheritance,
 * because its implementation is final and all its methods are static.
 */
public final class GatherSurprises {
    private static final Random random = new Random();

    /**
     * a static method 'gather(int n)',
     * which receives an integer 'n' and returns an array containing 'n' surprises.
     */
    public static ISurprise[] gather(int n) {
        ISurprise[] gatherBag = new ISurprise[n];
        for (int i = 0; i < n; i++) {
            int surpriseNumber = random.nextInt(3);
            gatherBag[i] = getSurprise(surpriseNumber);
        }
        return gatherBag;
    }

    /**
     * a static method, gather (), which will return a single surprise.
     */
    public static ISurprise gather() {
        int surpriseNumber = random.nextInt(3);
        return getSurprise(surpriseNumber);
    }

    public static ISurprise getSurprise(int surpriseNumber) {
        if (surpriseNumber == 0) {
            return FortuneCookie.generate();
        } else if (surpriseNumber == 1) {
            return Candies.generate();
        } else {
            return MinionToy.generate();
        }
    }
}
