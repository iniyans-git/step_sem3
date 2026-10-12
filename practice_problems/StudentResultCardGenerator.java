// Week 10 Practice - Problem 10: Student Result Card Generator
// Calculates average mark and assigns grade, printing name in uppercase.

import java.util.Scanner;

class Student {
    private String name;
    private int[] marks;

    public Student(String name, int[] marks) {
        this.name = name;
        this.marks = marks;
    }

    public double calculateAverage() {
        int sum = 0;
        for (int m : marks) {
            sum += m;
        }
        return (double) sum / marks.length;
    }

    public char assignGrade() {
        double avg = calculateAverage();
        if (avg >= 90) return 'A';
        if (avg >= 75) return 'B';
        if (avg >= 60) return 'C';
        if (avg >= 40) return 'D';
        return 'F';
    }

    public void printResultCard() {
        double avg = calculateAverage();
        char grade = assignGrade();
        System.out.printf("%s: Average %.1f, Grade %c%n", name.toUpperCase(), avg, grade);
    }
}

public class StudentResultCardGenerator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean hasInput = false;

        while (sc.hasNext()) {
            hasInput = true;
            String name = sc.next();
            // Read next tokens until bracket closes
            StringBuilder sb = new StringBuilder();
            while (sc.hasNext()) {
                String token = sc.next();
                sb.append(token).append(" ");
                if (token.contains("]")) break;
            }
            String marksStr = sb.toString().replace("[", "").replace("]", "").replace(",", " ").trim();
            Scanner marksSc = new Scanner(marksStr);
            int[] marks = new int[3];
            int idx = 0;
            while (marksSc.hasNextInt() && idx < 3) {
                marks[idx++] = marksSc.nextInt();
            }
            Student student = new Student(name, marks);
            student.printResultCard();
        }

        if (!hasInput) {
            Student s1 = new Student("Asha", new int[]{80, 90, 70});
            s1.printResultCard();
            Student s2 = new Student("Ravi", new int[]{60, 55, 50});
            s2.printResultCard();
        }
    }
}
