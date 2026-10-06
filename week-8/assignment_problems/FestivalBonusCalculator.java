// Week 8 Assignment - Problem 4: The Festival Bonus Calculator
// Polymorphism: abstract Employee with calculateBonus()
// Full-time: 10%; Part-time: 5%; Intern: fixed Rs 2000

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class EmployeeBonus {
    protected String name;
    protected double monthlySalary;

    public EmployeeBonus(String name, double monthlySalary) {
        this.name = name;
        this.monthlySalary = monthlySalary;
    }

    public abstract double calculateBonus();
}

class FullTimeEmployee extends EmployeeBonus {
    public FullTimeEmployee(String name, double salary) { super(name, salary); }

    @Override
    public double calculateBonus() {
        return monthlySalary * 0.10;
    }
}

class PartTimeEmployee extends EmployeeBonus {
    public PartTimeEmployee(String name, double salary) { super(name, salary); }

    @Override
    public double calculateBonus() {
        return monthlySalary * 0.05;
    }
}

class Intern extends EmployeeBonus {
    public Intern(String name, double salary) { super(name, salary); }

    @Override
    public double calculateBonus() {
        return 2000; // fixed bonus regardless of salary
    }
}

public class FestivalBonusCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        List<EmployeeBonus> employees = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String type = parts[0];
            String name = parts[1];
            double salary = Double.parseDouble(parts[2]);

            switch (type) {
                case "FULLTIME": employees.add(new FullTimeEmployee(name, salary)); break;
                case "PARTTIME": employees.add(new PartTimeEmployee(name, salary)); break;
                case "INTERN":   employees.add(new Intern(name, salary)); break;
            }
        }

        double totalBonus = 0;
        for (EmployeeBonus e : employees) {
            double bonus = e.calculateBonus();
            totalBonus += bonus;
            System.out.printf("%s: %.2f%n", e.name, bonus);
        }
        System.out.printf("Total Bonus: %.2f%n", totalBonus);
    }
}
