package io.rdk.leetlab.normal.p704_binary_search;

public class Solution {
    public int search(int[] nums, int target) {
        // 二分查找
        // 由于排过序，因此可以用二分法
        if(nums == null || nums.length == 0){
            return -1;
        }
        int l = 0;
        int r = nums.length-1;
        int res = -1;
        while(l <= r){
            int mid = l+(r-l)/2;
            int midV = nums[mid];
            if(target == midV){
                return mid;
            }else if(target > midV){
                l = mid + 1;
            }else{
                r = mid - 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{5};
        int target = 5;
        Solution solution = new Solution();
        int res = solution.search(nums, target);
        System.out.println(res);
    }
}
