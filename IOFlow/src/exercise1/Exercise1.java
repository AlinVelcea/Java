package exercise1;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Exercise1 {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        String wordToModify= sc.nextLine();
        String newWord = sc.nextLine();

        String oldContent = "";

        try (Scanner scanner = new Scanner (new FileReader("TextInput.txt"))){
            while (scanner.hasNextLine()) {
                String nextLine = scanner.nextLine();
                oldContent = oldContent + nextLine + System.lineSeparator();
            }
        }

        String newContent = oldContent.replaceAll(wordToModify, newWord);

        try (FileWriter writer = new FileWriter("TextInput.txt")) {
            writer.write(newContent);
        }
    }
}
