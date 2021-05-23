package io.rdk.leetlab.core.LinkedList.p206_reverse_linked_list;

/**
 * 此处使用链表实现
 * 实际上，使用递归既简单又容易理解
 */
public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode pre=null;
        ListNode cur = head;
        while(cur!=null){
            ListNode nxt = cur.next;
            pre = cur;
            cur = nxt;
            cur.next = pre;
        }
        return pre;
    }
}
