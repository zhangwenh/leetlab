package io.rdk.leetlab.normal.p662_maximum_width_of_binary_tree;

import io.rdk.leetlab.pub.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

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
    public int widthOfBinaryTree(TreeNode root) {
        int res = 1;
        // BFS
        // 设置2个队列，一个记录node，一个记录索引
        // 每层的宽度 = 最后一个索引 - 第一个索引 + 1
        // root手工加入队列
        // node出队列后，将其left，right加入队列q
        // indexQ做同样处理
        // 通过levelNodeCount来检查当前层是否都走完
        // 每次levelNodeCount==0时，说明当前为尾节点，检查queue中有多少节点，明确下一层有多少node要遍历
        // 记录当前层首个node的index，并在levelNodeCount==0时，记录尾node的index
        // 随后和res比对
        Queue<TreeNode> q = new LinkedList<>();
        Queue<Integer> indexQ = new LinkedList<>();
        q.add(root);
        indexQ.add(1);
        int firstIndex = 0;
        int lastIndex = 0;
        int levelNodeCount = 1;
        boolean firstFlag = true;
        while(!q.isEmpty()){
            TreeNode node = q.poll();
            int index = indexQ.poll();
            levelNodeCount --;
            // 当前层第一个节点
            if(firstFlag){
                firstIndex = index;
                firstFlag = false;
            }
            if(node.left != null){
                q.add(node.left);
                indexQ.add(index*2); // 左节点的索引号为2n，其中n为当前节点索引号
            }
            if(node.right != null){
                q.add(node.right);
                indexQ.add(index*2 + 1); // 右节点的索引号为2n+1，其中n为当前节点索引号
            }
            // 说明是当前层最后一个节点
            if(levelNodeCount == 0){
                lastIndex = index;
                levelNodeCount = q.size();
                // 每层的宽度 = 最后一个索引 - 第一个索引 + 1
                res = Math.max(res, lastIndex - firstIndex +1);
                firstFlag = true; // 下一次就是启始节点
            }
        }
        return res;
    }
}
