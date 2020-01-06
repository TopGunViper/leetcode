package edu.ouc.array;

/**
 * Your are given an array of integers prices, for which the i-th element is the price of a given stock on day i; and
 * a non-negative integer fee representing a transaction fee.
 * <p>
 * You may complete as many transactions as you like, but you need to pay the transaction fee for each transaction.
 * You may not buy more than 1 share of a stock at a time (ie. you must sell the stock share before you buy again.)
 * <p>
 * Return the maximum profit you can make.
 * <p>
 * Note:
 * 0 < prices.length <= 50000.
 * 0 < prices[i] < 50000.
 * 0 <= fee < 50000.
 */
public class _714_Best_Time_to_Buy_and_Sell_Stock_with_Transaction_Fee {

    /**
     * DP
     */
    public int maxProfit(int[] prices, int fee) {
        if (prices == null || prices.length <= 1) {
            return 0;
        }
        int hold = -prices[0];
        int sell = 0;
        for (int i = 1; i < prices.length; i++) {
            hold = Math.max(hold, sell - prices[i]);
            sell = Math.max(sell, hold + prices[i] - fee);
        }

        return sell;
    }


    public static void main(String[] args) {
        _714_Best_Time_to_Buy_and_Sell_Stock_with_Transaction_Fee tester =
                new _714_Best_Time_to_Buy_and_Sell_Stock_with_Transaction_Fee();

        int[] prices = {1, 3, 2, 8, 4, 9};
        int fee = 2;
        System.out.println(tester.maxProfit(prices, fee));
        int[] prices2 = {1, 3, 5};
        fee = 1;
        System.out.println(tester.maxProfit(prices2, fee));

        int[] prices3 = {2, 1, 4,4, 2, 3, 2, 5, 1, 2};
        fee = 1;
        System.out.println(tester.maxProfit(prices3, fee));
    }
}
