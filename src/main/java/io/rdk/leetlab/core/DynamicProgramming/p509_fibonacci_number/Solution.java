package io.rdk.leetlab.core.DynamicProgramming.p509_fibonacci_number;

/**
 * 动态规划方法（自下向上）
 * 还可以用记忆化搜索（自顶向下）
 */
public class Solution {

    public int fib(int n) {
        // 思路是：推3个指针
        if(n<2){
            return n;
        }else{
            int pre2 = 0, pre1 = 1, cur = 0;
            for (int i = 2; i <= n; i++) {
                cur = pre2 + pre1;
                // 状态转移
                pre2 = pre1;
                pre1 = cur;
            }
            return cur;
        }
    }

    public static void main(String[] args) {
        int n = 6;
        Solution solution = new Solution();
        System.out.println(solution.fib(n));
    }

}
