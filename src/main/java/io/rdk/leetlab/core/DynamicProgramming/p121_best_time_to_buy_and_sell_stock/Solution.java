package io.rdk.leetlab.core.DynamicProgramming.p121_best_time_to_buy_and_sell_stock;

public class Solution {

    // 第i天的最大收益只需要知道前i天的最低点就可以算出来了
    // 而第i天以前（包括第i天）的最低点和i-1天的最低点有关
    // dp[i] = min(dp[i-1],prices[i])
    // maxprofit = prices[i]-dp[i]
    // 其中dp[0]=prices[0],然后动态计算之后的就可以了
    // 得到了前i天的最低点以后，只需要维护一个max用来保存最大收益就可以了
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int[] dp = new int[prices.length];
        dp[0] = prices[0];
        for (int i = 1; i < prices.length; i++) {
            dp[i] = Math.min(dp[i-1],prices[i]);
            maxProfit = Math.max(maxProfit,prices[i]-dp[i]);
        }
        return maxProfit;
    }

}
