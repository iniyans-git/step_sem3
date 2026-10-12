// Week 10 Assignment - Problem 4: Exam Score Band Counter
// Uses binary search to count scores in [low, high] in O(log N) time and O(1) space.

import java.util.Scanner;

public class ExamScoreBandCounter {

    /**
     * Finds the first index where scores[index] >= target (lower bound).
     * Time Complexity: O(log N), Space Complexity: O(1).
     */
    public static int lowerBound(int[] scores, int target) {
        int low = 0;
        int high = scores.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (scores[mid] >= target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    /**
     * Finds the first index where scores[index] > target (upper bound).
     * Time Complexity: O(log N), Space Complexity: O(1).
     */
    public static int upperBound(int[] scores, int target) {
        int low = 0;
        int high = scores.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (scores[mid] > target) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    /**
     * Returns the count of scores in range [low, high] inclusive.
     * Time Complexity: O(log N), Space Complexity: O(1).
     * Linear scan would take O(N) time.
     * Duplicates at edges are handled properly: lowerBound finds the first occurrence
     * >= low, while upperBound finds the first element strictly > high, thereby including
     * all duplicates of high.
     */
    public static int countInBand(int[] scores, int low, int high) {
        int start = lowerBound(scores, low);
        int end = upperBound(scores, high);
        return Math.max(0, end - start);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            // Parse scores, low, high if provided
            // Expected line: comma or space separated numbers
            line = line.replace("[", "").replace("]", "").replace(",", " ");
            Scanner lineSc = new Scanner(line);
            java.util.List<Integer> list = new java.util.ArrayList<>();
            while (lineSc.hasNextInt()) {
                list.add(lineSc.nextInt());
            }
            if (list.size() >= 2) {
                int high = list.remove(list.size() - 1);
                int low = list.remove(list.size() - 1);
                int[] scores = list.stream().mapToInt(i -> i).toArray();
                System.out.println(countInBand(scores, low, high));
                return;
            }
        }

        // Default tests from sample
        int[] sampleScores = {35, 42, 42, 50, 58, 58, 58, 63, 71, 88};
        System.out.println(countInBand(sampleScores, 42, 58)); // Expected: 6
        System.out.println(countInBand(sampleScores, 90, 100)); // Expected: 0
    }
}
