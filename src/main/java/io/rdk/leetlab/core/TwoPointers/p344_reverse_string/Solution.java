package io.rdk.leetlab.core.TwoPointers.p344_reverse_string;

class Solution {
    public void reverseString(char[] s) {
        for (int i = 0,j=s.length-1; i < j; i++,j--) {
            char temp = s[i];
            s[i] = s[j];
            s[j] = temp;
        }

//        if(s == null || s.length <= 1){
//            return;
//        }
//        char temp;
//        int len = s.length;
//        for(int i= 0; i < len/2; i++){
//            int j = len - i -1;
//            temp = s[i];
//            s[i] = s[j];
//            s[j] = temp;
//        }
    }
}
