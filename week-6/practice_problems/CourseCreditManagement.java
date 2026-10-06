// Week 6 Practice - M3: Course Credit Management
// Demonstrates constructor chaining with this(...)

public class CourseCreditManagement {

    static class Course {
        String code;
        String title;
        int credits;
        int labCredits;

        // Four-argument constructor
        public Course(String code, String title, int credits, int labCredits) {
            this.code = code;
            this.title = title;
            this.credits = credits;
            this.labCredits = labCredits;
        }

        // Three-argument constructor for theory-only courses (chains via this(...))
        public Course(String code, String title, int credits) {
            this(code, title, credits, 0);
        }

        public int totalCredits() {
            return credits + labCredits;
        }
    }

    public static void main(String[] args) {
        Course theoryCourse = new Course("21CSC201J", "Data Structures", 4);
        Course labCourse = new Course("21CSC205L", "DSA Lab", 3, 1);

        System.out.println(theoryCourse.code + " total credits: " + theoryCourse.totalCredits());
        System.out.println(labCourse.code + " total credits: " + labCourse.totalCredits());
    }
}
