package io.rdk.leetlab.normal.p21_merge_two_sorted_lists;

import io.rdk.leetlab.pub.ListNode;

public class Solution {
    public ListNode mergeTwoLists_digui(ListNode l1, ListNode l2) {
        // 退出条件，l1结束，则返回l2，反之亦然
        if(l1 == null){
            return l2;
        }else if(l2 == null){
            return l1;
        }else if(l1.val<l2.val){
            // l1小，因此去掉l1后，看l1.next和l2谁大谁小
            // 退出下级递归后，返回当前node，因此return l1
            l1.next = mergeTwoLists_digui(l1.next,l2);
            return l1;
        }else{
            l2.next = mergeTwoLists_digui(l1,l2.next);
            return l2;
        }
    }
    public ListNode mergeTwoLists_diedai(ListNode l1, ListNode l2) {
        ListNode res = new ListNode();
        ListNode cur = res;
        while(l1!=null && l2!=null){
            if(l1.val<=l2.val){
                // cur指向已选取出来节点
                cur.next = l1;
                l1 = l1.next; // 把l1当前节点摘出来
            }else{
                cur.next = l2;
                l2 = l2.next; // 把l2当前节点摘出来
            }
            cur = cur.next;
        }
        // 后续接下没遍历完的链表
        cur.next = l1 == null ? l2 : l1;
        return res.next;
    }
    public ListNode mergeTwoLists_no_use(ListNode l1, ListNode l2) {
        ListNode head = null;
        ListNode tail = null;
        while(l1 != null && l2 != null){
            int val1 = l1.val;
            int val2 = l2.val;
            if(val1>val2){
                if(head == null){
                    tail = new ListNode(l2.val);
                    head = tail;
                }else{
                    tail.next = new ListNode(l2.val);
                    tail = tail.next;
                }
                l2 = l2.next;
            }else{
                if(head == null){
                    tail = new ListNode(l1.val);
                    head = tail;
                }else{
                    tail.next = new ListNode(l1.val);
                    tail = tail.next;
                }
                l1 = l1.next;
            }
        }
        while(l1 !=null){
            if(head == null){
                tail = new ListNode(l1.val);
                head = tail;
            }else{
                tail.next = new ListNode(l1.val);
                tail = tail.next;
            }
            l1 = l1.next;
        }
        while(l2 != null){
            if(head == null){
                tail = new ListNode(l2.val);
                head = tail;
            }else{
                tail.next = new ListNode(l2.val);
                tail = tail.next;
            }
            l2 = l2.next;
        }
        return head;
    }
}
