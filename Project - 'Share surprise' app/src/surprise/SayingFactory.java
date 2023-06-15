package surprise;

import java.util.ArrayList;

/**
 * A collection of sayings necessary for FortuneCookie surprise
 */
public class SayingFactory {
    private final ArrayList<String> sayingsList = new ArrayList<>(20);
    private static final String author = "Buddha";

    public SayingFactory() {
        sayingsList.add("If you knew what I know about the power of giving you would not let a single meal pass without sharing it in some way.");
        sayingsList.add("Learn this from water: loud splashes the brook but the oceans depth are calm.");
        sayingsList.add("I never see what has been done; I only see what remains to be done.");
        sayingsList.add("You only lose what you cling to.");
        sayingsList.add("The past is already gone, the future is not yet here. There’s only one moment for you to live.");
        sayingsList.add("The trouble is, you think you have time.");
        sayingsList.add("Your work is to discover your work and then with all your heart to give yourself to it.");
        sayingsList.add("The tongue like a sharp knife… Kills without drawing blood.");
        sayingsList.add("Believe nothing, no matter where you read it, or who said it, no matter if I have said it, unless it agrees with your own reason and your own common sense.");
        sayingsList.add("To abstain from lying is essentially wholesome.");
        sayingsList.add("Avoid evil deeds as a man who loves life avoids poison.");
        sayingsList.add("Holding onto anger is like drinking poison and expecting the other person to die.");
        sayingsList.add("What you think, you become. What you feel, you attract. What you imagine, you create.");
        sayingsList.add("No one saves us but ourselves. No one can and no one may. We ourselves must walk the path.");
        sayingsList.add("Peace comes from within. Do not seek it without.”");
        sayingsList.add("Those who are free of resentful thoughts surely find peace.");
        sayingsList.add("There has to be evil so that good can prove its purity above it.");
        sayingsList.add("To conquer oneself is a greater task than conquering others.");
        sayingsList.add("Everything that has a beginning has an ending. Make your peace with that and all will be well.");
        sayingsList.add("The root of suffering is attachment.");
    }

    /**
     * @return a random message from the sayingList
     */
    public String getRandomSaying(int randomNumber) {
        return sayingsList.get(randomNumber);
    }

    /**
     * @return the author name of the sayings
     */
    public static String getAuthor() {
        return author;
    }

    /**
     * @return sayingsList size
     */
    public int size() {
        return this.sayingsList.size();
    }
}
