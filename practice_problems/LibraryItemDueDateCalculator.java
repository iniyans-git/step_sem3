// Week 8 Practice - Problem 2: Library Item Due Date Calculator
// Demonstrates polymorphism: abstract LibraryItem with getDueDays()
// Current date is fixed at 2023-10-26 as per the problem statement.

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

abstract class LibraryItem {
    protected String title;

    public LibraryItem(String title) {
        this.title = title;
    }

    public abstract int getBorrowingDays();
    public abstract String getType();

    public LocalDate getDueDate(LocalDate currentDate) {
        return currentDate.plusDays(getBorrowingDays());
    }
}

class BookItem extends LibraryItem {
    public BookItem(String title) { super(title); }

    @Override
    public int getBorrowingDays() { return 14; }

    @Override
    public String getType() { return "BOOK"; }
}

class DvdItem extends LibraryItem {
    public DvdItem(String title) { super(title); }

    @Override
    public int getBorrowingDays() { return 7; }

    @Override
    public String getType() { return "DVD"; }
}

class MagazineItem extends LibraryItem {
    public MagazineItem(String title) { super(title); }

    @Override
    public int getBorrowingDays() { return 3; }

    @Override
    public String getType() { return "MAGAZINE"; }
}

public class LibraryItemDueDateCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine().trim());
        LocalDate currentDate = LocalDate.of(2023, 10, 26);

        List<LibraryItem> items = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            // Remove surrounding quotes if present in title
            int spaceIdx = line.indexOf(' ');
            String type = line.substring(0, spaceIdx);
            String title = line.substring(spaceIdx + 1).replace("\"", "");

            switch (type) {
                case "BOOK":     items.add(new BookItem(title)); break;
                case "DVD":      items.add(new DvdItem(title)); break;
                case "MAGAZINE": items.add(new MagazineItem(title)); break;
            }
        }

        for (LibraryItem item : items) {
            LocalDate dueDate = item.getDueDate(currentDate);
            System.out.println(item.title + ": " + dueDate);
        }
    }
}
