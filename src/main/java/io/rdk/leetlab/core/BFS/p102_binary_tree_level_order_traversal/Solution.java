package io.rdk.leetlab.core.BFS.p102_binary_tree_level_order_traversal;

import java.util.*;

/**
 * BFS实现
 */
class Solution {
    // 从上向下，从左向右遍历
    // 进队列，然后出队列
    // 将刚出队列的节点的左右节点进队列
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }

        Deque<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        while(q.size()>0){
            int size = q.size(); // 此size实际指当前层有多少元素
            List<Integer> list = new ArrayList<>();
            while(size>0){
                // 出队列
                TreeNode cur = q.poll();
                size--;
                if(cur!=null){
                    list.add(cur.val); // 进入结果集合
                    // 此处只放一个节点的孩子
                    // 通过外部循环，实际上将下层的所有孩子节点都放进来了
                    if(cur.left!=null){ // 进队列
                        q.add(cur.left);
                    }
                    if(cur.right!=null){
                        q.add(cur.right);
                    }
                }
            }
            res.add(list);
        }
        return res;
    }
}
