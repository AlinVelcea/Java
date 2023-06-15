package surprise;

import java.util.Random;

/**
 * It is a Fortune Cookie-type surprise in which the person will receive
 * a symbolic message to guide them in the future.
 */
public class FortuneCookie implements ISurprise {
    private String message;
    private static SayingFactory theSayingFactory = new SayingFactory();
    private static Random random = new Random();

    /**
     * The class receives the message (i.e. String) when constructing the object.
     */
    public FortuneCookie(String message) {
        this.message = message;
    }

    /**
     * The method will generate a random number and choose the element from the array accordingly.
     * @return a new FortuneCookie surprise
     */
    public static FortuneCookie generate() {
        int rand = random.nextInt(theSayingFactory.size());
        return new FortuneCookie(theSayingFactory.getRandomSaying(rand));
    }

    /**
     * The message that is received as a parameter in the constructor
     * will be displayed at the output when the "surprise opens".
     */
    @Override
    public void enjoy() {
        System.out.println("Enjoy fortune cookie surprise: " + this.message + " (" + SayingFactory.getAuthor() + ")");
    }

    @Override
    public String toString() {
        return "Fortune cookie: " + this.message + " (" + SayingFactory.getAuthor() + ")";
    }
}
