package tech;

import java.util.ArrayList;

public class Screen {
    private ArrayList<Pixel> pixels;
    private Dimensions dimensions;
    private Pixel thePixel = new Pixel();

    public Screen(int pixelsNo, int width, int length, int depth){
        this.pixels = new ArrayList<Pixel>(pixelsNo);
        // add pixels to pixels list
        this.dimensions = new Dimensions(width, length, depth);
    }

    public void setPixel(int index, String colour) {
        System.out.println("\tclass Screen: delegate to Pixel");
        thePixel.setPixel(index, colour);
    }

    public void colorScreen(String colour) {
        System.out.println("\tclass Screen: all screen colour is " + colour);
    }
}
