package io.rdk.leetlab.normal.p90_subsets_ii;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 相关算法可参考p78
 */
public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> resList = new ArrayList<>();
        // 此处是精髓，为避免生成重复的子集，先将数组排序
        Arrays.sort(nums); //排序
        dfs(resList,nums,0,new ArrayList<Integer>());
        return resList;
    }

    private void dfs(List<List<Integer>> resList, int[] nums, int index, ArrayList<Integer> tempList) {
        if(!resList.contains(tempList)){
            resList.add(new ArrayList<>(tempList));
        }
        if(index == nums.length){
            return;
        }
        for (int i = index; i < nums.length; i++) {
            tempList.add(nums[i]);
            dfs(resList,nums,i+1,tempList);
            tempList.remove(tempList.size()-1);
        }
    }
}
