// Week 9 Assignment - Problem 4: City Cab Fare Meter
// Interface NightService for cabs offering night service (+20%)

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

interface NightService {
    double applyNightMultiplier(double baseFare);
}

abstract class CityCab {
    protected double km;

    public CityCab(double km) {
        this.km = km;
    }

    public abstract double getRatePerKm();
    public abstract String getCabType();

    public double calculateDayFare() {
        return Math.max(100.0, km * getRatePerKm());
    }
}

class MiniCab extends CityCab {
    public MiniCab(double km) {
        super(km);
    }

    @Override
    public double getRatePerKm() { return 10.0; }

    @Override
    public String getCabType() { return "MINI"; }
}

class SedanCab extends CityCab implements NightService {
    public SedanCab(double km) {
        super(km);
    }

    @Override
    public double getRatePerKm() { return 14.0; }

    @Override
    public double applyNightMultiplier(double baseFare) {
        return baseFare * 1.20;
    }

    @Override
    public String getCabType() { return "SEDAN"; }
}

class SuvCab extends CityCab implements NightService {
    public SuvCab(double km) {
        super(km);
    }

    @Override
    public double getRatePerKm() { return 18.0; }

    @Override
    public double applyNightMultiplier(double baseFare) {
        return baseFare * 1.20;
    }

    @Override
    public String getCabType() { return "SUV"; }
}

public class CityCabFareMeter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();

        double totalCollected = 0;
        for (int i = 0; i < n; i++) {
            String cabType = sc.next();
            double km = sc.nextDouble();
            String time = sc.next();

            CityCab cab = null;
            if (cabType.equals("MINI")) {
                cab = new MiniCab(km);
            } else if (cabType.equals("SEDAN")) {
                cab = new SedanCab(km);
            } else if (cabType.equals("SUV")) {
                cab = new SuvCab(km);
            }

            if (cab != null) {
                if (time.equals("NIGHT")) {
                    if (cab instanceof NightService) {
                        double dayFare = cab.calculateDayFare();
                        double nightFare = ((NightService) cab).applyNightMultiplier(dayFare);
                        totalCollected += nightFare;
                        System.out.printf("%s: %.2f ", cab.getCabType(), nightFare);
                    } else {
                        System.out.printf("%s: night service not available ", cab.getCabType());
                    }
                } else {
                    double dayFare = cab.calculateDayFare();
                    totalCollected += dayFare;
                    System.out.printf("%s: %.2f ", cab.getCabType(), dayFare);
                }
            }
        }
        System.out.printf("Total: %.2f%n", totalCollected);
    }
}
