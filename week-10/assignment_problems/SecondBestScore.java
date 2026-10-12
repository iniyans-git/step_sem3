// Week 10 Assignment - Problem 7: Second-Best Score
// Finds the second-highest distinct score without sorting.
// Time Complexity: O(N), Space Complexity: O(1).
// (Sorting would take O(N log N) time and O(log N) or O(N) auxiliary space).

import java.util.Scanner;

public class SecondBestScore {
    public static int secondHighest(int[] scores) {
        int highest = -1;
        int second = -1;

        for (int score : scores) {
            if (score > highest) {
                second = highest;
                highest = score;
            } else if (score < highest && score > second) {
                second = score;
            }
        }

        return second;
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
                int[] scores = list.stream().mapToInt(i -> i).toArray();
                System.out.println(secondHighest(scores));
                return;
            }
        }

        // Default tests from sample
        int[] sample1 = {45, 78, 92, 78, 60};
        System.out.println(secondHighest(sample1)); // Expected: 78

        int[] sample2 = {50, 50, 50};
        System.out.println(secondHighest(sample2)); // Expected: -1
    }
}
