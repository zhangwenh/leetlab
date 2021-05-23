package io.rdk.leetlab.core.BinarySearch.p704_binary_search;

/**
 * 二分查找法
 */
class Solution {
    public int search(int[] nums, int target) {
        int len = nums.length;
        int left = 0;
        int right = len - 1;
        // 在 nums[left..right] 里查找 target
        while (left < right) {
            // 为了防止 left + right 整形溢出，写成这样
            int mid = left + (right - left) / 2;
            if (nums[mid] < target) {
                // 下一轮搜索区间：[mid + 1..right]
                left = mid + 1;
            } else {
                // 下一轮搜索区间：[left..mid]
                right = mid;
            }
        }

        if (nums[left] == target){
            return left;
        }
        return -1;
    }

    public static void main(String[] args) {
        int target = 9;
        int[] nums = new int[]{-1,0,3,5,9,12};
        Solution s = new Solution();
        int ret = s.search(nums,target);
        System.out.println(ret);
    }
}
