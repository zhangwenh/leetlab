package io.rdk.leetlab.normal.p938_range_sum_of_bst;

import io.rdk.leetlab.pub.TreeNode;

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
class Solution {
    public int rangeSumBST(TreeNode root, int low, int high) {
        // 递归法
        if(root == null){
            return 0;
        }
        int val = root.val;
        if(val < low){
            // 检查当前节点的右子节点
            return rangeSumBST(root.right, low, high);
        }else if(val > high){
            return rangeSumBST(root.left, low, high);
        }else{
            return val + rangeSumBST(root.left, low, high) + rangeSumBST(root.right, low, high);
        }
    }
}
