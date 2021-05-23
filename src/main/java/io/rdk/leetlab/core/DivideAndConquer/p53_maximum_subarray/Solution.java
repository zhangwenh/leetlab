package io.rdk.leetlab.core.DivideAndConquer.p53_maximum_subarray;

/**
 * 分治法，不容易理解，性能一般
 */
public class Solution {

    public int maxSubArray(int[] nums) {
        return getMax(nums,0,nums.length-1);
    }

    private int getMax(int[] nums, int leftInd, int rightInd) {
        // 退出条件
        if(leftInd == rightInd){
            return nums[leftInd];
        }
        // 一分为三：最大子序列要么在左边，要么右边，要么中间
        int mid = leftInd+(rightInd-leftInd)/2;
        int leftSum = getMax(nums,leftInd,mid);
        int rightSum = getMax(nums,mid+1,rightInd);
        int crossSum = getCorssSum(nums,leftInd,rightInd);
        return Math.max(leftSum,Math.max(rightSum,crossSum));
    }

    private int getCorssSum(int[] nums, int leftInd, int rightInd) {
        // 中间边界最大和应该是：从mid开始左边数和最大+右边数和最大
        int mid = leftInd+(rightInd-leftInd)/2;
        // 左边数和最大
        int leftSum = nums[mid];//仅是初始化
        int leftMax = leftSum;
        for (int i = mid-1; i >= leftInd; i--) { // mid已经计算过了，因此应该从mid-1开始
            // 逐个往左边数
            leftSum += nums[i];
            leftMax = Math.max(leftMax,leftSum);
        }
        // 右边数和最大
        int rightSum = nums[mid+1];
        int rightMax = rightSum;
        for (int i = mid+2; i <= rightInd; i++) { // mid+1已经计算过了，因此要从mid+2开始
            // 逐个往右边数
            rightSum += nums[i];
            rightMax = Math.max(rightMax,rightSum);
        }
        return leftMax+rightMax;
    }

}

