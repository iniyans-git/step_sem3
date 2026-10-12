// Week 10 Assignment - Problem 6: Class Attendance Tracker
// Single-pass calculation of total present days and longest streak.
// Time Complexity: O(N), Space Complexity: O(1).

import java.util.Scanner;

public class ClassAttendanceTracker {
    public static void attendanceSummary(int[] days) {
        int presentCount = 0;
        int currentStreak = 0;
        int longestStreak = 0;

        for (int day : days) {
            if (day == 1) {
                presentCount++;
                currentStreak++;
                if (currentStreak > longestStreak) {
                    longestStreak = currentStreak;
                }
            } else {
                currentStreak = 0;
            }
        }

        System.out.println("Present: " + presentCount + ", Longest streak: " + longestStreak);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            line = line.replace("[", "").replace("]", "").replace(",", " ");
            Scanner lineSc = new Scanner(line);
            java.util.List<Integer> list = new java.util.ArrayList<>();
            while (lineSc.hasNextInt()) {
                list.add(lineSc.nextInt());
            }
            if (!list.isEmpty()) {
                int[] days = list.stream().mapToInt(i -> i).toArray();
                attendanceSummary(days);
                return;
            }
        }

        // Default tests from sample
        int[] sample1 = {1, 1, 0, 1, 1, 1, 0, 1};
        attendanceSummary(sample1); // Present: 6, Longest streak: 3

        int[] sample2 = {0, 0, 0};
        attendanceSummary(sample2); // Present: 0, Longest streak: 0
    }
}
