package io.rdk.leetlab.core.Array.p485_max_consecutive_one;

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        if(nums==null || nums.length==0){
            return 0;
        }
        int ret = 0;
        int temp = 0;
        for(int num:nums){
            if(num==1){
                temp += 1;
                if(temp > ret){
                    ret = temp;
                }
            }else{
                temp = 0;
            }
        }
        return ret;
    }

    public static void main(String[] args) {

    }
}
