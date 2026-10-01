// Week 8 Practice - Problem 3: Delivery Fee Calculator
// Demonstrates polymorphism: abstract Delivery with calculateFee()

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class Delivery {
    protected double weight;
    protected double distance;

    public Delivery(double weight, double distance) {
        this.weight = weight;
        this.distance = distance;
    }

    public abstract double calculateFee();
    public abstract String getType();
}

class StandardDelivery extends Delivery {
    public StandardDelivery(double weight, double distance) { super(weight, distance); }

    @Override
    public double calculateFee() {
        return 5 + (0.50 * weight) + (0.10 * distance);
    }

    @Override
    public String getType() { return "STANDARD"; }
}

class ExpressDelivery extends Delivery {
    public ExpressDelivery(double weight, double distance) { super(weight, distance); }

    @Override
    public double calculateFee() {
        return 15 + (1.00 * weight) + (0.20 * distance);
    }

    @Override
    public String getType() { return "EXPRESS"; }
}

class InternationalDelivery extends Delivery {
    private double customsFee;

    public InternationalDelivery(double weight, double distance, double customsFee) {
        super(weight, distance);
        this.customsFee = customsFee;
    }

    @Override
    public double calculateFee() {
        return 25 + (2.00 * weight) + (0.50 * distance) + customsFee;
    }

    @Override
    public String getType() { return "INTERNATIONAL"; }
}

public class DeliveryFeeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        List<Delivery> deliveries = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String type = parts[0];
            double weight = Double.parseDouble(parts[1]);
            double distance = Double.parseDouble(parts[2]);

            switch (type) {
                case "STANDARD":      deliveries.add(new StandardDelivery(weight, distance)); break;
                case "EXPRESS":       deliveries.add(new ExpressDelivery(weight, distance)); break;
                case "INTERNATIONAL": {
                    double customsFee = Double.parseDouble(parts[3]);
                    deliveries.add(new InternationalDelivery(weight, distance, customsFee));
                    break;
                }
            }
        }

        double grandTotal = 0;
        for (Delivery d : deliveries) {
            double fee = d.calculateFee();
            grandTotal += fee;
            System.out.printf("%s: %.2f%n", d.getType(), fee);
        }
        System.out.printf("Total: %.2f%n", grandTotal);
    }
}
