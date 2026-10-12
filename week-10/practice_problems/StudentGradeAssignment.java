// Week 10 Practice - Problem 8: Student Grade Assignment
// Assigns a grade based on marks: A (>=90), B (75-89), C (60-74), D (40-59), F (<40).

import java.util.Scanner;

public class StudentGradeAssignment {
    public static void printGrade(int marks) {
        if (marks >= 90) {
            System.out.println("Grade A");
        } else if (marks >= 75) {
            System.out.println("Grade B");
        } else if (marks >= 60) {
            System.out.println("Grade C");
        } else if (marks >= 40) {
            System.out.println("Grade D");
        } else {
            System.out.println("Grade F");
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            while (sc.hasNextInt()) {
                int marks = sc.nextInt();
                printGrade(marks);
            }
        } else {
            printGrade(72);
            printGrade(95);
            printGrade(35);
        }
    }
}
