// Week 10 Practice - Problem 3: Even and Odd Numbers in a List
// Counts even and odd numbers in a list of integers.

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EvenAndOddNumbersInList {
    public static void countEvenOdd(List<Integer> numbers) {
        int even = 0;
        int odd = 0;

        for (int num : numbers) {
            if (num % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }

        System.out.println("Even: " + even);
        System.out.println("Odd: " + odd);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();

        if (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            // Clean brackets and commas: e.g. [3, 8, 12, 5, 7, 10]
            line = line.replace("[", "").replace("]", "").replace(",", " ");
            Scanner lineSc = new Scanner(line);
            while (lineSc.hasNextInt()) {
                list.add(lineSc.nextInt());
            }
        }

        if (list.isEmpty()) {
            list = List.of(3, 8, 12, 5, 7, 10);
        }

        countEvenOdd(list);
    }
}
