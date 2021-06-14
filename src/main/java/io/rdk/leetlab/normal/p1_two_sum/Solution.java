package io.rdk.leetlab.normal.p1_two_sum;

import java.util.HashMap;
import java.util.Map;

class Solution {

    // 代码解释：
    // 方法一：暴力顺序匹配
    // 方法二：空间换时间
    //         1、遍历数组，取出当前值
    //         2、通过目标值-当前值，取得要找的值
    //         3、判断临时map中是否有要找的值，若有，则解出
    //         4、若无，则将当前值放入临时map
    //         按此方法，则数组只要遍历一次即可，时间复杂度和空间复杂度都是O(n)
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i];
            int check = target - cur;
            if(map.containsKey(check)){
                return new int[]{i,map.get(check)};
            }else{
                map.put(cur,i);
            }
        }
        return null;
    }
}
