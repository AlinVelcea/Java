package exercise3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Exercise3 {

    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter words (stop - for result): ");

        List<String> sortedWords = new ArrayList<>();

        String word = sc.nextLine();
        sortedWords.add(word);

        String shortestWord = word;
        String longestWord = word;

        while (true) {
            String nextWord = sc.nextLine();
            if (nextWord.equals("stop")) {
                break;
            }

            if (nextWord.length() < shortestWord.length()) {
                shortestWord = nextWord;
            }

            if (nextWord.length() > longestWord.length()) {
                longestWord = nextWord;
            }
            sortedWords.add(nextWord);
        }

        Collections.sort(sortedWords);

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(
                "result" +
                        ".txt"))) {

            writer.write("1. The shortest word is: " + shortestWord + System.lineSeparator());
            writer.write("2. The longest word id: " + longestWord + System.lineSeparator());
            writer.write("3. First word sorted alphabetically: " + sortedWords.get(0) + System.lineSeparator());
            writer.write("4. Last word sorted alphabetically: " + sortedWords.get(sortedWords.size() - 1) + System.lineSeparator());
            writer.write("5. Numbers of words: " + sortedWords.size() + System.lineSeparator());
        }
    }
}
