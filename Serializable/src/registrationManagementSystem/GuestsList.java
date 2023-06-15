package registrationManagementSystem;

import java.io.Serializable;
import java.util.ArrayList;

public class GuestsList implements Serializable {

    private final int maxAvailableSeats;
    private final ArrayList<Guest> participants;
    private final ArrayList<Guest> waitingGuests;

    public GuestsList(int maxAvailableSeats) {
        this.participants = new ArrayList<>(maxAvailableSeats);
        this.waitingGuests = new ArrayList<>();
        this.maxAvailableSeats = maxAvailableSeats;
    }

    //1. Add new person
    /**
     * first we check if the person has been registered;
     * if the person has already registered for the event return -1;
     * if the person received a seat at the event return 0;
     * if the person is on the waiting list return that number;
     */
    public int add(Guest theGuest) {

        boolean registered = this.checkFullName(theGuest.getLastName(), theGuest.getFirstName())
                || this.checkEmailOrPhoneNumber(theGuest.getEmail())
                || this.checkEmailOrPhoneNumber(theGuest.getPhoneNumber());

        if (registered) {
            return -1;
        } else if (this.participants.size() < maxAvailableSeats) {
            participants.add(theGuest);
            return 0;
        } else if (this.participants.size() == maxAvailableSeats) {
            waitingGuests.add(theGuest);
            return waitingGuests.size();
        }
        return -5;
    }

    //2. Check if the person has been registered
    public boolean checkFullName(String lastName, String firstName) {
        for (Guest participant : this.participants) {
            if (participant.hasFullName(lastName, firstName)) {
                return true;
            }
        }

        for (Guest waitingGuest : this.waitingGuests) {
            if (waitingGuest.hasFullName(lastName, firstName)) {
                return true;
            }
        }

        return false;
    }

    public boolean checkEmailOrPhoneNumber(String emailOrPhoneNumber) {
        for (Guest participant : this.participants) {
            if (participant.hasPhoneNumber(emailOrPhoneNumber)
                    || participant.hasEmail(emailOrPhoneNumber)) {
                return true;
            }
        }

        for (Guest waitingGuest : this.waitingGuests) {
            if (waitingGuest.hasPhoneNumber(emailOrPhoneNumber)
                    || waitingGuest.hasEmail(emailOrPhoneNumber)) {
                return true;
            }
        }
        return false;
    }

    //3. Remove a person from the list
    public boolean removeByName(String lastName, String firstName) {
        for (int i = 0; i < this.participants.size(); i++) {
            if(this.participants.get(i).hasFullName(lastName, firstName)) {
                this.participants.remove(i);
                this.transferWaitingGuestsToParticipants();
                return true;
            }
        }

        for (int i = 0; i < this.waitingGuests.size(); i++){
            if (this.waitingGuests.get(i).hasFullName(lastName, firstName)) {
                this.waitingGuests.remove(i);
                return true;
            }
        }
        return false;
    }

    public boolean removeByEmailOrPhoneNumber(String emailOrPhoneNumber) {
        for (int i = 0; i < this.participants.size(); i++) {
            if(this.participants.get(i).hasEmail(emailOrPhoneNumber)
                    || this.participants.get(i).hasPhoneNumber(emailOrPhoneNumber)) {
                this.participants.remove(i);
                this.transferWaitingGuestsToParticipants();
                return true;
            }
        }

        for (int i = 0; i < this.waitingGuests.size(); i++){
            if (this.waitingGuests.get(i).hasEmail(emailOrPhoneNumber)
                    || this.waitingGuests.get(i).hasPhoneNumber(emailOrPhoneNumber)) {
                this.waitingGuests.remove(i);
                return true;
            }
        }
        return false;
    }

    private void transferWaitingGuestsToParticipants() {
        if (!this.waitingGuests.isEmpty() && this.getAvailableSeats() != 0) {
            System.out.println("[" + this.waitingGuests.get(0).getLastName()
                    + " " + this.waitingGuests.get(0).getFirstName()
                    + "] Congratulations! Your place at the event is confirmed."
                    + " We are waiting for you!");
            this.participants.add(this.waitingGuests.remove(0));

        }
    }


    //4. Update person details
    private void updateGuestField(Guest participant, String updateFieldName,
                                  String newFieldValue) {
        switch (updateFieldName) {
            case "lastName" -> participant.setLastName(newFieldValue);
            case "firstName" -> participant.setFirstName(newFieldValue);
            case "email" -> participant.setEmail(newFieldValue);
            case "phoneNumber" -> participant.setPhoneNumber(newFieldValue);
            default -> System.out.println("Error...");
        }
    }

    public boolean searchByNameAndUpdateDetails(String lastName, String firstName,
                                                String updateField, String newName) {
        for (Guest participant : this.participants) {
            if (participant.hasFullName(lastName, firstName)) {
                updateGuestField(participant, updateField, newName);
                return true;
            }
        }

        for (Guest waitingGuest : this.waitingGuests) {
            if (waitingGuest.hasFullName(lastName, firstName)) {
                updateGuestField(waitingGuest, updateField, newName);
                return true;
            }
        }
        return false;
    }

    public boolean searchByEmailOrPhoneAndUpdateDetails(String searchFromEmailOrPhoneNumber,
                                                        String updateField,
                                                        String newEmailOrPhone) {
        for (Guest participant : this.participants) {
            if (participant.hasEmail(searchFromEmailOrPhoneNumber)
                    || participant.hasPhoneNumber(searchFromEmailOrPhoneNumber)) {
                updateGuestField(participant, updateField, newEmailOrPhone);
                return true;
            }
        }

        for (Guest waitingGuest : this.waitingGuests) {
            if (waitingGuest.hasEmail(searchFromEmailOrPhoneNumber)
                    || waitingGuest.hasPhoneNumber(searchFromEmailOrPhoneNumber)) {
                updateGuestField(waitingGuest, updateField, newEmailOrPhone);
                return true;
            }
        }
        return false;
    }

    //5. Getting the list of people who take place at the event
    public ArrayList<Guest> printGuests() {
        if (this.participants.isEmpty()) {
            System.out.println("There are no guest on the list.");
        }
        return this.participants;
    }

    //6. Getting the list of people from the waiting list
    public ArrayList<Guest> printWaitList() {
        if (this.waitingGuests.isEmpty()){
            System.out.println("There are no people on the waiting list.");
        }
        return this.waitingGuests;
    }

    //7. Getting the number of available seats
    public int getAvailableSeats() {
        int availableSeats = this.maxAvailableSeats - this.participants.size();
        return Math.max(availableSeats, 0);
    }

    //8. Getting the number of participants
    public int getNumberOfParticipants() {
        return this.participants.size();
    }

    //9. Getting the number of people from the waiting list
    public int getNumberOfWaitingGuests() {
        return this.waitingGuests.size();
    }

    //10. Getting the total number of people
    public int totalGuests() {
        return this.participants.size() + this.waitingGuests.size();
    }

    //11. Partial search, by a subset of characters
    public ArrayList<Guest> search(String chars) {
        chars = chars.toLowerCase();
        ArrayList<Guest> searchList = new ArrayList<>();
        for (Guest participant : this.participants) {
            if (participant.hasDetails(chars)) {
                searchList.add(participant);
            }
        }

        for (Guest waitingGuests : this.waitingGuests) {
            if (waitingGuests.hasDetails(chars)) {
                searchList.add(waitingGuests);
            }
        }
        return searchList;
    }
}
