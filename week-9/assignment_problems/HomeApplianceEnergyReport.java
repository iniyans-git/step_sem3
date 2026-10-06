// Week 9 Assignment - Problem 5: Home Appliance Energy Report
// Interface SaverMode for appliances with 25% energy reduction

import java.util.Scanner;

interface SaverMode {
    double applySaverUnits(double standardUnits);
}

abstract class HomeAppliance {
    protected double hours;

    public HomeAppliance(double hours) {
        this.hours = hours;
    }

    public abstract double getPowerWatts();
    public abstract String getApplianceName();

    public double calculateStandardUnits() {
        return (getPowerWatts() * hours) / 1000.0;
    }

    public double calculateCost(double units) {
        return units * 8.0;
    }
}

class FridgeAppliance extends HomeAppliance {
    public FridgeAppliance(double hours) {
        super(hours);
    }

    @Override
    public double getPowerWatts() { return 150.0; }

    @Override
    public String getApplianceName() { return "FRIDGE"; }
}

class AcAppliance extends HomeAppliance implements SaverMode {
    public AcAppliance(double hours) {
        super(hours);
    }

    @Override
    public double getPowerWatts() { return 1500.0; }

    @Override
    public double applySaverUnits(double standardUnits) {
        return standardUnits * 0.75;
    }

    @Override
    public String getApplianceName() { return "AC"; }
}

class TvAppliance extends HomeAppliance {
    public TvAppliance(double hours) {
        super(hours);
    }

    @Override
    public double getPowerWatts() { return 100.0; }

    @Override
    public String getApplianceName() { return "TV"; }
}

class WasherAppliance extends HomeAppliance implements SaverMode {
    public WasherAppliance(double hours) {
        super(hours);
    }

    @Override
    public double getPowerWatts() { return 500.0; }

    @Override
    public double applySaverUnits(double standardUnits) {
        return standardUnits * 0.75;
    }

    @Override
    public String getApplianceName() { return "WASHER"; }
}

public class HomeApplianceEnergyReport {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNext()) return;

        String line = sc.nextLine().trim();
        while (line.isEmpty() && sc.hasNextLine()) {
            line = sc.nextLine().trim();
        }

        // The first token of first line is N
        Scanner lineSc = new Scanner(line);
        int n = lineSc.nextInt();

        double totalCost = 0;
        for (int i = 0; i < n; i++) {
            if (!sc.hasNext()) break;
            String applianceName = sc.next();
            double hours = sc.nextDouble();

            HomeAppliance appliance = null;
            if (applianceName.equals("FRIDGE")) {
                appliance = new FridgeAppliance(hours);
            } else if (applianceName.equals("AC")) {
                appliance = new AcAppliance(hours);
            } else if (applianceName.equals("TV")) {
                appliance = new TvAppliance(hours);
            } else if (applianceName.equals("WASHER")) {
                appliance = new WasherAppliance(hours);
            }

            // Check if next token is "SAVER"
            boolean wantSaver = false;
            if (sc.hasNext("SAVER")) {
                sc.next(); // consume "SAVER"
                wantSaver = true;
            }

            if (appliance != null) {
                if (wantSaver) {
                    if (appliance instanceof SaverMode) {
                        double stdUnits = appliance.calculateStandardUnits();
                        double saverUnits = ((SaverMode) appliance).applySaverUnits(stdUnits);
                        double cost = appliance.calculateCost(saverUnits);
                        totalCost += cost;
                        System.out.printf("%s: Units=%.2f Cost=%.2f ", appliance.getApplianceName(), saverUnits, cost);
                    } else {
                        System.out.printf("%s: saver mode not supported ", appliance.getApplianceName());
                    }
                } else {
                    double stdUnits = appliance.calculateStandardUnits();
                    double cost = appliance.calculateCost(stdUnits);
                    totalCost += cost;
                    System.out.printf("%s: Units=%.2f Cost=%.2f ", appliance.getApplianceName(), stdUnits, cost);
                }
            }
        }
        System.out.printf("Total Cost: %.2f%n", totalCost);
    }
}
