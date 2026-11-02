// Week 11 Practice - Problem 4: Employee ID Lookup in an Unsorted Directory
// Prepares an unsorted list of records into a hash map for O(1) repeated lookups.
// Time Complexity: O(1) per lookup, O(N) build time. Space Complexity: O(N).

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class EmployeeDirectoryLookup {

    public static class EmployeeRecord {
        public String id;
        public String department;

        public EmployeeRecord(String id, String department) {
            this.id = id;
            this.department = department;
        }
    }

    public static Map<String, String> buildLookup(EmployeeRecord[] records) {
        Map<String, String> lookup = new HashMap<>();
        for (EmployeeRecord record : records) {
            lookup.put(record.id, record.department);
        }
        return lookup;
    }

    public static String getDepartment(Map<String, String> lookup, String employeeId) {
        return lookup.getOrDefault(employeeId, "Unknown");
    }

    public static void main(String[] args) {
        EmployeeRecord[] records = {
            new EmployeeRecord("E245", "Finance"),
            new EmployeeRecord("E110", "Engineering"),
            new EmployeeRecord("E390", "Marketing"),
            new EmployeeRecord("E101", "Engineering")
        };

        Map<String, String> lookup = buildLookup(records);

        Scanner sc = new Scanner(System.in);
        if (sc.hasNext()) {
            String id = sc.next();
            System.out.println(getDepartment(lookup, id));
        } else {
            System.out.println(getDepartment(lookup, "E390")); // Expected: Marketing
            System.out.println(getDepartment(lookup, "E999")); // Expected: Unknown
        }
    }
}
