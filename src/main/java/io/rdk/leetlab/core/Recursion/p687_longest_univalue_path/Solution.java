package io.rdk.leetlab.core.Recursion.p687_longest_univalue_path;

import io.rdk.leetlab.pub.TreeNode;

public class Solution {
    int ans = 0;    // 结果
    public int longestUnivaluePath(TreeNode root) {
        helper(root);
        return ans;
    }

    // 搜索以root为起点的最长同值路径
    // 要么经过左子树，要么经过右子树
    public int helper(TreeNode node) {
        if (node == null) return 0;
        int leftVal = helper(node.left);
        int rightVal = helper(node.right);
        int arrowLeft = 0, arrowRight = 0;
        if(node.left != null && node.left.val == node.val){
            arrowLeft = leftVal + 1;
        }
        if(node.right != null && node.right.val == node.val){
            arrowRight = rightVal + 1;
        }
        // 更新结果
        ans = Math.max(ans, arrowLeft + arrowRight);
        return Math.max(arrowLeft, arrowRight);
    }
}
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */