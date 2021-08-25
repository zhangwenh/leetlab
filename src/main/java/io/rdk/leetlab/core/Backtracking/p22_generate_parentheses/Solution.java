package io.rdk.leetlab.core.Backtracking.p22_generate_parentheses;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtracking(n,result,0,0,"");
        return result;
    }

    /**
     *
     * @param n 要生成的括号数量
     * @param result 返回的结果
     * @param leftCnt 当前左括号数量
     * @param rightCnt 当前右括号数量
     * @param curStr 拼接中的括号字符串
     */
    private void backtracking(int n, List<String> result, int leftCnt, int rightCnt, String curStr) {
        // 1，判断当前括号数量，如果右括号大于左括号，则说明已经无效，此时退出
        // 2，如果左括号=有括号=n说明此时已经匹配，则加入结果集合
        // 3，递归加括号，先加左括号，再加右括号
        // 那么每个左括号加完都对应了三次加右括号的递归。其中不匹配的括号条件会自动退出
        // 先加3次左括号，则对应加3次右括号；随后3次左括号的递归退出，进入2次左括号1次右括号的递归。。。
        if(leftCnt<rightCnt){
            return;
        }
        if(leftCnt == n && rightCnt == n){ // 已经成立，这条路径结束
            result.add(curStr);
            return;
        }
        if(leftCnt<n){ // 还有左括号要加，因此加左括号
            backtracking(n,result,leftCnt+1,rightCnt,curStr+"(");
        }
        if(rightCnt<n){
            backtracking(n,result,leftCnt,rightCnt+1,curStr+")");
        }
    }

    public static void main(String[] args) {
        int n = 3;
        Solution s = new Solution();
        s.generateParenthesis(n);
    }
}
