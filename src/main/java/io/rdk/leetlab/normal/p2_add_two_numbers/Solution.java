package io.rdk.leetlab.normal.p2_add_two_numbers;

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

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode res = null; // 结果
        ListNode tail = null; // 尾指针
        int carry = 0; // 进位
        while(l1 != null || l2 != null){
            int val1 = l1 == null ? 0 : l1.val;
            int val2 = l2 == null ? 0 : l2.val;
            int sum = val1 + val2 + carry;
            carry = sum / 10;
            if(res == null){
                tail = new ListNode(sum % 10);
                res = tail;
            }else{
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            if(l1 != null){
                l1 = l1.next;
            }
            if(l2 != null){
                l2 = l2.next;
            }
        }
        if(carry != 0){
            tail.next = new ListNode(carry);
        }
        return res;
    }

}