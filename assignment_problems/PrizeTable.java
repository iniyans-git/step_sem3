// Week 11 Assignment - Problem 2: The Prize Table
// Selection Sort in descending order, counting only actual swaps made.

import java.util.Arrays;
import java.util.Scanner;

public class PrizeTable {

    public static int prizeTable(int[] marks) {
        if (marks == null || marks.length <= 1) {
            return 0;
        }

        int swaps = 0;
        int n = marks.length;

        for (int i = 0; i < n - 1; i++) {
            int maxIdx = i;
            for (int j = i + 1; j < n; j++) {
                if (marks[j] > marks[maxIdx]) {
                    maxIdx = j;
                }
            }

            // Only swap if the highest mark is not already in position i
            if (maxIdx != i) {
                int temp = marks[i];
                marks[i] = marks[maxIdx];
                marks[maxIdx] = temp;
                swaps++;
            }
        }

        return swaps;
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
                int[] marks = list.stream().mapToInt(i -> i).toArray();
                int swaps = prizeTable(marks);
                System.out.println(Arrays.toString(marks));
                System.out.println("swaps = " + swaps);
                return;
            }
        }

        // Sample 1
        System.out.println("--- Sample 1: marks = [45, 90, 60, 75] ---");
        int[] m1 = {45, 90, 60, 75};
        int s1 = prizeTable(m1);
        System.out.println(Arrays.toString(m1));
        System.out.println("swaps = " + s1);

        // Sample 2
        System.out.println("--- Sample 2: marks = [80, 70, 60] ---");
        int[] m2 = {80, 70, 60};
        int s2 = prizeTable(m2);
        System.out.println(Arrays.toString(m2));
        System.out.println("swaps = " + s2);

        // Custom test
        System.out.println("--- Custom Test: marks = [10, 50, 20, 40, 30] ---");
        int[] custom = {10, 50, 20, 40, 30};
        int sCustom = prizeTable(custom);
        System.out.println(Arrays.toString(custom));
        System.out.println("swaps = " + sCustom);
    }
}
