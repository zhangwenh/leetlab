package io.rdk.leetlab.core.Backtracking.p46_permutations;

import java.util.*;

/**
 * dfs+回溯
 * 详见官方视频 https://leetcode-cn.com/problems/permutations/solution/quan-pai-lie-by-leetcode-solution-2/
 */
public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if(nums == null || nums.length==0){
            return res;
        }
        // 状态变量
        int len = nums.length;
        Deque<Integer> path = new ArrayDeque<>();
        boolean[] used = new boolean[len];

        dfs(nums,len,0,path,used,res);
        return res;
    }

    private void dfs(int[] nums, int len, int depth, Deque<Integer> path, boolean[] used, List<List<Integer>> res) {
        // 退出条件
        if(depth == len){
            res.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < len; i++) {
            if(used[i]){ // 当前数字已经被使用，则跳过
                continue;
            }
            path.addLast(nums[i]);
            used[i] = true;
            dfs(nums,len,depth+1,path,used,res);
            path.removeLast(); // 回溯逆操作
            used[i] = false;
        }
    }


}
