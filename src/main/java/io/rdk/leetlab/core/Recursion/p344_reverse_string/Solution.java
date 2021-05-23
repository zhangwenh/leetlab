package io.rdk.leetlab.core.Recursion.p344_reverse_string;

class Solution {
    public void reverseString(char[] s) {
        if(s==null || s.length<2){
            return;
        }
        int left = 0,right = s.length-1;
        reverseChar(s,left,right);
    }
    private void reverseChar(char[] s, int left,int right){
        if(left>=right){
            return;
        }
        char temp = s[left];
        s[left] = s[right];
        s[right] = temp;
        reverseChar(s,++left,--right);
    }

    public static void main(String[] args) {
        char[] s = "hello".toCharArray();
        Solution solution = new Solution();
        solution.reverseString(s);
        System.out.println(String.valueOf(s));
    }
}