package io.rdk.leetlab.core.Backtracking.p78_subsets;

import java.util.ArrayList;
import java.util.List;

/**
 * 回溯法
 */
public class Solution1 {

    // p77更典型
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(new ArrayList<>()); // 空集
        for (int i = 1; i <= nums.length; i++) { // 子集个数=深度
            backtracking(nums, res, i, 0, new ArrayList<>());
        }
        return res;
    }

    /**
     *
     * @param nums
     * @param res
     * @param len 深度
     * @param index 当前遍历的节点索引
     * @param list
     */
    private void backtracking(int[] nums, List<List<Integer>> res, int len, int index, List<Integer> list) {
        if (list.size() == len) { // 子集的长度等于要找的深度的时候，满足条件，就退出
            res.add(new ArrayList<>(list));
        }else{
            for(int i = index; i < nums.length; i++) { // 当前节点开始的下级节点都放到集合中去
                list.add(nums[i]);
                backtracking(nums, res, len, i+1, list); // 当前节点的下级遍历/递归 // 注意这里要i+1
                list.remove(list.size()-1); // 把刚刚加入的元素去掉，从而开始遍历兄弟节点
            }
        }
    }
}
