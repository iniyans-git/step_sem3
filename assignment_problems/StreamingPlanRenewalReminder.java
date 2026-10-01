// Week 8 Assignment - Problem 5: The Streaming Plan Renewal Reminder
// Polymorphism: abstract SubscriptionPlan with getValidityDays()
// Basic: 30 days, Standard: 90 days, Premium: 365 days

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class SubscriptionPlan {
    protected String name;
    protected LocalDate startDate;

    public SubscriptionPlan(String name, LocalDate startDate) {
        this.name = name;
        this.startDate = startDate;
    }

    public abstract int getValidityDays();

    public LocalDate getRenewalDate() {
        return startDate.plusDays(getValidityDays());
    }
}

class BasicPlan extends SubscriptionPlan {
    public BasicPlan(String name, LocalDate startDate) { super(name, startDate); }

    @Override
    public int getValidityDays() { return 30; }
}

class StandardPlan extends SubscriptionPlan {
    public StandardPlan(String name, LocalDate startDate) { super(name, startDate); }

    @Override
    public int getValidityDays() { return 90; }
}

class PremiumPlan extends SubscriptionPlan {
    public PremiumPlan(String name, LocalDate startDate) { super(name, startDate); }

    @Override
    public int getValidityDays() { return 365; }
}

public class StreamingPlanRenewalReminder {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        List<SubscriptionPlan> subscribers = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String planType = parts[0];
            String name = parts[1];
            LocalDate startDate = LocalDate.parse(parts[2]);

            switch (planType) {
                case "BASIC":    subscribers.add(new BasicPlan(name, startDate)); break;
                case "STANDARD": subscribers.add(new StandardPlan(name, startDate)); break;
                case "PREMIUM":  subscribers.add(new PremiumPlan(name, startDate)); break;
            }
        }

        for (SubscriptionPlan plan : subscribers) {
            System.out.println(plan.name + ": " + plan.getRenewalDate());
        }
    }
}
