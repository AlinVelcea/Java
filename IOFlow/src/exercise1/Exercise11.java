package exercise1;

import java.io.*;
import java.util.Scanner;

public class Exercise11 {

    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);

        String wordToModify = sc.nextLine();
        String newWord = sc.nextLine();

        try (Scanner scanner =
                     new Scanner(new BufferedReader(new FileReader("TextInput" +
                             ".txt"))) ;
             BufferedWriter writer =
                     new BufferedWriter(new FileWriter("TextOutput.txt"))) {
            while (scanner.hasNextLine()) {
                String nextLine = scanner.nextLine();

                if(nextLine.contains(wordToModify)) {
                    nextLine =
                            nextLine.replace(wordToModify, newWord);
                }

                writer.write(nextLine + System.lineSeparator());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
