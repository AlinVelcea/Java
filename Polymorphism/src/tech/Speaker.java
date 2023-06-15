package tech;

public class Speaker {
    private int speakerMaxVolume;
    private int speakerCrtVolume;

    public Speaker(int speakerMaxVolume) {
        this.speakerMaxVolume = speakerMaxVolume;
        this.speakerCrtVolume = 25;
    }

    public Speaker(int speakerMaxVolume, int speakerCrtVolume) {
        this.speakerMaxVolume = speakerMaxVolume;
        this.speakerCrtVolume = speakerCrtVolume;
    }

    public boolean increaseVolume() {
        if (this.speakerCrtVolume < this.speakerMaxVolume) {
            this.speakerCrtVolume++;
            System.out.println("\t\tclass Microphone: new volume " + this.speakerCrtVolume);
            return true;
        } else {
            return false;
        }
    }

    public boolean decreaseVolume() {
        if(this.speakerCrtVolume > 0) {
            this.speakerCrtVolume--;
            System.out.println("\t\tclass Microphone: new volume " + this.speakerCrtVolume);
            return true;
        } else {
            return false;
        }
    }

    public void setSilenceMode(){
        this.speakerCrtVolume = 0;
        System.out.println("\t\tclass Speaker: Silent -> volume: " + this.speakerCrtVolume);
    }
}
