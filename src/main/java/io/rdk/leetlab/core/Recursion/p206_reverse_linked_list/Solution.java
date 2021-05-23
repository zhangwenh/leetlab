package io.rdk.leetlab.core.Recursion.p206_reverse_linked_list;

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
    public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode cur = reverseList(head.next);
        //如果链表是 1->2->3->4->5，那么此时的cur就是5 (.next==null的对象，即最后一个节点)
        //而head是4，head的下一个是5，下下一个是空
        //所以head.next.next 就是5->4
        head.next.next = head;
        head.next = null;
        return cur;
    }
}
