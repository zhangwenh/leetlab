package io.rdk.leetlab.core.DynamicProgramming.p279_perfect_squares;

import java.util.Arrays;

/**
 * dp
 * 和322很像
 */
public class Solution {

    // 完全平方数
    // numSquares(n)=min(numSquares(n-k) + 1)，其中k就是最后一个新加入的完全平方数
    public int numSquares(int n) {
        if(n == 1){
            return 1;
        }

        // dp[n]的值： 表示的凑成为n所需的最少的完全平方数的个数
        int[] dp = new int[n+1];
        // 给dp赋初值
        Arrays.fill(dp, Integer.MAX_VALUE);
        // bottom case
        dp[0] = 0;
        // pre-calculate the square numbers.
        int max_square_index = (int) Math.sqrt(n) + 1;
        int[] square_nums = new int[max_square_index];
        for (int i = 1; i < max_square_index; i++) {
            square_nums[i] = i * i;
        }

        for(int i = 1; i <= n; i++){
            for (int s = 1; s < max_square_index; s++) {
                // memo[i]有两种实现的方式，
                // 一种是包含当前的coins[i],那么剩余钱就是 i-coins[i],这种操作要兑换的硬币数是 memo[i-coins[j]] + 1
                // 另一种就是不包含，要兑换的硬币数是memo[i]
                if (i >= square_nums[s]){
                    // numSquares(n)=min(numSquares(n-k) + 1)，其中k就是最后一个新加入的完全平方数
                    dp[i] = Math.min(dp[i], dp[i - square_nums[s]] + 1);
                }
            }
        }

        return dp[n] == Integer.MAX_VALUE ? -1 : dp[n];
    }

}
