// Week 10 Assignment - Problem 8: Duty Roster Rotation
// Rotates the array of names to the right by k places in O(N) time and O(N) space.
// Using k % n handles large k (up to 10^9) in O(1) arithmetic instead of O(k * N) one-by-one rotations.

import java.util.Arrays;
import java.util.Scanner;

public class DutyRosterRotation {
    public static String[] rotateRoster(String[] names, long k) {
        int n = names.length;
        if (n <= 1) return names;

        int shift = (int) (k % n);
        if (shift == 0) return names;

        String[] rotated = new String[n];
        for (int i = 0; i < n; i++) {
            rotated[(i + shift) % n] = names[i];
        }
        return rotated;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            line = line.replace("[", "").replace("]", "").replace(",", " ");
            String[] tokens = line.split("\\s+");
            if (tokens.length >= 2) {
                long k = Long.parseLong(tokens[tokens.length - 1]);
                String[] names = Arrays.copyOf(tokens, tokens.length - 1);
                String[] res = rotateRoster(names, k);
                System.out.println(Arrays.toString(res));
                return;
            }
        }

        // Default tests from sample
        String[] sample1 = {"A", "B", "C", "D", "E"};
        System.out.println(Arrays.toString(rotateRoster(sample1, 2))); // [D, E, A, B, C]

        String[] sample2 = {"A", "B", "C", "D", "E"};
        System.out.println(Arrays.toString(rotateRoster(sample2, 7))); // [D, E, A, B, C]
    }
}
