package io.rdk.leetlab.normal.p169_majority_element;

import java.util.Arrays;

/**
 * 分治法
 * 思路：分成2边，
 * 场景一：两边的众数相同，则这个就是结果；
 * 场景二：两边的众数不同，则比较2个数字在整个区间出现的次数，然后大的就是结果。
 */
public class Solution1 {
    public int majorityElement(int[] nums) {
        return majorityElementRec(nums,0,nums.length-1);
    }

    private int majorityElementRec(int[] nums, int leftInd, int rightInd) {
        // 1、将数组一分为二
        // 2、各自计算众数
        // 3、比对2边的2个数字是否相同
        // 4、若相同，则为结果
        // 5、若不同，比对2个数字在整个区间出现的次数
        if(leftInd == rightInd){
            return nums[leftInd];
        }
        int midInd = leftInd+(rightInd-leftInd)/2;
        int leftMajor = majorityElementRec(nums, leftInd, midInd);
        int rightMajor = majorityElementRec(nums, midInd+1, rightInd);
        if(leftMajor==rightMajor){
            return leftMajor;
        }
        int leftCnt = 0;
        int rightCnt = 0;
        for(int i = leftInd; i< rightInd+1; i++){
            if(nums[i] == leftMajor){
                leftCnt++;
            }else if(nums[i] == rightMajor){
                rightCnt++;
            }
        }
        return leftCnt>=rightCnt?leftMajor:rightMajor;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,2,1,1,1,2};
        Solution1 solution1 = new Solution1();
        int ret = solution1.majorityElement(arr);
        System.out.println(ret);
    }
}
