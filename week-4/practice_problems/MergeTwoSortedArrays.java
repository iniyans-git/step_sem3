import java.util.Arrays;

public class MergeTwoSortedArrays {

    public static int[] mergeSortedArrays(int[] arr1, int[] arr2) {
        if (arr1 == null) arr1 = new int[0];
        if (arr2 == null) arr2 = new int[0];

        int n1 = arr1.length;
        int n2 = arr2.length;
        int[] result = new int[n1 + n2];

        int i = 0, j = 0, k = 0;

        while (i < n1 && j < n2) {
            if (arr1[i] <= arr2[j]) {
                result[k++] = arr1[i++];
            } else {
                result[k++] = arr2[j++];
            }
        }

        while (i < n1) {
            result[k++] = arr1[i++];
        }

        while (j < n2) {
            result[k++] = arr2[j++];
        }

        return result;
    }

    public static void main(String[] args) {
        int[] a1 = {1, 3, 5};
        int[] a2 = {2, 4, 6};
        System.out.println("Merge " + Arrays.toString(a1) + " and " + Arrays.toString(a2) + ":");
        System.out.println(Arrays.toString(mergeSortedArrays(a1, a2)));

        int[] b1 = {};
        int[] b2 = {1, 2, 3};
        System.out.println("Merge " + Arrays.toString(b1) + " and " + Arrays.toString(b2) + ":");
        System.out.println(Arrays.toString(mergeSortedArrays(b1, b2)));
    }
}
