package io.rdk.leetlab.core.Stack.p20_valid_parentheses;

import java.nio.charset.StandardCharsets;
import java.util.Stack;

public class Solution {

    public boolean isValid(String s) {
        if(s == null){
            return false;
        }
        if(s.isEmpty()){
            return true;
        }
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if(c=='(')
                stack.push(')');
            else if(c=='[')
                stack.push(']');
            else if(c=='{')
                stack.push('}');
            else if(stack.isEmpty() || c != stack.pop())
                return false;
        }
        return stack.isEmpty();
    }
}
