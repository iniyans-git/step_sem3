import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class SubarraySumEqualsK {

    public static int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Map<Integer, Integer> prefixSumCount = new HashMap<>();
        // Base case: a prefix sum of 0 has occurred once before any elements are visited
        prefixSumCount.put(0, 1);

        int currentSum = 0;
        int count = 0;

        for (int num : nums) {
            currentSum += num;
            if (prefixSumCount.containsKey(currentSum - k)) {
                count += prefixSumCount.get(currentSum - k);
            }
            prefixSumCount.put(currentSum, prefixSumCount.getOrDefault(currentSum, 0) + 1);
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 1, 1};
        int k1 = 2;
        System.out.println("Input: " + Arrays.toString(nums1) + ", k = " + k1);
        System.out.println("Subarrays count: " + subarraySum(nums1, k1));

        int[] nums2 = {1, -1, 0};
        int k2 = 0;
        System.out.println("Input: " + Arrays.toString(nums2) + ", k = " + k2);
        System.out.println("Subarrays count: " + subarraySum(nums2, k2));
    }
}
