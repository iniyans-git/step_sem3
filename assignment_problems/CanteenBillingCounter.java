// Week 8 Assignment - Problem 1: The Canteen Billing Counter
// Polymorphism: abstract Customer with calculateFinalAmount()
// Students: 10% discount, Staff: 5% discount, Guests: full + Rs 10 service charge

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class Customer {
    protected double billAmount;

    public Customer(double billAmount) {
        this.billAmount = billAmount;
    }

    public abstract double calculateFinalAmount();
    public abstract String getType();
}

class StudentCustomer extends Customer {
    public StudentCustomer(double amount) { super(amount); }

    @Override
    public double calculateFinalAmount() {
        return billAmount * 0.90; // 10% discount
    }

    @Override
    public String getType() { return "STUDENT"; }
}

class StaffCustomer extends Customer {
    public StaffCustomer(double amount) { super(amount); }

    @Override
    public double calculateFinalAmount() {
        return billAmount * 0.95; // 5% discount
    }

    @Override
    public String getType() { return "STAFF"; }
}

class GuestCustomer extends Customer {
    public GuestCustomer(double amount) { super(amount); }

    @Override
    public double calculateFinalAmount() {
        return billAmount + 10; // full amount + Rs 10 service charge
    }

    @Override
    public String getType() { return "GUEST"; }
}

public class CanteenBillingCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        List<Customer> customers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String type = parts[0];
            double amount = Double.parseDouble(parts[1]);

            switch (type) {
                case "STUDENT": customers.add(new StudentCustomer(amount)); break;
                case "STAFF":   customers.add(new StaffCustomer(amount)); break;
                case "GUEST":   customers.add(new GuestCustomer(amount)); break;
            }
        }

        double grandTotal = 0;
        for (Customer c : customers) {
            double final_ = c.calculateFinalAmount();
            grandTotal += final_;
            System.out.printf("%s: %.2f%n", c.getType(), final_);
        }
        System.out.printf("Total: %.2f%n", grandTotal);
    }
}
