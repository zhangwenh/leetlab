package io.rdk.leetlab.core.BinarySearch.p162_find_peak_element;

class Solution {
    public int findPeakElement(int[] nums) {
        int index = 0;
        for (;index < nums.length-1; index++) {
            if(nums[index]>nums[index+1]){
                break;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,1,3,5,6,4};
        Solution s = new Solution();
        int ret = s.findPeakElement(nums);
        System.out.println(ret);
    }
}
