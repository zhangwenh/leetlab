package io.rdk.leetlab.normal.p231_power_of_two;

public class Solution {
    public boolean isPowerOfTwo(int n) {
        // 若n为2的幂，那么n & (n-1) = 0
        if(n<=0){
            return false;
        }else{
            return (n&(n-1))==0;
        }

//        return n>0 && (n&(n-1))==0;
    }
}
