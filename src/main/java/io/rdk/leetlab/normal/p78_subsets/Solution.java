package io.rdk.leetlab.normal.p78_subsets;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> resList = new ArrayList<>();
        dfs(resList,nums,0,new ArrayList<Integer>());
        return resList;
    }

    private void dfs(List<List<Integer>> resList, int[] nums, int index, ArrayList<Integer> tempList) {
        // 由于是全集，包含空值，因此进入后先加到结果集里
        resList.add(new ArrayList<>(tempList));
        // 退出条件
        if(index == nums.length){
            return;
        }
        for (int i = index; i < nums.length; i++) {
            tempList.add(nums[i]);
            // 注意此处的index是i+1，不是i++，也不是index++
            dfs(resList,nums,i+1,tempList);
            tempList.remove(tempList.size() - 1);
        }
    }
}
