import java.util.Arrays;

public class ProductExceptSelf {

    public static int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[]{};
        }

        int n = nums.length;
        int[] answer = new int[n];

        // Forward pass: prefix products
        answer[0] = 1;
        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }

        // Backward pass: suffix products
        int suffix = 1;
        for (int i = n - 1; i >= 0; i--) {
            answer[i] = answer[i] * suffix;
            suffix *= nums[i];
        }

        return answer;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 4};
        System.out.println("Input: " + Arrays.toString(nums1));
        System.out.println("Output: " + Arrays.toString(productExceptSelf(nums1)));

        int[] nums2 = {-1, 1, 0, -3, 3};
        System.out.println("Input: " + Arrays.toString(nums2));
        System.out.println("Output: " + Arrays.toString(productExceptSelf(nums2)));
    }
}
