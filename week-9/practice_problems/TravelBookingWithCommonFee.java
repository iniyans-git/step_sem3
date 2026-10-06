// Week 9 Practice - Problem 5: Travel Booking with a Common Fee
// Abstract class TravelBooking with common booking fee logic

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class TravelBooking {
    protected double distanceKm;
    protected static final double BOOKING_FEE = 50.0;

    public TravelBooking(double distanceKm) {
        this.distanceKm = distanceKm;
    }

    public abstract double calculateBaseFare();
    public abstract String getMode();

    public double calculateTotalFare() {
        return calculateBaseFare() + BOOKING_FEE;
    }
}

class BusBooking extends TravelBooking {
    public BusBooking(double distanceKm) {
        super(distanceKm);
    }

    @Override
    public double calculateBaseFare() {
        return 2.0 * distanceKm;
    }

    @Override
    public String getMode() { return "BUS"; }
}

class TrainBooking extends TravelBooking {
    public TrainBooking(double distanceKm) {
        super(distanceKm);
    }

    @Override
    public double calculateBaseFare() {
        return 1.5 * distanceKm;
    }

    @Override
    public String getMode() { return "TRAIN"; }
}

class FlightBooking extends TravelBooking {
    public FlightBooking(double distanceKm) {
        super(distanceKm);
    }

    @Override
    public double calculateBaseFare() {
        return 2500.0 + (4.0 * distanceKm);
    }

    @Override
    public String getMode() { return "FLIGHT"; }
}

public class TravelBookingWithCommonFee {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();

        List<TravelBooking> bookings = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String mode = sc.next();
            double distance = sc.nextDouble();

            if (mode.equals("BUS")) {
                bookings.add(new BusBooking(distance));
            } else if (mode.equals("TRAIN")) {
                bookings.add(new TrainBooking(distance));
            } else if (mode.equals("FLIGHT")) {
                bookings.add(new FlightBooking(distance));
            }
        }

        for (TravelBooking b : bookings) {
            System.out.printf("%s: %.2f%n", b.getMode(), b.calculateTotalFare());
        }
    }
}
