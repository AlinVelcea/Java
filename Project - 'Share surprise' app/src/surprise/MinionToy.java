package surprise;

import java.util.ArrayList;

/**
 * The surprise will be a Minion toy.
 */
public class MinionToy implements ISurprise{

    private String minionName;
    private static final ArrayList<String> minions = createMinions();
    private static int currentMinionIndex = -1;

    /**
     * The class receives the name of the minion when creating objects.
     */
    public MinionToy(String minionName) {
        this.minionName = minionName;
    }

    /**
     * Collection of types of minions
     * @return the collection of minions
     */
    private static ArrayList<String> createMinions() {
      ArrayList<String> minions = new ArrayList<>();
      minions.add("Dave");
      minions.add("Carl");
      minions.add("Kevin");
      minions.add("Stuart");
      minions.add("Jerry");
      minions.add("Tim");
      return minions;
    }

    /**
     * When generating a new surprise, the next type of minion will be chosen in order,
     * according to the ordered collection presented previously.
     * @return a new minion toy surprise
     */
    public static MinionToy generate() {
        currentMinionIndex =  (currentMinionIndex + 1) % minions.size();
        return new MinionToy(minions.get(currentMinionIndex));
    }

    /**
     * When the surprise opens, a suggestive message will be displayed at the output,
     * which includes the details of the received toy.
     */
    @Override
    public void enjoy() {
        System.out.println("Enjoy minion toy surprise: " + this.minionName);
    }

    @Override
    public String toString() {
        return "Minion toy surprise: " + this.minionName;
    }
}
