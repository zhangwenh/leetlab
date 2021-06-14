package io.rdk.leetlab.normal.p102_binary_tree_level_order_traversal;

import io.rdk.leetlab.pub.TreeNode;

import java.util.*;

/**
 * BFS，使用了栈，运行时间更慢
 */
public class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        List<List<Integer>> resList = new ArrayList<>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root); // 把头放进去
        while(queue.size() > 0){ // 整个对象里有内容
            int size = queue.size(); // 当前层级的元素数量
            List<Integer> tempList = new ArrayList<>();
            while(size > 0){ // 当前层级有元素
                TreeNode treeNode = queue.pop();
                tempList.add(treeNode.val);
                size--;
                TreeNode leftNode = treeNode.left;
                if(leftNode != null){
                    queue.add(leftNode);
                }
                TreeNode rightNode = treeNode.right;
                if(rightNode != null){
                    queue.add(rightNode);
                }
            }
            resList.add(new ArrayList<>(tempList));
        }
        return resList;
    }
}
