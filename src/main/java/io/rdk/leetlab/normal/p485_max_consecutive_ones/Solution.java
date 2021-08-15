package io.rdk.leetlab.normal.p485_max_consecutive_ones;

public class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int count = 0;
        int res = 0;
        for(int num: nums){
            if(num == 1){
                count += 1;
            }else{
                res = Math.max(res,count);
                count = 0;
            }
        }
        res = Math.max(res,count);
        return res;
    }
}
