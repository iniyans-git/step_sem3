// Week 11 Practice - Problem 9: Pair Sum in a Sorted Array
// Uses two pointers on a sorted array to find a pair summing to target.
// Time Complexity: O(N), Space Complexity: O(1).
// (Unlike hash table which requires O(N) auxiliary memory, two-pointer requires O(1)).

import java.util.Scanner;

public class PairSumSortedArray {

    public static String pairSumSorted(int[] nums, int target) {
        if (nums == null || nums.length < 2) {
            return "Not Found";
        }

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                return "(" + nums[left] + ", " + nums[right] + ")";
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }

        return "Not Found";
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
                System.out.println(pairSumSorted(nums, target));
                return;
            }
        }

        int[] sample1 = {-4, -1, 0, 3, 5, 9};
        System.out.println(pairSumSorted(sample1, 4)); // Expected: (-1, 5)

        int[] sample2 = {1, 2, 3};
        System.out.println(pairSumSorted(sample2, 100)); // Expected: Not Found
    }
}
