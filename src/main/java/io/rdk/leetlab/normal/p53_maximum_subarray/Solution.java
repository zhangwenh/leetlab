package io.rdk.leetlab.normal.p53_maximum_subarray;

public class Solution {
    public int maxSubArray(int[] nums) {
        // 贪心法
        int res = nums[0];
        int pre = res;
        // 比较前序的最大子序列和，与当前值的大小，比当前值大，则不合并
        // 其实意思为前序和如果是负数，则丢弃
        // 遍历取得每个位置上的最大子序列和，其中最大即为最大子序列和
        for (int i = 1; i < nums.length; i++) {
            // max(pre+cur,cur)当前节点下最大值
            pre = Math.max(pre+nums[i],nums[i]); // 由于要后续连贯，因此是 当前值 与"前序加当前值"比大小
            res = Math.max(pre,res);
        }
        return res;
    }
}
