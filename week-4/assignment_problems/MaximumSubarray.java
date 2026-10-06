import java.util.Arrays;

public class MaximumSubarray {

    public static int maxSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int currentSum = nums[0];
        int maxSum = nums[0];

        for (int i = 1; i < nums.length; i++) {
            // Extend existing subarray vs restart fresh from current element
            currentSum = Math.max(nums[i], currentSum + nums[i]);
            maxSum = Math.max(maxSum, currentSum);
        }

        return maxSum;
    }

    public static void main(String[] args) {
        int[] nums1 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println("Array: " + Arrays.toString(nums1));
        System.out.println("Maximum Subarray Sum: " + maxSubArray(nums1));

        int[] nums2 = {-3, -1, -2};
        System.out.println("Array: " + Arrays.toString(nums2));
        System.out.println("Maximum Subarray Sum: " + maxSubArray(nums2));
    }
}
