package tech;

public class Pixel {
    private String colour;

    public Pixel() {
        this.colour = "#FFFFFF";
    }

    public Pixel(String colour) {
        this.colour = colour;
    }

    public void setPixel(int index, String colour) {
        System.out.println("\t\tclass Pixel: The pixel " + index + " is set to colour " + colour);
    }

}
