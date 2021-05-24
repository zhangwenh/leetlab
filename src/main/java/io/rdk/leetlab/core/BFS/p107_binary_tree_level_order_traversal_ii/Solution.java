package io.rdk.leetlab.core.BFS.p107_binary_tree_level_order_traversal_ii;

import java.util.*;

/**
 * 同p102，只是结果集合调整下
 */
public class Solution {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
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
        Collections.reverse(res); // 也可以通过List.addFirst方法来做
        return res;
    }
}
