package io.rdk.leetlab.normal.p46_permutations;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer,Boolean> visited = new HashMap<>(); // 用于记录每个元素被访问情况
        for (int num : nums) {
            visited.put(num,false);
        }
        backtracking(nums,res,visited,new ArrayList<>());
        return res;
    }

    private void backtracking(int[] nums, List<List<Integer>> res, Map<Integer, Boolean> visited, ArrayList<Integer> curList) {
        // 退出条件
        if(curList.size() == nums.length){ // 说明都被访问到了 // visited.containsValue(false)性能差
            res.add(new ArrayList<>(curList));
        }else{
            for (int num : nums) {
                if(!visited.get(num)){ // 没访问过
                    curList.add(num); // 加到队列里
                    visited.put(num,true); // 设置已访问
                    backtracking(nums,res,visited,curList);
                    // 向上回溯，换分支。此时要把本次加进入的数字，再退出来
                    visited.put(num,false);
                    curList.remove(curList.size() - 1);
                }
            }
        }
    }
}
