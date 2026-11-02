// Week 11 Practice - Problem 1: Library Catalog Lookup
// Implements binary search on a sorted book catalog by ISBN.
// Time Complexity: O(log N), Space Complexity: O(1).

import java.util.Scanner;

public class LibraryCatalogLookup {

    public static class Book {
        public String isbn;
        public String title;

        public Book(String isbn, String title) {
            this.isbn = isbn;
            this.title = title;
        }
    }

    /**
     * Performs binary search on the catalog sorted by ISBN in ascending order.
     * Returns the title if found, or "Not Found" otherwise.
     */
    public static String findBook(Book[] catalog, String targetIsbn) {
        int low = 0;
        int high = catalog.length - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int cmp = catalog[mid].isbn.compareTo(targetIsbn);

            if (cmp == 0) {
                return catalog[mid].title;
            } else if (cmp < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return "Not Found";
    }

    public static void main(String[] args) {
        Book[] catalog = {
            new Book("0001112223", "Introduction to Algebra"),
            new Book("0002223334", "Beginning Python"),
            new Book("0003334445", "Classic Mythology"),
            new Book("0004445556", "Data and Society"),
            new Book("0005556667", "European History")
        };

        Scanner sc = new Scanner(System.in);
        if (sc.hasNext()) {
            String target = sc.next();
            System.out.println(findBook(catalog, target));
        } else {
            System.out.println(findBook(catalog, "0003334445")); // Classic Mythology
            System.out.println(findBook(catalog, "0009998887")); // Not Found
        }
    }
}
