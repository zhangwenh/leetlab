package io.rdk.leetlab.normal.p268_missing_number;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int missingNumber(int[] nums) {
        // sorting法，看索引号与值是否一致
        // 如果都一致，最后是最后一个数字
        // 排序时间复杂度 O(nlogn)
        Arrays.sort(nums);
        int len = nums.length;
        for(int i = 0;i < len; i++){
            if(i!=nums[i]){
                return i;
            }
        }
        return len;
    }

    public int missingNumber1(int[] nums) {
        // hashset法
        // 把结果都放到set里
        // 遍历0-n，匹配set，若一一个不在set里，则为该值
        Set<Integer> numSet = new HashSet<Integer>();
        for (int num : nums) numSet.add(num);

        int expectedNumCount = nums.length + 1;
        for (int number = 0; number < expectedNumCount; number++) {
            if (!numSet.contains(number)) {
                return number;
            }
        }
        return -1;
    }

    public int missingNumber2(int[] nums) {
        // 位运算法
        // 将结果的初始值设为 n，再对数组中的每一个数以及它的下标进行一个异或运算
        // missing=4∧(0∧0)∧(1∧1)∧(2∧3)∧(3∧4)
        //        =(4∧4)∧(0∧0)∧(1∧1)∧(3∧3)∧2
        //        =0∧0∧0∧0∧2
        //        =2
        int missing = nums.length;
        for (int i = 0; i < nums.length; i++) {
            missing ^= i ^ nums[i];
        }
        return missing;
    }

    public int missingNumber3(int[] nums) {
        // 数学法
        // 只需要遍历一遍数组，在把0-n这n个自然数全加起来的同时也减去nums[i]，
        // 这样不但效率高，也防止了数据溢出
        int missing = 0;
        for (int i = 1; i <= nums.length; i++) {
            missing += i;
            missing -= nums[i - 1];
        }
        return missing;
    }

}
