package registrationManagementSystem;

import java.io.*;

public class ReadFromBinaryFile implements Serializable {
    private static final File readFile = new File("output.dat");


    public static GuestsList readFromBinaryFile() throws IOException {

        GuestsList guestsList = null;

        try (ObjectInputStream reader =
                     new ObjectInputStream(new BufferedInputStream(new FileInputStream(readFile)))) {
            guestsList = (GuestsList) reader.readObject();
        } catch (ClassNotFoundException e) {
            System.out.println("A class not found exception: " + e.getMessage());
        }
        return guestsList;
    }

    public static void main(String[] args) throws IOException{
        GuestsList guestsList = ReadFromBinaryFile.readFromBinaryFile();
        for (Guest participant : guestsList.printGuests()) {
            System.out.println(participant);
        }
    }
}
