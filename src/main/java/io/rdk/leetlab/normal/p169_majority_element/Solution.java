package io.rdk.leetlab.normal.p169_majority_element;

import java.util.Arrays;

/**
 * 排序法
 */
public class Solution {
    public int majorityElement(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }
}
