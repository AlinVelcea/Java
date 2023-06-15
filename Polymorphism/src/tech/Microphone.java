package tech;

public class Microphone {
    private int microphoneMaxVolume;
    private int microphoneCrtVolume;

    public Microphone(int microphoneMaxVolume) {
        this.microphoneMaxVolume = microphoneMaxVolume;
        this.microphoneCrtVolume = 25;
    }

    public Microphone(int microphoneMaxVolume, int microphoneCrtVolume) {
        this.microphoneMaxVolume = microphoneMaxVolume;
        this.microphoneCrtVolume = microphoneCrtVolume;
    }

    public boolean increaseVolume() {
        if (this.microphoneCrtVolume < this.microphoneMaxVolume) {
            this.microphoneCrtVolume++;
            System.out.println("\t\tclass Microphone: new volume " + this.microphoneCrtVolume );
            return true;
        } else {
            System.out.println("\t\tclass Microphone: Warning - max volume " + this.microphoneMaxVolume );
            return false;
        }
    }

    public boolean decreaseVolume() {
        if(this.microphoneCrtVolume > 0) {
            this.microphoneCrtVolume--;
            System.out.println("\t\tclass Microphone: new volume " + this.microphoneCrtVolume );
            return true;
        } else {
            System.out.println("\t\tclass Microphone: Warning - min volume " + this.microphoneMaxVolume );
            return false;
        }
    }

    public void muteMicrophone(){
        this.microphoneCrtVolume = 0;
        System.out.println("\t\tclass Microphone: Microphone mute -> volume: " + this.microphoneCrtVolume);
    }
}
