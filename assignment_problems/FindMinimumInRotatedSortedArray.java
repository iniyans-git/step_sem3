import java.util.Arrays;

public class FindMinimumInRotatedSortedArray {

    public static int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Array cannot be empty");
        }

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {
                // Minimum is in the right half
                left = mid + 1;
            } else {
                // Minimum is at mid or in the left half
                right = mid;
            }
        }

        return nums[left];
    }

    public static void main(String[] args) {
        int[] nums1 = {3, 4, 5, 1, 2};
        System.out.println("Array: " + Arrays.toString(nums1) + " -> Minimum: " + findMin(nums1));

        int[] nums2 = {4, 5, 6, 7, 0, 1, 2};
        System.out.println("Array: " + Arrays.toString(nums2) + " -> Minimum: " + findMin(nums2));

        int[] nums3 = {11, 13, 15, 17};
        System.out.println("Array: " + Arrays.toString(nums3) + " -> Minimum: " + findMin(nums3));
    }
}
