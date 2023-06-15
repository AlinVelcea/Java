package exercise2;

import java.io.*;
import java.util.Scanner;

public class Exercise2 {
    public static void main(String[] args) throws IOException {
        try (Scanner reader1 = new Scanner(new FileReader(
                "Numbers1.txt"));
             Scanner reader2 =
                     new Scanner(new FileReader("Numbers2.txt"));
             BufferedWriter writer = new BufferedWriter(new FileWriter(
                     "NumbersMerge.txt"))) {

            int elem1 = reader1.nextInt();
            int elem2 = reader2.nextInt();

            while (reader1.hasNext() && reader2.hasNext()) {
                if (elem1 < elem2) {
                    writer.write(elem1 + " ");
                    elem1 = reader1.nextInt();
                } else {
                    writer.write(elem2 + " ");
                    elem2 = reader2.nextInt();
                }
            }

            while (reader1.hasNext()) {
                if (elem1 < elem2) {
                    writer.write(elem1 + " ");
                    elem1 = reader1.nextInt();
                } else {
                    writer.write(elem2 + " ");
                }
            }

            while (reader2.hasNext()) {
                if (elem1 < elem2) {
                    writer.write(elem1 + " ");
                } else {
                    writer.write(elem2 + " ");
                    elem2 = reader2.nextInt();
                }
            }

            if (elem1 < elem2) {
                writer.write(elem1 + " " + elem2);
            } else {
                writer.write(elem2 + " " + elem1);
            }
        }
    }
}