// Week 6 Practice - M5: Student and College Information Management
// Demonstrates static fields and static methods

public class StudentCollegeManagement {

    static class Student {
        String name;
        double attendance;

        // Static field shared by ALL students
        static String collegeName = "SRM Institute of Science and Technology";
        static int studentCount = 0;

        public Student(String name, double attendance) {
            this.name = name;
            this.attendance = attendance;
            studentCount++; // increments each time a Student is created
        }

        // Static method: must NOT reference any instance field
        public static void printCollegeInfo() {
            System.out.println(collegeName);
            System.out.println("Students created: " + studentCount);
        }
    }

    public static void main(String[] args) {
        Student s1 = new Student("Ravi", 85.0);
        Student s2 = new Student("Priya", 90.0);

        // Call through the class name, not through any object
        Student.printCollegeInfo();
    }
}
