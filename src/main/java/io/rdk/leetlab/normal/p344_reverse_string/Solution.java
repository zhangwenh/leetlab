package io.rdk.leetlab.normal.p344_reverse_string;

public class Solution {
    public void reverseString(char[] s) {
        // 双指针法
        for(int l = 0, r = s.length - 1; l < r; l++,r--){
            char temp = s[l];
            s[l] = s[r];
            s[r] = temp;
        }
    }
}
