// Week 9 Assignment - Problem 1: Movie Ticket Counter
// Abstract class MovieTicket with common convenience fee (20)

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class MovieTicket {
    protected int count;
    protected static final double CONVENIENCE_FEE = 20.0;

    public MovieTicket(int count) {
        this.count = count;
    }

    public abstract double getPricePerTicket();
    public abstract String getSeatType();

    public double calculateTotalAmount() {
        return count * (getPricePerTicket() + CONVENIENCE_FEE);
    }
}

class RegularTicket extends MovieTicket {
    public RegularTicket(int count) {
        super(count);
    }

    @Override
    public double getPricePerTicket() { return 150.0; }

    @Override
    public String getSeatType() { return "REGULAR"; }
}

class PremiumTicket extends MovieTicket {
    public PremiumTicket(int count) {
        super(count);
    }

    @Override
    public double getPricePerTicket() { return 250.0; }

    @Override
    public String getSeatType() { return "PREMIUM"; }
}

class ReclinerTicket extends MovieTicket {
    public ReclinerTicket(int count) {
        super(count);
    }

    @Override
    public double getPricePerTicket() { return 400.0; }

    @Override
    public String getSeatType() { return "RECLINER"; }
}

public class MovieTicketCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();

        List<MovieTicket> bookings = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String seat = sc.next();
            int count = sc.nextInt();

            if (seat.equals("REGULAR")) {
                bookings.add(new RegularTicket(count));
            } else if (seat.equals("PREMIUM")) {
                bookings.add(new PremiumTicket(count));
            } else if (seat.equals("RECLINER")) {
                bookings.add(new ReclinerTicket(count));
            }
        }

        double total = 0;
        for (MovieTicket t : bookings) {
            double amount = t.calculateTotalAmount();
            total += amount;
            System.out.printf("%s: %.2f ", t.getSeatType(), amount);
        }
        System.out.printf("Total: %.2f%n", total);
    }
}
