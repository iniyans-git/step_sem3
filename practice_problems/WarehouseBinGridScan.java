// Week 11 Practice - Problem 2: Warehouse Bin Grid Scan
// Scans an m x n grid to find total item count and coordinates of maximum bin.
// Time Complexity: O(m * n), Space Complexity: O(1) beyond input grid.

import java.util.Scanner;

public class WarehouseBinGridScan {

    public static class SummaryResult {
        public int total;
        public int maxRow;
        public int maxCol;

        public SummaryResult(int total, int maxRow, int maxCol) {
            this.total = total;
            this.maxRow = maxRow;
            this.maxCol = maxCol;
        }

        @Override
        public String toString() {
            return "total = " + total + ", maxCoordinate = (" + maxRow + ", " + maxCol + ")";
        }
    }

    public static SummaryResult warehouseSummary(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return new SummaryResult(0, -1, -1);
        }

        int total = 0;
        int maxVal = -1;
        int maxRow = 0;
        int maxCol = 0;

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                int val = grid[r][c];
                total += val;
                // Strict inequality ensures first encountered bin is kept on tie
                if (val > maxVal) {
                    maxVal = val;
                    maxRow = r;
                    maxCol = c;
                }
            }
        }

        return new SummaryResult(total, maxRow, maxCol);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextInt()) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            int[][] grid = new int[m][n];
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    grid[i][j] = sc.nextInt();
                }
            }
            System.out.println(warehouseSummary(grid));
        } else {
            int[][] sampleGrid = {
                {4, 9, 2},
                {7, 1, 6},
                {3, 12, 5}
            };
            System.out.println(warehouseSummary(sampleGrid));
            // Output: total = 49, maxCoordinate = (2, 1)
        }
    }
}
