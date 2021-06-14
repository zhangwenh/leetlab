package io.rdk.leetlab.core.DynamicProgramming.p70_climbing_stairs;

public class Solution {
    // 爬楼梯
    // dp[0] = 0
    // dp[1] = 1
    // dp[2] = 2
    // dp[3] = 3
    // dp[4] = 5
    // dp[5] = 8
    // 从枚举看出是，从2开始的斐波那契数列，所以
    // dp[i] = dp[i-1] + dp[i-2]
    // 三指针法：cur,pre1,pre2
    // 还有一种思路：爬第n阶楼梯的方法数量，等于 2 部分之和
    // 爬上 n-1 阶楼梯的方法数量。因为再爬1阶就能到第n阶
    // 爬上 n-2 阶楼梯的方法数量，因为再爬2阶就能到第n阶
    public int climbStairs(int n) {
        if(n<3){
            return n;
        }
        int pre2 = 1,pre1 = 2,cur = 0;
        for (int i = 2; i < n; i++) {
            cur = pre1+pre2;
            pre2 = pre1;
            pre1 = cur;
        }
        return cur;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int n = 4;
        System.out.println(solution.climbStairs(n));
    }
}
