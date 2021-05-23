package io.rdk.leetlab.core.DivideAndConquer.p53_maximum_subarray;

/**
 * 动态规划法，性能更好
 */
public class Solution1 {
    // 每一步找到自己的最大子序列和
    // 每一步：要么和前面合并，要么不和前面合并（也就是当前数字） max([i],max(dp[i-1]+[i]))
    // 动态规划三要素：方程式，初始值，终止值
    public int maxSubArray(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0]; // 初始值
        int ret = dp[0];
        for (int i = 1; i < nums.length; i++) {
            // 每一步：要么和前面子序列和合并，要么不和前面合并（也就是当前数字） max([i],max(dp[i-1]+[i]))
            dp[i] = Math.max(dp[i-1]+nums[i],nums[i]);
            ret = Math.max(ret,dp[i]);
        }
        return ret;
    }
}
