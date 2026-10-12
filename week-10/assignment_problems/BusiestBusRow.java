// Week 10 Assignment - Problem 10: Busiest Bus Row
// Finds the row with the maximum total passengers in a 2D seat grid.
// If two rows tie, the row with the smaller index is chosen.
// Time Complexity: O(R * C), Space Complexity: O(1).

import java.util.Scanner;

public class BusiestBusRow {
    public static void busiestRow(int[][] grid) {
        int bestRow = 0;
        int maxTotal = -1;

        for (int r = 0; r < grid.length; r++) {
            int rowTotal = 0;
            for (int c = 0; c < grid[r].length; c++) {
                rowTotal += grid[r][c];
            }
            // Strict inequality ensures tie breaks in favor of smaller index
            if (rowTotal > maxTotal) {
                maxTotal = rowTotal;
                bestRow = r;
            }
        }

        System.out.println("Row " + bestRow + ", Total " + maxTotal);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            int rows = sc.nextInt();
            int cols = sc.nextInt();
            int[][] grid = new int[rows][cols];
            for (int r = 0; r < rows; r++) {
                for (int c = 0; c < cols; c++) {
                    grid[r][c] = sc.nextInt();
                }
            }
            busiestRow(grid);
            return;
        }

        // Default test from sample
        int[][] sampleGrid = {
            {2, 0, 1},
            {3, 3, 1},
            {1, 1, 1}
        };
        busiestRow(sampleGrid); // Expected: Row 1, Total 7
    }
}
