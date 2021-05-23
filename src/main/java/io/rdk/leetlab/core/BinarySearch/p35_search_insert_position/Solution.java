package io.rdk.leetlab.core.BinarySearch.p35_search_insert_position;

public class Solution {
    public int searchInsert(int[] nums, int target) {
        int len = nums.length;
        // 特殊判断
        if (nums[len - 1] < target) {
            return len;
        }

        // 程序走到这里一定有 target <= nums[len - 1]
        int left = 0;
        int right = len - 1;
        // 在区间 nums[left..right] 里查找第 1 个大于等于 target 的元素的下标
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] < target){
                // 下一轮搜索的区间是 [mid + 1..right]
                left = mid + 1;
            } else {
                // 下一轮搜索的区间是 [left..mid]
                right = mid;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        int target = 9;
        int[] nums = new int[]{1,3,5,6};
        Solution s = new Solution();
        int ret = s.searchInsert(nums,target);
        System.out.println(ret);
    }
}
