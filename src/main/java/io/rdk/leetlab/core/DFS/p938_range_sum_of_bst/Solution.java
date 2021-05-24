package io.rdk.leetlab.core.DFS.p938_range_sum_of_bst;

public class Solution {

    // 1、root 节点为空
    // 返回 00。
    // 2、root 节点的值大于 high
    // 由于二叉搜索树右子树上所有节点的值均大于根节点的值，即均大于high，故无需考虑右子树，返回左子树的范围和。
    // 3、root 节点的值小于 low
    // 由于二叉搜索树左子树上所有节点的值均小于根节点的值，即均小于low，故无需考虑左子树，返回右子树的范围和。
    // 4、root 节点的值在 [low,high] 范围内
    // 此时应返回 root 节点的值、左子树的范围和、右子树的范围和这三者之和。
    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null){
            return 0;
        }
        if(root.val > high){
            return rangeSumBST(root.left,low,high);
        }
        if(root.val < low){
            return rangeSumBST(root.right,low,high);
        }
        return root.val+rangeSumBST(root.left,low,high)+rangeSumBST(root.right,low,high);
    }
}
