package tech;

public class TestDevices {
    public static void main(String[] args) {
        Smartphone samsung = new Smartphone(1_000_000, 4, 5, 6, 100, 54, 100, 34);
        samsung.colorScreen("green");
        samsung.setPixel(5, "black");
        samsung.decreaseMicrophoneVolume();
        samsung.pressVolumeUp();
        samsung.pressVolumeUp();
        samsung.pressVolumeDown();
        samsung.increaseMicrophoneVolume();
        samsung.decreaseMicrophoneVolume();
        samsung.muteMicrophone();
        samsung.setSilenceMode();
        Smartphone iphone = new Smartphone(1_000_000, 6, 5, 4, 100, 0, 100, 88);
        iphone.decreaseMicrophoneVolume();
        iphone.colorScreen("orange");
        iphone.setPixel(1, "yellow");
        iphone.decreaseMicrophoneVolume();
        iphone.pressVolumeUp();
        iphone.pressVolumeUp();
        iphone.pressVolumeDown();
        iphone.increaseMicrophoneVolume();
        iphone.decreaseMicrophoneVolume();
        iphone.muteMicrophone();
        iphone.setSilenceMode();

    }
}