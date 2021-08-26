package io.rdk.leetlab.core.DynamicProgramming.p62_unique_paths;

public class Solution {
    public int uniquePaths(int m, int n) {
        // 方程式：F(i,j) = F(i-1,j)+F(i,j-1)
        // 初始状态：1
        // 终止状态：F(i,j)
        int[][] dp = new int[m][n];
        // 两个边的处理
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) { // 注意这2个循环都是从1开始
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];

    }
}
