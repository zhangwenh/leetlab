package io.rdk.leetlab.core.DynamicProgramming.p322_coin_change;

import java.util.Arrays;

public class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];

        Arrays.fill(dp, 20000); //不能是Integer.MAX_VALUE，+1会越界。或者把int换成long
        dp[0] = 0;
        for(int coin : coins) {
            for(int i = 1; i<= amount; i++){
                if(coin <= i) {
                    dp[i] = Math.min(dp[i], dp[i - coin] + 1);
                }

            }
        }
        return dp[amount] == 20000 ? -1 : dp[amount];
    }
}
