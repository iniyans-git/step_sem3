// Week 9 Assignment - Problem 3: College Fee Counter
// Interface BusUser for students who use the college bus (12000 transport fee)

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface BusUser {
    double getTransportFee();
}

abstract class CollegeStudent {
    protected String name;

    public CollegeStudent(String name) {
        this.name = name;
    }

    public abstract double getBaseTuition();

    public double calculateTotalFee() {
        double fee = getBaseTuition();
        if (this instanceof BusUser) {
            fee += ((BusUser) this).getTransportFee();
        }
        return fee;
    }
}

class DayScholar extends CollegeStudent implements BusUser {
    public DayScholar(String name) {
        super(name);
    }

    @Override
    public double getBaseTuition() { return 40000.0; }

    @Override
    public double getTransportFee() { return 12000.0; }
}

class Hosteller extends CollegeStudent {
    public Hosteller(String name) {
        super(name);
    }

    @Override
    public double getBaseTuition() { return 40000.0 + 60000.0; } // tuition 40000 + hostel 60000
}

class ScholarStudent extends CollegeStudent implements BusUser {
    public ScholarStudent(String name) {
        super(name);
    }

    @Override
    public double getBaseTuition() { return 20000.0; } // half tuition

    @Override
    public double getTransportFee() { return 12000.0; }
}

public class CollegeFeeCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();

        List<CollegeStudent> students = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();

            if (type.equals("DAY_SCHOLAR")) {
                students.add(new DayScholar(name));
            } else if (type.equals("HOSTELLER")) {
                students.add(new Hosteller(name));
            } else if (type.equals("SCHOLAR")) {
                students.add(new ScholarStudent(name));
            }
        }

        double totalCollected = 0;
        for (CollegeStudent s : students) {
            double fee = s.calculateTotalFee();
            totalCollected += fee;
            System.out.printf("%s: %.2f ", s.name, fee);
        }
        System.out.printf("Total Collected: %.2f%n", totalCollected);
    }
}
