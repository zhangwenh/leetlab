package io.rdk.leetlab.core.Memozation.p322_coin_change;

/**
 * 暴力解法
 * 本方法会溢出
 */
public class Solution2 {
    // 以下是递归法，直接使用递归超出时间限制
    int res = Integer.MAX_VALUE;

    // coins 中是可选硬币面值，amount 是目标金额，硬币的数量是没有限制的
    public int coinChange(int[] coins, int amount) {
        if(coins.length == 0){
            return -1;
        }

        dp(coins,amount,0);

        // 如果没有任何一种硬币组合能组成总金额，返回 -1。
        if(res == Integer.MAX_VALUE){
            return -1;
        }
        return res;
    }

    /**
     * 要凑出金额 n，至少要 dp(n) 个硬币
     * @param coins 硬币的全集
     * @param amount 要凑的金额
     * @param count
     */
    public void dp(int[] coins, int amount, int count){
        if(amount < 0){
            return;
        }
        if(amount == 0){
            res = Math.min(res,count); //取小的count
        }
        // 做选择，选择需要硬币最少的那个结果
        // 遍历硬币，拿出一个，计算剩下要凑多少金额
        for(int i = 0;i < coins.length;i++){
            dp(coins,amount-coins[i],count+1);
        }
    }
}
