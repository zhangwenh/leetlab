package io.rdk.leetlab.normal.p234_palindrome_linked_list;

import io.rdk.leetlab.pub.ListNode;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

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
    public boolean isPalindrome(ListNode head) {
        // 遍历+双指针
        List<Integer> list = new ArrayList<>();
        while(head!=null){
            list.add(head.val);
            head = head.next;
        }
        for(int i=0,j = list.size()-1;i<list.size();i++,j--){
            if(!list.get(i).equals(list.get(j)))
                return false;
        }
        return true;
    }

    public boolean isPalindrome1(ListNode head) {
        // 递归+双指针
        // todo
        isPalindrome1(head.next);
        return true;
    }

    private ListNode rec(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        isPalindrome1(head.next);
    }

    public boolean isPalindrome2(ListNode head) {
        // 栈
        // 回文链表 正反都一样
        Stack<Integer> stack = new Stack<>();
        ListNode dm = head;
        while(dm!=null){
            stack.push(dm.val);
            dm = dm.next;
        }
        while(head!=null){
            if(head.val!=stack.pop())
                return false;
            head = head.next;
        }
        return true;
    }

    public boolean isPalindrome3(ListNode head) {
        // 快慢指针
        // todo
        return true;
    }
}
