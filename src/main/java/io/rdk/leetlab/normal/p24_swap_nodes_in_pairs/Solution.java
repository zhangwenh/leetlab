package io.rdk.leetlab.normal.p24_swap_nodes_in_pairs;

import io.rdk.leetlab.pub.ListNode;


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    // 迭代法
    public ListNode swapPairs(ListNode head) {
        ListNode res = new ListNode();
        res.next = head;
        ListNode cur = res;
        while(cur.next != null && cur.next.next != null){
            ListNode node1 = cur.next;
            ListNode node2 = node1.next;
            // 交换 node1 node2
            cur.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            // 调整指针
            cur = node1;
        }
        return res.next;
    }
}