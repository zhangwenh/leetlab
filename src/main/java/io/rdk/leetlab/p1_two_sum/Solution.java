package io.rdk.leetlab.p1_two_sum;

import java.util.HashMap;
import java.util.Map;

//    给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
//    你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
//
//    示例:
//    给定 nums = [2, 7, 11, 15], target = 9
//
//    因为 nums[0] + nums[1] = 2 + 7 = 9
//    所以返回 [0, 1]
class Solution {

    // 代码解释：
    // 方法一：暴力顺序匹配
    // 方法二：空间换时间
    //         1、遍历数组，取出当前值
    //         2、通过目标值-当前值，取得要找的值
    //         3、判断临时map中是否有要找的值，若有，则解出
    //         4、若无，则将当前值放入临时map
    
    public int[] twoSum(int[] nums, int target) {
        int[] ret = new int[2];
        if (nums == null || nums.length <= 1) return ret;
        Map<Integer, Integer> indexMap = new HashMap<Integer, Integer>(); // <值，索引>
        for (int i = 0; i < nums.length; i++) {
            int current = nums[i];
            int other = target - current;
            if (indexMap.containsKey(other)) {
                int otherInd = indexMap.get(other);
                //注意此处顺序
                ret[0] = otherInd;
                ret[1] = i;
                return ret;
            } else {
                indexMap.put(current, i);
            }
        }
        return ret;
    }
}
