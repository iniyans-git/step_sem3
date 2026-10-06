// Week 9 Practice - Problem 4: Electricity Connection Billing
// Abstract class Connection with calculateBill()

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class Connection {
    protected double units;

    public Connection(double units) {
        this.units = units;
    }

    public abstract double calculateBill();
    public abstract String getType();
}

class HomeConnection extends Connection {
    public HomeConnection(double units) {
        super(units);
    }

    @Override
    public double calculateBill() {
        if (units <= 100) {
            return units * 5.0;
        } else {
            return (100 * 5.0) + ((units - 100) * 7.0);
        }
    }

    @Override
    public String getType() { return "HOME"; }
}

class ShopConnection extends Connection {
    public ShopConnection(double units) {
        super(units);
    }

    @Override
    public double calculateBill() {
        return (units * 8.0) + 100.0;
    }

    @Override
    public String getType() { return "SHOP"; }
}

class FactoryConnection extends Connection {
    public FactoryConnection(double units) {
        super(units);
    }

    @Override
    public double calculateBill() {
        return Math.max(1000.0, units * 6.0);
    }

    @Override
    public String getType() { return "FACTORY"; }
}

public class ElectricityConnectionBilling {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();

        List<Connection> connections = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double units = sc.nextDouble();

            if (type.equals("HOME")) {
                connections.add(new HomeConnection(units));
            } else if (type.equals("SHOP")) {
                connections.add(new ShopConnection(units));
            } else if (type.equals("FACTORY")) {
                connections.add(new FactoryConnection(units));
            }
        }

        double total = 0;
        for (Connection c : connections) {
            double bill = c.calculateBill();
            total += bill;
            System.out.printf("%s: %.2f%n", c.getType(), bill);
        }
        System.out.printf("Total: %.2f%n", total);
    }
}
