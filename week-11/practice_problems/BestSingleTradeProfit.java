// Week 11 Practice - Problem 6: Best Single Trade Profit
// Finds maximum achievable profit from buying on one day and selling on a later day.
// Time Complexity: O(N) single-pass, Space Complexity: O(1).
// (Brute force checking all pairs takes O(N^2) time, which does not scale for large data).

import java.util.Scanner;

public class BestSingleTradeProfit {

    public static int maxProfit(int[] prices) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }

        int minPrice = prices[0];
        int maxProfit = 0;

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < minPrice) {
                minPrice = prices[i];
            } else {
                int profit = prices[i] - minPrice;
                if (profit > maxProfit) {
                    maxProfit = profit;
                }
            }
        }

        return maxProfit;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNextLine()) {
            String line = sc.nextLine().trim();
            line = line.replace("[", "").replace("]", "").replace(",", " ");
            Scanner lineSc = new Scanner(line);
            java.util.List<Integer> list = new java.util.ArrayList<>();
            while (lineSc.hasNextInt()) {
                list.add(lineSc.nextInt());
            }
            if (!list.isEmpty()) {
                int[] prices = list.stream().mapToInt(i -> i).toArray();
                System.out.println(maxProfit(prices));
                return;
            }
        }

        int[] sample1 = {7, 1, 5, 3, 6, 4};
        System.out.println(maxProfit(sample1)); // Expected: 5

        int[] sample2 = {7, 6, 4, 3, 1};
        System.out.println(maxProfit(sample2)); // Expected: 0
    }
}
