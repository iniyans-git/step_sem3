// Week 8 Assignment - Problem 3: The Hostel Electricity Bill
// Polymorphism: abstract Room with calculateBill()
// Single: Rs 8/unit; Shared: Rs 6/unit / occupants; AC: Rs 10/unit + Rs 200 fixed

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class Room {
    protected int units;

    public Room(int units) {
        this.units = units;
    }

    public abstract double calculateBill();
    public abstract String getType();
}

class SingleRoom extends Room {
    public SingleRoom(int units) { super(units); }

    @Override
    public double calculateBill() {
        return 8.0 * units;
    }

    @Override
    public String getType() { return "SINGLE"; }
}

class SharedRoom extends Room {
    private int occupants;

    public SharedRoom(int units, int occupants) {
        super(units);
        this.occupants = occupants;
    }

    @Override
    public double calculateBill() {
        return (6.0 * units) / occupants;
    }

    @Override
    public String getType() { return "SHARED"; }
}

class AcRoom extends Room {
    public AcRoom(int units) { super(units); }

    @Override
    public double calculateBill() {
        return (10.0 * units) + 200;
    }

    @Override
    public String getType() { return "AC"; }
}

public class HostelElectricityBill {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        List<Room> rooms = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String type = parts[0];
            int units = Integer.parseInt(parts[1]);

            switch (type) {
                case "SINGLE": rooms.add(new SingleRoom(units)); break;
                case "SHARED": {
                    int occupants = Integer.parseInt(parts[2]);
                    rooms.add(new SharedRoom(units, occupants));
                    break;
                }
                case "AC": rooms.add(new AcRoom(units)); break;
            }
        }

        double grandTotal = 0;
        for (Room r : rooms) {
            double bill = r.calculateBill();
            grandTotal += bill;
            System.out.printf("%s: %.2f%n", r.getType(), bill);
        }
        System.out.printf("Total: %.2f%n", grandTotal);
    }
}
