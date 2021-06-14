package io.rdk.leetlab.normal.p20_valid_parentheses;

import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] arr = s.toCharArray();
        for (char c : arr) {
            if(c == '('){
                stack.push(')');
            }else if(c == '['){
                stack.push(']');
            }else if(c == '{'){
                stack.push('}');
            }else{
                if(!stack.isEmpty() && c == stack.peek()){
                    stack.pop();
                }else{
                    return false;
                }
            }
        }
        return stack.empty();
    }

    public static void main(String[] args) {
        String s = "()";
        String s1 = ")(";
        String s2 = "())";
        String s3 = "([)";
        Solution solution = new Solution();
        System.out.println(solution.isValid(s));
        System.out.println(solution.isValid(s1));
        System.out.println(solution.isValid(s2));
        System.out.println(solution.isValid(s3));
    }
}
