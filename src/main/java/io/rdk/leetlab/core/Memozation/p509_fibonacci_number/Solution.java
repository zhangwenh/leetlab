package io.rdk.leetlab.core.Memozation.p509_fibonacci_number;

/**
 *
 */
public class Solution {
    int[] memArr = new int[30]; // 根据题意最大不会超过30

    public int fib(int n) {
        int ret = 0;
        if(memArr[n] != 0){
            ret = memArr[n];
        }else{
            if(n<2){
                ret = n;
            }else {
                ret = fib(n-1)+fib(n-2);
            }
            memArr[n] = ret;
        }
        return ret;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.fib(6));
    }
}
