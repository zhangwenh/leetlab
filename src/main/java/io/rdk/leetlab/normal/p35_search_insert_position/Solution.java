package io.rdk.leetlab.normal.p35_search_insert_position;

// 二分查找法
public class Solution {
    public int searchInsert(int[] nums, int target) {
        if(nums == null || nums.length==0){
            return 0;
        }
        int left = 0, right = nums.length-1, mid = 0;
        if(target<=nums[left]){
            return left;
        }else if(target>nums[right]){
            return right+1;
        }
        while (left < right){
            mid = left+(right-left)/2;
            int midVal = nums[mid];
            if(target > midVal){
                left = mid+1;
            }else{
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,3,5};
        int target = 3;
        Solution solution = new Solution();
        int res = solution.searchInsert(nums,target);
        System.out.println(res);
    }
}
