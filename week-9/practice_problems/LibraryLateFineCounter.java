// Week 9 Practice - Problem 3: Library Late Fine Counter
// Abstract class LibraryItemLate with calculateFine()

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class LibraryItemLate {
    protected String title;
    protected int daysLate;

    public LibraryItemLate(String title, int daysLate) {
        this.title = title;
        this.daysLate = daysLate;
    }

    public abstract double calculateFine();
}

class BookLate extends LibraryItemLate {
    public BookLate(String title, int daysLate) {
        super(title, daysLate);
    }

    @Override
    public double calculateFine() {
        return daysLate * 2.0;
    }
}

class DvdLate extends LibraryItemLate {
    public DvdLate(String title, int daysLate) {
        super(title, daysLate);
    }

    @Override
    public double calculateFine() {
        return Math.min(50.0, daysLate * 5.0);
    }
}

class MagazineLate extends LibraryItemLate {
    public MagazineLate(String title, int daysLate) {
        super(title, daysLate);
    }

    @Override
    public double calculateFine() {
        return daysLate * 1.0;
    }
}

public class LibraryLateFineCounter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (!sc.hasNextInt()) return;
        int n = sc.nextInt();

        List<LibraryItemLate> items = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String title = sc.next();
            int daysLate = sc.nextInt();

            if (type.equals("BOOK")) {
                items.add(new BookLate(title, daysLate));
            } else if (type.equals("DVD")) {
                items.add(new DvdLate(title, daysLate));
            } else if (type.equals("MAGAZINE")) {
                items.add(new MagazineLate(title, daysLate));
            }
        }

        double totalFines = 0;
        for (LibraryItemLate item : items) {
            double fine = item.calculateFine();
            totalFines += fine;
            System.out.printf("%s: %.2f%n", item.title, fine);
        }
        System.out.printf("Total Fines: %.2f%n", totalFines);
    }
}
