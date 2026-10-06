// Week 8 Practice - Problem 1: Payment System Fee Calculation
// Demonstrates polymorphism: abstract PaymentMethod with calculateFinalAmount()
// Each subclass applies its own fee. Main loop processes all types uniformly.

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class PaymentMethod {
    protected double amount;

    public PaymentMethod(double amount) {
        this.amount = amount;
    }

    public abstract double calculateFinalAmount();
    public abstract String getType();
}

class CardPayment extends PaymentMethod {
    public CardPayment(double amount) { super(amount); }

    @Override
    public double calculateFinalAmount() {
        return amount * 1.02; // 2% processing fee
    }

    @Override
    public String getType() { return "CARD"; }
}

class WalletPayment extends PaymentMethod {
    public WalletPayment(double amount) { super(amount); }

    @Override
    public double calculateFinalAmount() {
        return amount * 1.01; // 1% processing fee
    }

    @Override
    public String getType() { return "WALLET"; }
}

class BankTransferPayment extends PaymentMethod {
    public BankTransferPayment(double amount) { super(amount); }

    @Override
    public double calculateFinalAmount() {
        return amount; // No processing fee
    }

    @Override
    public String getType() { return "BANKTRANSFER"; }
}

public class PaymentSystemFeeCalculation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());

        List<PaymentMethod> transactions = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String[] parts = sc.nextLine().trim().split("\\s+");
            String type = parts[0];
            double amount = Double.parseDouble(parts[1]);

            switch (type) {
                case "CARD":        transactions.add(new CardPayment(amount)); break;
                case "WALLET":      transactions.add(new WalletPayment(amount)); break;
                case "BANKTRANSFER": transactions.add(new BankTransferPayment(amount)); break;
            }
        }

        double grandTotal = 0;
        for (PaymentMethod pm : transactions) {
            double adjusted = pm.calculateFinalAmount();
            grandTotal += adjusted;
            System.out.printf("%s: %.2f%n", pm.getType(), adjusted);
        }
        System.out.printf("Total: %.2f%n", grandTotal);
    }
}
