// Week 11 Assignment - Problem 1: The Height Line-Up
// Bubble Sort with adjacent swaps and early termination flag.
// Prints the array after each pass from left to right.

import java.util.Arrays;
import java.util.Scanner;

public class HeightLineUp {

    public static void lineUp(int[] heights) {
        if (heights == null || heights.length <= 1) {
            if (heights != null) {
                System.out.println("Pass 1: " + Arrays.toString(heights));
            }
            return;
        }

        for (int i = 0; i < heights.length - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < heights.length - 1 - i; j++) {
                if (heights[j] > heights[j + 1]) {
                    int temp = heights[j];
                    heights[j] = heights[j + 1];
                    heights[j + 1] = temp;
                    swapped = true;
                }
            }

            System.out.println("Pass " + (i + 1) + ": " + Arrays.toString(heights));

            // If no swaps occurred, the array is already sorted
            if (!swapped) {
                break;
            }
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
                int[] heights = list.stream().mapToInt(i -> i).toArray();
                lineUp(heights);
                return;
            }
        }

        // Sample 1
        System.out.println("--- Sample 1: heights = [4, 2, 5, 1] ---");
        int[] h1 = {4, 2, 5, 1};
        lineUp(h1);

        // Sample 2
        System.out.println("--- Sample 2: heights = [1, 3, 2, 4] ---");
        int[] h2 = {1, 3, 2, 4};
        lineUp(h2);

        // Custom test
        System.out.println("--- Custom Test: heights = [5, 4, 3, 2, 1] ---");
        int[] custom = {5, 4, 3, 2, 1};
        lineUp(custom);
    }
}
