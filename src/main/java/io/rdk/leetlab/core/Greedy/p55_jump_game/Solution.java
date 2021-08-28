package io.rdk.leetlab.core.Greedy.p55_jump_game;

public class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int maxReach = 0; // 可以到达的最远位置
        for (int i = 0; i < n; i++) { // 考虑[0],[0,1]
            if(i > maxReach){ // 表示遍历到了一个超过可达的最远位置，很重要！！！
                return false;
            }
            maxReach = Math.max(maxReach,i+nums[i]);
            if(maxReach >= n-1){ // 大于终点
                return true;
            }
        }
        return false;

        // 还有一种解法：
        // 实际只需要判断0的位置，以及0之后是否可达
    }
}
