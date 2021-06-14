package io.rdk.leetlab.normal.p102_binary_tree_level_order_traversal;

import io.rdk.leetlab.pub.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * DFS，由于没有用栈，因此运行时间更快
 */
public class Solution1 {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> resList = new ArrayList<>();
        dfs(resList,root,0);
        return resList;
    }

    /**
     *
     * @param resList 最终结果list
     * @param treeNode 当前节点
     * @param level 层级
     */
    private void dfs(List<List<Integer>> resList, TreeNode treeNode, int level) {
        // 退出条件
        if(treeNode == null){
            return;
        }
        if(level > resList.size()-1){ // 增加一个数组占位，用于存放新的层级
            resList.add(new ArrayList<>());
        }
        resList.get(level).add(treeNode.val); // 到指定层级位置，写入value
        TreeNode leftNode = treeNode.left;
        if(leftNode != null){
            dfs(resList,leftNode,level+1); // 向下一层，因此level+1
        }
        TreeNode rightNode = treeNode.right;
        if(rightNode != null){
            dfs(resList,rightNode,level+1);
        }
    }
}
