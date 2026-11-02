// Week 11 Practice - Problem 10: Remove Duplicates From a Sorted Array In-Place
// Two pointers in-place deduplication of a sorted array.
// Time Complexity: O(N), Space Complexity: O(1).

import java.util.Arrays;
import java.util.Scanner;

public class RemoveDuplicatesSortedArray {

    public static int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int writeIndex = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i - 1]) {
                nums[writeIndex] = nums[i];
                writeIndex++;
            }
        }

        return writeIndex;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] nums;

        if (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            line = line.replace("[", "").replace("]", "").replace(",", " ");
            Scanner lineSc = new Scanner(line);
            java.util.List<Integer> list = new java.util.ArrayList<>();
            while (lineSc.hasNextInt()) {
                list.add(lineSc.nextInt());
            }
            nums = list.stream().mapToInt(i -> i).toArray();
        } else {
            nums = new int[]{1, 1, 2, 2, 2, 3, 4, 4, 5};
        }

        int len = removeDuplicates(nums);
        System.out.println("length = " + len);
        int[] uniquePortion = Arrays.copyOfRange(nums, 0, len);
        System.out.println("nums[0.." + (len - 1) + "] = " + Arrays.toString(uniquePortion));
    }
}
