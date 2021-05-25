package io.rdk.leetlab.core.DFS.p78_subsets;

import javax.sound.midi.Soundbank;
import java.util.ArrayList;
import java.util.List;

/**
 * dfs
 */
public class Solution {

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        dfs(nums, res, 0, new ArrayList<>());
        return res;
    }

    private void dfs(int[] nums, List<List<Integer>> res, int index, ArrayList<Integer> sublist) {
        // 每次dfs都形成了一个新的子集，直接加到res里
        res.add(new ArrayList<>(sublist));
        // 退出条件：当开始的index位置等于nums长度，说明已经遍历结束了
        if(index == nums.length){
            return;
        }
        for (int i = index; i < nums.length; i++) {
            sublist.add(nums[i]);
            dfs(nums,res,i+1,sublist);
            sublist.remove(sublist.size()-1);
        }
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        Solution s = new Solution();
        s.subsets(nums);
    }

}
