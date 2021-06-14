package io.rdk.leetlab.core.DynamicProgramming.p221_maximal_square;

import java.util.Arrays;

public class Solution {
    // 在一个由 '0' 和 '1' 组成的二维矩阵内，找到只包含 '1' 的最大正方形，并返回其面积。
    // 思路：
    // 使用dp(i,j)表示以(i,j)为右下角，且只包含1的正方形的边长最大值
    // 其中的最大值就是矩阵中只包含1的正方形的边长最大值，其平方就是答案。
    // dp计算过程：
    // 若该位置的值为0，那么dp(i,j)=0，因为当前位置不可能在由1组成的正方形中
    // 若该位置的值为1，那么dp(i,j)的值由其上、左、左上方的dp值决定
    // 即这3个值中最小值+1 （要自己思考下）
    // 状态转移方程：
    // dp(i,j) = min(dp(i-1,j), dp(i-1,j-1), dp(j-1)) + 1
    // 见img.png
    public int maximalSquare(char[][] matrix) {
        int maxSide = 0;
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return maxSide;
        }

        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    if (i == 0 || j == 0) {
                        // 边界的情况下，均不可能组成更大的正方形，因此为1
                        dp[i][j] = 1;
                    } else {
                        // dp[i][j]等于左、上、左上3个格子的最小值+1
                        dp[i][j] = Math.min(Math.min(dp[i - 1][j], dp[i][j - 1]), dp[i - 1][j - 1]) + 1;
                    }
                    // 累计最大边
                    maxSide = Math.max(maxSide, dp[i][j]);
                }
            }
        }
        return maxSide*maxSide;
    }
}
