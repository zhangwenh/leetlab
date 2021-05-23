package io.rdk.leetlab.core.Backtracking.p78_subsets;

import java.util.ArrayList;
import java.util.List;

/**
 * 回溯法
 */
public class Solution1 {

    // p77更典型
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        result.add(new ArrayList<>()); // 空集
        for (int i = 1; i <= nums.length; i++) { // 子集个数=深度
            backtracking(nums, result, i, 0, new ArrayList<>());
        }
        return result;
    }

    /**
     *
     * @param nums
     * @param result
     * @param length 深度
     * @param index 当前遍历的节点索引
     * @param subset
     */
    private void backtracking(int[] nums, List<List<Integer>> result, int length, int index, List<Integer> subset) {
        if (subset.size() == length) { // 子集的长度等于要找的深度的时候，满足条件，就退出
            result.add(new ArrayList<>(subset));
            return;
        }
        for(int i = index; i < nums.length; i++) { // 当前节点开始的下级节点都放到集合中去
            subset.add(nums[i]);
            backtracking(nums, result, length, i+1, subset); // 当前节点的下级遍历/递归
            subset.remove(subset.size()-1); // 把刚刚加入的元素去掉，从而开始遍历兄弟节点
        }

    }
}
