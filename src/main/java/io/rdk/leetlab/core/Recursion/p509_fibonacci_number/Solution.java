package io.rdk.leetlab.core.Recursion.p509_fibonacci_number;

/**
 * 递归法
 * 容易溢出，建议使用迭代法
 */
public class Solution {

    public int fib(int n) {
        if(n<2){
            return n;
        }else {
            return fib(n-1)+fib(n-2);
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.fib(6));
    }
}
