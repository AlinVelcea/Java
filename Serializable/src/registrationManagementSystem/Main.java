package registrationManagementSystem;

import java.io.*;

public class Main {
    private static final File file = new File("src/input.txt");
    private static BufferedReader br;
    private static final File writingFile = new File("output.dat");

    public static void writeToBinaryFile(GuestsList guestsList) throws IOException {
        try (ObjectOutputStream binaryFileOutRentedCars =
                     new ObjectOutputStream(new BufferedOutputStream(new FileOutputStream(writingFile)))) {
            binaryFileOutRentedCars.writeObject(guestsList);
        }
    }
    /**
     * help menu
     */
    public static void help() {
        System.out.println(""
                + "\n\thelp            - Display this command list;"
                + "\n\tadd             - Add a new person (sign up);"
                + "\n\tcheck           - Check if a person is registered for " +
                "the event;"
                + "\n\tremove          - Delete an existing person from the " +
                "list;"
                + "\n\tupdate          - Updates a person's details;"
                + "\n\tguests          - List of people participating in the " +
                "event;"
                + "\n\twaitlist        - People on the waiting list;"
                + "\n\tavailable       - Number of vacancies;"
                + "\n\tguests_no       - Number of people participating in " +
                "the event;"
                + "\n\twaitlist_no     - Number of people on the waiting list;"
                + "\n\tsubscribe_no    - Total number of people registered;"
                + "\n\tsearch          - Search all invitations by the string" +
                " entered;"
                + "\n\tquit            - close application.\n");
    }

    /**
     * authentication menu
     *
     * @return an int with choice to authentication
     */
    public static int authenticationMenu() throws IOException {
        System.out.println("Choose the authentication mode, typing:\n" +
                "\"1\" - Name and surname\n" +
                "\"2\" - Email\n" +
                "\"3\" - Phone number (format \"+40733386463\")");
        return Integer.parseInt(br.readLine());
    }

    public static String writeDetails(String writeField) throws IOException {
        switch (writeField) {
            case "lastName" -> {
                System.out.println("Enter the last name:");
                return br.readLine();
            }
            case "firstName" -> {
                System.out.println("Enter the first name:");
                return br.readLine();
            }
            case "email" -> {
                System.out.println("Enter email:");
                return br.readLine();
            }
            case "phoneNumber" -> {
                System.out.println("Enter phone number:");
                return br.readLine();
            }
            default -> {
                System.out.println("Error...");
                return null;
            }
        }

    }


    /**
     * adding a new person (registered)
     * Obs: it is checked if the respective person is not already registered
     * for the event
     * in addition, the registered person will be notified accordingly,
     * depending on the list in which he was registered:
     * participation confirmation → Congratulations! Your place at the event
     * is confirmed. We are waiting for you!.
     * waiting list → You have successfully signed up for the waiting list
     * and received the wait number <X>. We will notify you if a place becomes
     * available.
     */
    public static Guest readGuestInput() throws IOException {
        String lastName = writeDetails("lastName");
        String firstName = writeDetails("firstName");
        String email = writeDetails("email");
        String phoneNumber = writeDetails("phoneNumber");
        return new Guest(lastName, firstName, email, phoneNumber);
    }

    public static void add(GuestsList guestsList) throws IOException {
        Guest guest = readGuestInput();
        int answer = guestsList.add(guest);
        if (answer == -1) {
            System.out.println("[" + guest.getLastName() + " "
                    + guest.getFirstName()
                    + "] You are already registered. Congratulations!");
        } else if (answer == 0) {
            System.out.println("[" + guest.getLastName()
                    + " " + guest.getFirstName()
                    + "] Congratulations! Your place at the event is confirmed."
                    + " We are waiting for you!");
        } else if (answer > 0) {
            System.out.println("[" + guest.getLastName()
                    + " " + guest.getFirstName()
                    + "] You have successfully signed up for the waiting list" +
                    " and received the wait number <"
                    + answer + ">. We will notify you if a place becomes " +
                    "available");
        } else {
            System.out.println("Registered failed");
        }
    }

    /**
     * determines if a person is registered for the event (in any list).
     * the search for the person can be done after:
     * a.lastName and firstName OR
     * b.email OR
     * c.phoneNumber
     * Obs: the class will allow you to search for a participant according
     * to each of the above criteria
     */
    public static boolean isPersonRegistered(GuestsList guestsList) throws IOException {
        int choice = authenticationMenu();
        switch (choice) {
            case 1 -> {
                System.out.println("Check name & surname...");
                String lastName = writeDetails("lastName");
                String firstName = writeDetails("firstName");
                return guestsList.checkFullName(lastName, firstName);
            }
            case 2 -> {
                System.out.println("Check email...");
                String email = writeDetails("email");
                return guestsList.checkEmailOrPhoneNumber(email);
            }
            case 3 -> {
                System.out.println("Check phone number...");
                String phoneNumber = writeDetails("phoneNumber");
                return guestsList.checkEmailOrPhoneNumber(phoneNumber);
            }
        }
        return false;
    }

    /**
     * removal of a person (registered)
     * the search for the person can be done after:
     * a.lastName and firstName OR
     * b.email OR
     * c.phoneNumber
     * Obs: the class will allow the search and respectively the elimination
     * of a participant according to each criterion mentioned above
     * will return a boolean value, as follows:
     * true - the person was successfully removed
     * false - error: the person was not registered
     * Obs: the person can be on both the list of participants and the
     * waiting list
     * Obs2: if a person is removed from the participation list and there are
     * people on the waiting list, the first person on the waiting list will be
     * (1) moved to the participation list and (2) notified accordingly.
     * The notification is made according to the above specifications.
     */
    public static void remove(GuestsList guestsList) throws IOException {
        int choice = authenticationMenu();
        switch (choice) {
            case 1 -> {
                String lastName = writeDetails("lastName");
                String firstName = writeDetails("firstName");
                System.out.println(guestsList.removeByName(lastName, firstName)
                        ? "The remove of the person was successful."
                        : "Error. You are not on the lists.");
            }
            case 2 -> {
                String email = writeDetails("email");
                System.out.println(guestsList.removeByEmailOrPhoneNumber(email)
                        ? "The remove of the person was successful."
                        : "Error. You are not on the lists.");
            }
            case 3 -> {
                String phoneNumber = writeDetails("phoneNumber");
                System.out.println(guestsList.removeByEmailOrPhoneNumber(phoneNumber)
                        ? "The remove of the person was successful."
                        : "Error. You are not on the lists.");
            }
        }
    }

    /**
     * the method with the field to be updated
     */
    public static String updateMenu() throws IOException {
        System.out.println("Choose the update field, typing:\n" +
                "\"1\" - Name\n" +
                "\"2\" - First name\n" +
                "\"3\" - Email\n" +
                "\"4\" - Phone number (format \"+40733386463\")");

        if (Integer.parseInt(br.readLine()) == 1) {
            return "lastName";
        } else if (Integer.parseInt(br.readLine()) == 2) {
            return "firstName";
        } else if (Integer.parseInt(br.readLine()) == 3) {
            return "email";
        } else if (Integer.parseInt(br.readLine()) == 4) {
            return "phoneNumber";
        } else {
            return "Error";
        }
    }

    /**
     * the method where the new value for the chosen field will be entered
     */
    public static String updateField(String choice) throws IOException {
        return writeDetails(choice);
    }

    /**
     * updating the details of a registered person
     * any of the fields can be updated
     * Obs: the class will allow searching and updating a participant
     * according to each criterion mentioned above
     */
    public static void update(GuestsList guestsList) throws IOException {
        int auth = authenticationMenu();
        if (auth == 1) {
            String lastName = writeDetails("lastName");
            String firstName = writeDetails("firstName");
            String updateField = updateMenu();
            String newName = updateField(updateField);
            System.out.println(guestsList.searchByNameAndUpdateDetails(lastName,
                    firstName, updateField, newName)
                    ? "The update of the person was successful."
                    : "Update unsuccessful");
        } else if (auth == 2) {
            String email = writeDetails("email");
            String updateField = updateMenu();
            String newEmail = updateField(updateField);
            System.out.println(guestsList.searchByEmailOrPhoneAndUpdateDetails(email,
                    updateField, newEmail)
                    ? "The update of the person was successful."
                    : "Update unsuccessful");
        } else {
            String phoneNumber = writeDetails("phoneNumber");
            String updateField = updateMenu();
            String newPhoneNumber = updateField(updateField);
            System.out.println(guestsList.searchByEmailOrPhoneAndUpdateDetails(phoneNumber
                    , updateField, newPhoneNumber)
                    ? "The update of the person was successful."
                    : "Update unsuccessful");
        }
    }

    /**
     * partial search, by a subset of characters:
     * the method receives a string as a parameter.
     * It is searched anywhere in the contact (i.e. in each field,
     * starting with any position).
     * a list of contacts that meet the search criteria is returned
     * the empty list indicates the lack of people
     * Obs: the search is insensitive houses
     */
    public static void search(GuestsList guestsList) throws IOException {
        String substring = br.readLine();
        for (int i = 0; i < guestsList.search(substring).size(); i++) {
            System.out.print("Contact " + (i + 1) + ": "
                    + guestsList.search(substring).get(i) + "\n");
        }
    }

    public static int checkMaxAvailableSeats(int maxAvailableSeats) throws IOException {
        if (maxAvailableSeats <= 0) {
            System.out.println("Wrong number of available seats. Enter again:" +
                    " ");
            maxAvailableSeats = Integer.parseInt(br.readLine());
            maxAvailableSeats = checkMaxAvailableSeats(maxAvailableSeats);
        }
        return maxAvailableSeats;
    }

    public static void main(String[] args) throws IOException {
        br = new BufferedReader(new FileReader(file));
        System.out.println("Welcome! Enter the number of available seats:");
        int maxAvailableSeats = Integer.parseInt(br.readLine());
        maxAvailableSeats = checkMaxAvailableSeats(maxAvailableSeats);
        GuestsList guestsList = new GuestsList(maxAvailableSeats);

        try {
            boolean quit = false;
            while (!quit) {
                System.out.println("Wait command: (help - Show command list)");
                String command = br.readLine();
                switch (command) {
                    case "help" -> help();
                    case "add" -> {
                        System.out.println("Adding a new person...");
                        add(guestsList);
                    }
                    case "check" -> {
                        System.out.println("Checking an existing person from " +
                                "the list…");
                        if (isPersonRegistered(guestsList)) {
                            System.out.println("You are registered!");
                        } else {
                            System.out.println("You are not on the lists.");
                        }
                    }
                    case "remove" -> {
                        System.out.println("Removing an existing person from " +
                                "the list…");
                        remove(guestsList);
                    }
                    case "update" -> {
                        System.out.println("Update an existing person from " +
                                "the list…");
                        update(guestsList);
                    }
                    case "guests" -> {
                        int guestsNumberOnList = 1;
                        for (Guest participant : guestsList.printGuests()) {
                            System.out.print(guestsNumberOnList + ". "
                                    + participant + " \n");
                            guestsNumberOnList++;
                        }
                    }
                    case "waitlist" -> {
                        int guestsNumberOnWaitlist = 1;
                        for (Guest waitingGuest : guestsList.printWaitList()) {
                            System.out.print(guestsNumberOnWaitlist + ". "
                                    + waitingGuest + " \n");
                            guestsNumberOnWaitlist++;
                        }
                    }
                    case "available" -> System.out.println("Available seats: "
                            + guestsList.getAvailableSeats());
                    case "guests_no" -> System.out.println("Number of " +
                            "participants: "
                            + guestsList.getNumberOfParticipants());
                    case "waitlist_no" -> System.out.println("Number of " +
                            "waiting guests: "
                            + guestsList.getNumberOfWaitingGuests());
                    case "subscribe_no" -> System.out.println("Total guests: "
                            + guestsList.totalGuests());
                    case "search" -> {
                        System.out.println("Enter the substring:");
                        search(guestsList);
                    }
                    case "quit" -> {
                        Main.writeToBinaryFile(guestsList);
                        System.out.println("\nWe are glad you used the " +
                                "application, see you soon!");
                        quit = true;
                    }
                    default -> System.out.println("Wrong command. Please " +
                            "enter again:");
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Error...");
        }
    }
}
