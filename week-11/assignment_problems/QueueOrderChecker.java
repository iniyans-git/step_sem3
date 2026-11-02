// Week 11 Assignment - Problem 4: Is the Queue in Order?
// Finds the index of the first element that violates non-decreasing order, or -1.
// Time Complexity: O(N), Space Complexity: O(1).

import java.util.Scanner;

public class QueueOrderChecker {

    public static int firstBreak(int[] tokens) {
        if (tokens == null || tokens.length <= 1) {
            return -1;
        }

        for (int i = 1; i < tokens.length; i++) {
            if (tokens[i] < tokens[i - 1]) {
                return i;
            }
        }

        return -1;
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
                int[] tokens = list.stream().mapToInt(i -> i).toArray();
                System.out.println(firstBreak(tokens));
                return;
            }
        }

        // Sample 1
        System.out.println("--- Sample 1: tokens = [3, 5, 5, 8, 6, 9] ---");
        int[] t1 = {3, 5, 5, 8, 6, 9};
        System.out.println(firstBreak(t1)); // Expected: 4 (6 comes after 8)

        // Sample 2
        System.out.println("--- Sample 2: tokens = [1, 2, 2, 7] ---");
        int[] t2 = {1, 2, 2, 7};
        System.out.println(firstBreak(t2)); // Expected: -1

        // Custom test
        System.out.println("--- Custom Test: tokens = [10, 20, 15, 30] ---");
        int[] custom = {10, 20, 15, 30};
        System.out.println(firstBreak(custom)); // Expected: 2
    }
}
