// Week 11 Practice - Problem 3: Transaction Duplicate Check
// Checks whether any transaction ID appears more than once.
// Time Complexity: O(N) average, Space Complexity: O(N).
// Alternative: Sorting first takes O(N log N) time and O(1) auxiliary space,
// saving memory at the cost of higher runtime.

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class TransactionDuplicateCheck {

    public static boolean hasDuplicate(String[] transactionIds) {
        Set<String> seen = new HashSet<>();
        for (String id : transactionIds) {
            if (!seen.add(id)) {
                return true; // Already exists
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            line = line.replace("[", "").replace("]", "").replace("\"", "").replace("'", "").replace(",", " ");
            String[] tokens = line.split("\\s+");
            System.out.println(hasDuplicate(tokens));
        } else {
            String[] sample1 = {"TXN1001", "TXN1002", "TXN1003", "TXN1002", "TXN1004"};
            System.out.println(hasDuplicate(sample1)); // Expected: true

            String[] sample2 = {"TXN2001", "TXN2002", "TXN2003"};
            System.out.println(hasDuplicate(sample2)); // Expected: false
        }
    }
}
