// Week 11 Practice - Problem 8: Spiral Order Traversal
// Returns all elements of an m x n 2D grid in clockwise spiral order.
// Time Complexity: O(m * n), Space Complexity: O(1) auxiliary (excluding output list).

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SpiralOrderTraversal {

    public static List<Integer> spiralOrder(int[][] grid) {
        List<Integer> result = new ArrayList<>();
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return result;
        }

        int top = 0;
        int bottom = grid.length - 1;
        int left = 0;
        int right = grid[0].length - 1;

        while (top <= bottom && left <= right) {
            // Traverse from left to right across top row
            for (int col = left; col <= right; col++) {
                result.add(grid[top][col]);
            }
            top++;

            // Traverse downwards along right column
            for (int row = top; row <= bottom; row++) {
                result.add(grid[row][right]);
            }
            right--;

            // Traverse from right to left across bottom row
            if (top <= bottom) {
                for (int col = right; col >= left; col--) {
                    result.add(grid[bottom][col]);
                }
                bottom--;
            }

            // Traverse upwards along left column
            if (left <= right) {
                for (int row = bottom; row >= top; row--) {
                    result.add(grid[row][left]);
                }
                left++;
            }
        }

        return result;
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
            System.out.println(spiralOrder(grid));
        } else {
            int[][] sampleGrid = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
            };
            System.out.println(spiralOrder(sampleGrid)); // [1, 2, 3, 6, 9, 8, 7, 4, 5]
        }
    }
}
