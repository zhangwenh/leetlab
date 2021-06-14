package io.rdk.leetlab.core.DynamicProgramming.p121_best_time_to_buy_and_sell_stock;

public class Solution1 {

    // Solution中优化空间
    // 仔细观察动态规划的辅助数组，其每一次只用到了dp[i-1]这一个空间
    // 因此可以把数组改成单个变量dp来存储截止到第i天的价格最低点
    public int maxProfit(int[] prices) {
        int minprice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            minprice = Math.min(minprice,prices[i]);
            maxProfit = Math.max(maxProfit,prices[i]-minprice);
        }
        return maxProfit;
    }

}
