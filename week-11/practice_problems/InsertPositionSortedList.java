// Week 11 Practice - Problem 7: Insert Position in a Sorted List
// Binary search for target or its insertion index in a sorted array of distinct integers.
// Time Complexity: O(log N), Space Complexity: O(1).

import java.util.Scanner;

public class InsertPositionSortedList {

    public static int searchInsertPosition(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return low; // insertion index
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
                System.out.println(searchInsertPosition(nums, target));
                return;
            }
        }

        int[] sample = {1, 3, 5, 6};
        System.out.println(searchInsertPosition(sample, 5)); // Expected: 2
        System.out.println(searchInsertPosition(sample, 2)); // Expected: 1
    }
}
