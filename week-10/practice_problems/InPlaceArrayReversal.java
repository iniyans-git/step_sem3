// Week 10 Practice - Problem 4: In-Place Array Reversal
// Reverses an array of token numbers directly in-place using two pointers.

import java.util.Arrays;
import java.util.Scanner;

public class InPlaceArrayReversal {
    public static void reverseInPlace(int[] arr) {
        int left = 0;
        int right = arr.length - 1;

        while (left < right) {
            int temp = arr[left];
            arr[left] = arr[right];
            arr[right] = temp;
            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr;

        if (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            line = line.replace("[", "").replace("]", "").replace(",", " ");
            String[] tokens = line.split("\\s+");
            arr = new int[tokens.length];
            for (int i = 0; i < tokens.length; i++) {
                arr[i] = Integer.parseInt(tokens[i]);
            }
        } else {
            arr = new int[]{11, 22, 33, 44};
        }

        reverseInPlace(arr);
        System.out.println(Arrays.toString(arr));
    }
}
