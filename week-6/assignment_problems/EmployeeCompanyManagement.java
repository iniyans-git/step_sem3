// Week 6 Assignment - M5: Employee and Company Information Management
// Demonstrates static fields and static methods

public class EmployeeCompanyManagement {

    static class Employee {
        String empName;
        double salary;

        // Static field shared by ALL employees
        static String companyName = "Bright Horizon Technologies";
        static int employeeCount = 0;

        public Employee(String empName, double salary) {
            this.empName = empName;
            this.salary = salary;
            employeeCount++; // increments each time an Employee is created
        }

        // Static method: must NOT reference any instance field
        public static void printCompanyInfo() {
            System.out.println(companyName);
            System.out.println("Employees on record: " + employeeCount);
        }
    }

    public static void main(String[] args) {
        Employee e1 = new Employee("Divya", 65000);
        Employee e2 = new Employee("Ravi", 50000);
        Employee e3 = new Employee("Arjun", 45000);

        // Call through the class name, not through any object
        Employee.printCompanyInfo();
    }
}
