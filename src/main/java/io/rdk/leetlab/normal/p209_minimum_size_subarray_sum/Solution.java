package io.rdk.leetlab.normal.p209_minimum_size_subarray_sum;

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int left=0,right=0,count=Integer.MAX_VALUE,sum=0;
        while(right < nums.length){
            sum += nums[right];
            while (sum >= target){
                count = Math.min(count,right-left+1);
                sum -= nums[left++];
            }
            right++;
        }
        return count==Integer.MAX_VALUE?0:count;
    }
}
