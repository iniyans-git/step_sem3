// Week 7 Practice - Problem 5: The Attendance Sheet
// Demonstrates encapsulation: private names array, only count and lookup exposed

public class AttendanceSheet {
    private final String[] presentStudents;
    private int presentCount;

    public AttendanceSheet(int maxClassSize) {
        this.presentStudents = new String[maxClassSize];
        this.presentCount = 0;
    }

    public void markPresent(String name) {
        // Avoid duplicates: check if already present
        for (int i = 0; i < presentCount; i++) {
            if (presentStudents[i].equals(name)) {
                return; // already marked present
            }
        }
        if (presentCount < presentStudents.length) {
            presentStudents[presentCount] = name;
            presentCount++;
        }
    }

    public int getPresentCount() {
        return presentCount;
    }

    public boolean isPresent(String name) {
        for (int i = 0; i < presentCount; i++) {
            if (presentStudents[i].equals(name)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        AttendanceSheet sheet = new AttendanceSheet(30);
        sheet.markPresent("Ana");
        sheet.markPresent("Ben");
        sheet.markPresent("Ana"); // duplicate, should not count again

        System.out.println("Present count: " + sheet.getPresentCount()); // Expected: 2
        System.out.println("Is Ben present? " + sheet.isPresent("Ben"));  // Expected: true
        System.out.println("Is Chen present? " + sheet.isPresent("Chen")); // Expected: false
    }
}
