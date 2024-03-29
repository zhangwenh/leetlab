package io.rdk.leetlab.core.Greedy.p322_coin_change;

/**
 * 适合用dp、记忆化搜索
 */
public class Solution {
    // 这题不适合用贪心，适合用dp
    // 以下是递归法，直接使用递归超出时间限制
    int res = Integer.MAX_VALUE;
    public int coinChange(int[] coins, int amount) {
        if(coins.length == 0){
            return -1;
        }

        findWay(coins,amount,0);

        // 如果没有任何一种硬币组合能组成总金额，返回 -1。
        if(res == Integer.MAX_VALUE){
            return -1;
        }
        return res;
    }

    /**
     *
     * @param coins 硬币的全集
     * @param amount 要凑的金额
     * @param count
     */
    public void findWay(int[] coins,int amount,int count){
        if(amount < 0){
            return;
        }
        if(amount == 0){
            res = Math.min(res,count); //取小的count
        }
        // 遍历硬币，拿出一个，计算剩下要凑多少金额
        for(int i = 0;i < coins.length;i++){
            findWay(coins,amount-coins[i],count+1);
        }
    }
}
