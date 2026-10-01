// Week 8 Practice - Problem 5: Public Transport Fare Calculator
// Demonstrates polymorphism: abstract Transport with calculateFare()

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class Transport {
    protected double distance;

    public Transport(double distance) {
        this.distance = distance;
    }

    public abstract double calculateFare();
    public abstract String getType();
}

class BusTransport extends Transport {
    public BusTransport(double distance) { super(distance); }

    @Override
    public double calculateFare() {
        double fare = 2 + (0.10 * distance);
        return Math.min(fare, 10); // Max fare $10
    }

    @Override
    public String getType() { return "BUS"; }
}

class TrainTransport extends Transport {
    public TrainTransport(double distance) { super(distance); }

    @Override
    public double calculateFare() {
        return 3 + (0.15 * distance);
    }

    @Override
    public String getType() { return "TRAIN"; }
}

class MetroTransport extends Transport {
    private double peakHourFactor;

    public MetroTransport(double distance, double peakHourFactor) {
        super(distance);
        this.peakHourFactor = peakHourFactor;
    }

    @Override
    public double calculateFare() {
        return (1.50 + (0.20 * distance)) * peakHourFactor;
    }

    @Override
    public String getType() { return "METRO"; }
}

public class PublicTransportFareCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        List<Transport> journeys = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String type = parts[0];
            double distance = Double.parseDouble(parts[1]);

            switch (type) {
                case "BUS":   journeys.add(new BusTransport(distance)); break;
                case "TRAIN": journeys.add(new TrainTransport(distance)); break;
                case "METRO": {
                    double peakFactor = Double.parseDouble(parts[2]);
                    journeys.add(new MetroTransport(distance, peakFactor));
                    break;
                }
            }
        }

        double grandTotal = 0;
        for (Transport t : journeys) {
            double fare = t.calculateFare();
            grandTotal += fare;
            System.out.printf("%s: %.2f%n", t.getType(), fare);
        }
        System.out.printf("Total: %.2f%n", grandTotal);
    }
}
