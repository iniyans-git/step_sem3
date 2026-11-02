// Week 11 Assignment - Problem 3: The Library Book Shelf
// Insertion Sort placing books one by one and printing after each placement.

import java.util.Arrays;
import java.util.Scanner;

public class LibraryBookShelf {

    public static void shelf(int[] books) {
        if (books == null || books.length <= 1) {
            return;
        }

        for (int i = 1; i < books.length; i++) {
            int key = books[i];
            int j = i - 1;

            // Shift elements greater than key to the right
            while (j >= 0 && books[j] > key) {
                books[j + 1] = books[j];
                j--;
            }
            books[j + 1] = key;

            System.out.println("After placing " + key + ": " + Arrays.toString(books));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            line = line.replace("[", "").replace("]", "").replace(",", " ");
            Scanner lineSc = new Scanner(line);
            java.util.List<Integer> list = new java.util.ArrayList<>();
            while (lineSc.hasNextInt()) {
                list.add(lineSc.nextInt());
            }
            if (!list.isEmpty()) {
                int[] books = list.stream().mapToInt(i -> i).toArray();
                shelf(books);
                return;
            }
        }

        // Sample
        System.out.println("--- Sample: books = [30, 10, 40, 20] ---");
        int[] b1 = {30, 10, 40, 20};
        shelf(b1);

        // Custom test
        System.out.println("--- Custom Test: books = [55, 12, 34, 1, 9] ---");
        int[] custom = {55, 12, 34, 1, 9};
        shelf(custom);
    }
}
