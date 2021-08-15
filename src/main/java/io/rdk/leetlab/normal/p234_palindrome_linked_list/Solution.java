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
        // 构造两个指针，一个全局p指针指向开头
        // head指针通过递归，走到最后
        // 然后倒退检查head和p的内容，如果不相等，则返回false
        // 为了保证一旦发现false，后续就不再检查，那么就需要在递归方法一开始的时候就检查下一级递归的返回是否为false
        p = head;
        return rec(head);
    }
    private ListNode p;
    private boolean rec(ListNode currentNode){
        if (currentNode != null) {
            if (!rec(currentNode.next)) {
                return false;
            }
            if (currentNode.val != p.val) {
                return false;
            }
            p = p.next;
        }
        return true;
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
        // 每次慢指针只移动一步，快指针移动两步
        // 快指针走到末尾（当前为null，或者next为null），慢指针刚好到中间
        // 其中慢指针将前半部分反转，形成pre指针。然后比较
        // 后面每一步都应该一样
        if(head == null || head.next == null) {
            return true;
        }
        ListNode slow = head, fast = head;
        ListNode pre = head, prepre = null;
        while(fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
            pre.next = prepre;
            prepre = pre;
        }
        if(fast != null) {
            slow = slow.next;
        }
        while(pre != null && slow != null) {
            if(pre.val != slow.val) {
                return false;
            }
            pre = pre.next;
            slow = slow.next;
        }
        return true;
    }
}
