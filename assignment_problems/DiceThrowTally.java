// Week 11 Assignment - Problem 5: The Dice Throw Tally
// Counting Sort for die rolls (values 1 to 6) without comparing elements.
// Time Complexity: O(N + K) where K = 6, Space Complexity: O(K).

import java.util.Arrays;
import java.util.Scanner;

public class DiceThrowTally {

    public static int[] diceSort(int[] rolls) {
        if (rolls == null) {
            return new int[0];
        }

        int[] count = new int[7]; // indices 1..6
        for (int r : rolls) {
            if (r >= 1 && r <= 6) {
                count[r]++;
            }
        }

        // Print frequency counts
        StringBuilder sb = new StringBuilder("Counts: ");
        for (int v = 1; v <= 6; v++) {
            sb.append(v).append(":").append(count[v]);
            if (v < 6) {
                sb.append(" ");
            }
        }
        System.out.println(sb.toString());

        // Reconstruct sorted array
        int[] sorted = new int[rolls.length];
        int idx = 0;
        for (int v = 1; v <= 6; v++) {
            for (int c = 0; c < count[v]; c++) {
                sorted[idx++] = v;
            }
        }

        return sorted;
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
                int[] rolls = list.stream().mapToInt(i -> i).toArray();
                int[] sorted = diceSort(rolls);
                System.out.println("Sorted: " + Arrays.toString(sorted));
                return;
            }
        }

        // Sample
        System.out.println("--- Sample: rolls = [4, 1, 6, 4, 2, 1, 4] ---");
        int[] sample = {4, 1, 6, 4, 2, 1, 4};
        int[] sortedSample = diceSort(sample);
        System.out.println("Sorted: " + Arrays.toString(sortedSample));

        // Custom test
        System.out.println("--- Custom Test: rolls = [6, 5, 4, 3, 2, 1, 6, 1] ---");
        int[] custom = {6, 5, 4, 3, 2, 1, 6, 1};
        int[] sortedCustom = diceSort(custom);
        System.out.println("Sorted: " + Arrays.toString(sortedCustom));
    }
}
