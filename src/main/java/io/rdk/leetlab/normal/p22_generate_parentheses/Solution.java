package io.rdk.leetlab.normal.p22_generate_parentheses;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        backtracking(n, result, 0, 0, "");
        return result;
    }

    /**
     *
     * @param n 要生成的括号数量
     * @param result 返回结果
     * @param left 左边括号数量
     * @param right 右边括号数量
     * @param str 当前对应要生成的括号
     */
    private void backtracking(int n, List<String> result, int left, int right, String str) {
        if (right > left) { // 右括号数量>左括号数量，此时已经是无效的了，因此退出
            return;
        }
        if (right == n) { // 已经成立，这条路径结束
            result.add(str);
            return;
        }

        if (left < n) { // 还有左括号要加，因此加左括号
            backtracking(n, result, left+1, right, str+"(");
        }

        if (right < left) { // 加右括号
            backtracking(n, result, left, right+1, str+")");
        }
    }

    public static void main(String[] args) {
        int n = 3;
        Solution solution = new Solution();
        List<String> list = solution.generateParenthesis(n);
        for (String s : list) {
            System.out.println(s);
        }
    }
}
