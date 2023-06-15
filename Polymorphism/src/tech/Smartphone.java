package tech;

public class Smartphone {

    private Screen theScreen;
    private Case theCase;
    private Speaker theSpeaker;
    private Microphone theMicrophone;

    public Smartphone(int pixelsNo, int width, int length, int depth, int speakerMaxVolume, int microphoneMaxVolume) {
        this.theScreen = new Screen(pixelsNo, width, length, depth);
        this.theCase = new Case();
        this.theSpeaker = new Speaker(speakerMaxVolume);
        this.theMicrophone = new Microphone(microphoneMaxVolume);
    }

    public Smartphone(int pixelsNo, int width, int length, int depth, int speakerMaxVolume, int speakerCrtVolume, int microphoneMaxVolume, int microphoneCrtVolume) {
        this.theScreen = new Screen(pixelsNo, width, length, depth);
        this.theCase = new Case();
        this.theSpeaker = new Speaker(speakerMaxVolume, speakerCrtVolume);
        this.theMicrophone = new Microphone(microphoneMaxVolume, microphoneCrtVolume);
    }

    public void pressVolumeUp() {
        System.out.println("class Smartphone: delegate to Case and Speaker");
        this.theCase.pressVolumeUp();
        this.theSpeaker.increaseVolume();
    }

    public void pressVolumeDown() {
        System.out.println("class Smartphone: delegate to Case and Speaker");
        this.theCase.pressVolumeDown();
        this.theSpeaker.decreaseVolume();
    }

    public void setPixel(int index, String colour) {
        System.out.println("class Smartphone: delegate to Screen");
        this.theScreen.setPixel(index, colour);
    }

    public void colorScreen(String colour) {
        System.out.println("class Smartphone: delegate to Screen");
        this.theScreen.colorScreen(colour);
    }

    public void increaseMicrophoneVolume() {
        System.out.println("class Smartphone: delegate to Case and Microphone");
        this.theCase.pressVolumeUp();
        this.theMicrophone.increaseVolume();
    }

    public void decreaseMicrophoneVolume() {
        System.out.println("class Smartphone: delegate to Case and Microphone");
        this.theCase.pressVolumeDown();
        this.theMicrophone.decreaseVolume();
    }

    public void muteMicrophone() {
        System.out.println("class Smartphone: delegate to Case and Microphone");
        this.theCase.pressVolumeDown();
        this.theMicrophone.muteMicrophone();
    }

    public void setSilenceMode() {
        System.out.println("class Smartphone: delegate to Case and Microphone");
        this.theCase.pressVolumeDown();
        this.theSpeaker.setSilenceMode();
    }
}