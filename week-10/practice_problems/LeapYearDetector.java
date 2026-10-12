// Week 10 Practice - Problem 9: Leap Year Detector
// Determines whether a year is a leap year (divisible by 4, but not 100 unless divisible by 400).

import java.util.Scanner;

public class LeapYearDetector {
    public static boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    public static void checkYear(int year) {
        if (isLeapYear(year)) {
            System.out.println("Leap year");
        } else {
            System.out.println("Not a leap year");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            while (sc.hasNextInt()) {
                int year = sc.nextInt();
                checkYear(year);
            }
        } else {
            checkYear(2024);
            checkYear(1900);
            checkYear(2000);
        }
    }
}
