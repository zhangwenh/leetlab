package io.rdk.leetlab.normal.p206_reverse_linked_list;

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
    public ListNode reverseList(ListNode head) {
        // 迭代法
        // 1、设定新节点dm，作为头，最后将返回dm.next
        // dm->1->2->3->null
        // 2、循环遍历，直到head.next指向null
        // 3、循环中，设定新节点tmp，为head.next
        // dm->1(head)->2(tmp)->3->null
        // 4、各种翻转:
        // dm->2(tmp)->1(head)->3->null
        // dm->3(tmp)->2->1(head)->null
        ListNode dm = new ListNode();
        dm.next = head;
        while(head!=null && head.next != null){
            ListNode tmp = head.next;
            head.next = tmp.next;
            tmp.next = dm.next;
            dm.next = tmp;
        }
        return dm.next;
    }

    // 递归
    public ListNode reverseList_recursive(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode res = reverseList_recursive(head.next);
        // 1->2->3(head)(res)->null
        // 1->2(head)->3(res)->null
        // 1->2(head)(->null)<-3(res)
        // 1(head)<-2<-3(res)
        head.next.next = head;
        head.next = null;
        return res;
    }

}