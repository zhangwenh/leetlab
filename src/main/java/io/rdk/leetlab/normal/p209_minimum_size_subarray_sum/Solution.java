package io.rdk.leetlab.normal.p209_minimum_size_subarray_sum;

class Solution {
    //输入：target = 7, nums = [2,3,1,2,4,3]
    //输出：2
    public int minSubArrayLen(int target, int[] nums) {
        // 滑动窗口
        int count = Integer.MAX_VALUE;
        int leftInd = 0, rightInd = 0, sum = 0;
        while(rightInd < nums.length){
            sum += nums[rightInd];
            while(sum >= target){
                count = Math.min(count,rightInd-leftInd+1);
                sum -= nums[leftInd];
                leftInd++;
            }
            rightInd++;
        }
        return count == Integer.MAX_VALUE?0:count;
    }

}
