package io.rdk.leetlab.core.SlidingWindow.p209_minimum_size_subarray_sum;

public class Solution {
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

    public static void main(String[] args) {
        int[] nums = new int[]{1,4,4};
        int target = 14;
        Solution s = new Solution();
        int ret = s.minSubArrayLen(target,nums);
        System.out.println(ret);
    }
}
