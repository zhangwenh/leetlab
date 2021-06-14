package io.rdk.leetlab.normal.p27_remove_element;

public class Solution {
    public int removeElement(int[] nums, int val) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            if(cur!=val){
                nums[index++] = nums[i];
            }
        }
        return index;
    }
}
