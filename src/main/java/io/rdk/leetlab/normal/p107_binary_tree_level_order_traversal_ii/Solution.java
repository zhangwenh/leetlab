package io.rdk.leetlab.normal.p107_binary_tree_level_order_traversal_ii;

import io.rdk.leetlab.pub.TreeNode;

import java.util.*;

public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        if(root == null){
            return new ArrayList<>();
        }
        List<List<Integer>> resList = new ArrayList<>();
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.add(root);
        while(queue.size() > 0){
            int size = queue.size();
            List<Integer> tempList = new ArrayList<>();
            while(size > 0){
                TreeNode treeNode = queue.pop();
                tempList.add(treeNode.val);
                size --;
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
        Collections.reverse(resList);
        return resList;
    }
}
