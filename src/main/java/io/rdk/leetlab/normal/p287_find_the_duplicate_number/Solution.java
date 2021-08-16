package io.rdk.leetlab.normal.p287_find_the_duplicate_number;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    public int findDuplicate(int[] nums) {
        // 哈希表法
        Set<Integer> set = new HashSet<>();
        for(int num:nums){
            if(!set.add(num)){
                return num;
            }
        }
        return -1;
    }

    public int findDuplicate1(int[] nums) {
        // 快慢指针法
        int slow = 0, fast = 0;
        // 此时第一次相遇
        do {
            // slow走一步，fast走两步
            // 注意这里用的是value找索引
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        // 此时重制slow或者fast到0，继续寻找下一次相遇
        // 再次相遇，就是重复的值
        fast = 0;
        // 由于题干表示一定有一个重复数字
        // 因此这里也可以写为while(slow!=fast)
        while(slow!=fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

    public int findDuplicate2(int[] nums) {
        // 加减法
        // 这个方法不行，因为题目是存在[2,2,2,2,2]的情况
        int sum = 0;
        for(int num:nums){
            sum += num;
        }
        int n = nums.length;
        return sum-n*(n-1)/2;
    }
}
