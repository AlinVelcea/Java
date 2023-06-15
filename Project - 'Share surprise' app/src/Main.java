import share.GiveSurpriseAndApplause;
import share.GiveSurpriseAndHug;
import share.GiveSurpriseAndSing;
import storage.IBag;
import surprise.Candies;
import surprise.FortuneCookie;
import surprise.ISurprise;
import surprise.MinionToy;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        System.out.println("\nWelcome to \"Share Surprise\" App\n");

        // Create surprises
        ISurprise surprise1 = GatherSurprises.gather();
        ISurprise surprise2 = GatherSurprises.gather();
        ISurprise surprise3 = GatherSurprises.gather();
        ISurprise surprise4 = GatherSurprises.gather();
        ISurprise surprise5 = GatherSurprises.gather();
        ISurprise surprise6 = GatherSurprises.gather();
        ISurprise surprise7 = GatherSurprises.gather();
        ISurprise surprise8 = GatherSurprises.gather();
        ISurprise surprise9 = GatherSurprises.gather();
        int noSurprise = 6;
        ISurprise[] surpriseArr4 = GatherSurprises.gather(noSurprise);
        ISurprise[] surpriseArr5 = GatherSurprises.gather(noSurprise);

        //Create types of bags
        GiveSurpriseAndApplause applause1 = new GiveSurpriseAndApplause("RANDOM", 1);
        GiveSurpriseAndHug hug1 = new GiveSurpriseAndHug("FIFO", 2);
        GiveSurpriseAndSing sing1 = new GiveSurpriseAndSing("LIFO", 3);
        GiveSurpriseAndApplause applause2 = new GiveSurpriseAndApplause("FIFO", 1);

        //Enjoy App
        System.out.println("------------------  APPLAUSE: ----------------------------");
        applause1.put(surprise1);
        applause1.put(surprise2);
        applause1.put(surprise3);
        applause1.put(surprise4);
        applause1.put(surprise5);
        applause1.put(surprise6);
        applause1.put(surprise7);
        applause1.put(surprise8);
        applause1.put(surprise9);
        System.out.println("SIZE: " + applause1.size());
        applause1.give();
        System.out.println("SIZE: " + applause1.size());
        System.out.println("START GIVE ALL");
        applause1.giveAll();
        System.out.println("END GIVE ALL");
        System.out.println("SIZE: " + applause1.size());
        System.out.println(applause1.isEmpty());
        applause1.put(surprise1);
        System.out.println(applause1.isEmpty());
        applause1.give();
        applause1.put(surpriseArr4);
        System.out.println("SIZE: " + applause1.size());

        System.out.println("------------ SING: ---------------------");
        sing1.put(surprise1);
        sing1.put(surprise2);
        sing1.put(surprise3);
        sing1.put(surprise4);
        sing1.put(surprise5);
        sing1.put(surprise6);
        sing1.put(surprise7);
        sing1.put(surprise8);
        sing1.put(surprise9);
        System.out.println("SIZE: " + sing1.size());
        sing1.give();
        System.out.println("START GIVE ALL");
        sing1.giveAll();
        System.out.println("END GIVE ALL");
        System.out.println("EMPTY? : " + sing1.isEmpty());
        sing1.put(applause1.getBag());
        sing1.give();
        System.out.println("START GIVE ALL");
        sing1.giveAll();
        System.out.println("END GIVE ALL");
        sing1.give();
        System.out.println("EMPTY? : " + sing1.isEmpty());
        sing1.give();
        sing1.isEmpty();
        System.out.println("SIZE: " + sing1.size());
        sing1.give();
        System.out.println("EMPTY? : " + sing1.isEmpty());
        sing1.give();
        System.out.println("EMPTY? : " + sing1.isEmpty());
        sing1.give();
        System.out.println("EMPTY? : " + sing1.isEmpty());
        sing1.give();
        sing1.put(surpriseArr5);
        System.out.println("EMPTY? : " + sing1.isEmpty());
        sing1.give();
        System.out.println("EMPTY? : " + sing1.isEmpty());
        sing1.give();
        System.out.println("EMPTY? : " + sing1.isEmpty());
        sing1.give();
        System.out.println("EMPTY? : " + sing1.isEmpty());
        sing1.give();
        System.out.println("EMPTY? : " + sing1.isEmpty());

        System.out.println("------------------  HUG ----------------------------");
        hug1.put(surpriseArr4);
        hug1.put(surpriseArr5);
        System.out.println("SIZE: " + hug1.size());
        System.out.println("START GIVE ALL");
        hug1.giveAll();
        System.out.println("END GIVE ALL");
        hug1.put(surpriseArr4);
        hug1.give();
        System.out.println("START GIVE ALL");
        hug1.giveAll();
        System.out.println("END GIVE ALL");
        hug1.put(sing1.getBag());

        System.out.println("------------------  APPLAUSE: ----------------------------");
        applause2.put(applause1.getBag());
        System.out.println("START GIVE ALL");
        applause2.giveAll();
        System.out.println("EMPTY? : " + applause2.isEmpty());
        System.out.println("END GIVE ALL");
        applause2.give();
        applause2.put(surprise2);
        System.out.println("SIZE: " + applause2.size());
        applause2.put(surprise1);
        applause2.give();
        applause2.give();
        System.out.println("START GIVE ALL");
        applause2.giveAll();
        System.out.println("END GIVE ALL");
        System.out.println("SIZE: " + applause2.size());

        System.out.println("\nThank you");
    }
}
