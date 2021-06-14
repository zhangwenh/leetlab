package io.rdk.leetlab.normal.p53_maximum_subarray;

public class Solution {
    public int maxSubArray(int[] nums) {
        int res = nums[0];
        int pre = res;
        // 比较前序的最大子序列和，与当前值的大小，比当前值大，则不合并
        // 遍历取得每个位置上的最大子序列和，其中醉的即为最大子序列和
        for (int i = 1; i < nums.length; i++) {
            // max(pre+cur,cur)当前节点下最大值
            pre = Math.max(pre+nums[i],nums[i]);
            res = Math.max(pre,res);
        }
        return res;
    }
}
