// Week 11 Practice - Problem 5: Pair With Target Sum (Unsorted)
// Checks if two distinct elements in an unsorted array sum to target.
// Approach 1 (Implemented): Hash Set - Time O(N), Space O(N).
// Approach 2: Sort + Two Pointers - Time O(N log N), Space O(1).

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class PairWithTargetSumUnsorted {

    public static boolean hasPairWithSum(int[] nums, int target) {
        Set<Integer> seen = new HashSet<>();
        for (int num : nums) {
            int complement = target - num;
            if (seen.contains(complement)) {
                return true;
            }
            seen.add(num);
        }
        return false;
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
            if (list.size() >= 2) {
                int target = list.remove(list.size() - 1);
                int[] nums = list.stream().mapToInt(i -> i).toArray();
                System.out.println(hasPairWithSum(nums, target));
                return;
            }
        }

        int[] sample1 = {2, 7, 11, 15};
        System.out.println(hasPairWithSum(sample1, 9)); // Expected: true

        int[] sample2 = {3, 4, 6};
        System.out.println(hasPairWithSum(sample2, 20)); // Expected: false
    }
}
