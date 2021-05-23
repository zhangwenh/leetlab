package io.rdk.leetlab.core.DivideAndConquer.p169_majority_element;

import java.util.Arrays;

/**
 * 排序法
 */
public class Solution {
    public int majorityElement(int[] nums) {
        // 题目中已经明确一定存在多数元素，因此排序后取n/2元素即是多数元素
        if(nums == null){
            return -1;
        }
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}
