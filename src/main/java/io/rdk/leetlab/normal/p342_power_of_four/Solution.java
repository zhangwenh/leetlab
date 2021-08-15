package io.rdk.leetlab.normal.p342_power_of_four;

public class Solution {
    public boolean isPowerOfFour(int n) {
        // 位运算
        // 4^x = (3+1)^x = 3^x+1
        // (3^x+1)%3 = 1
        // 同理 4^x *2 = 2x3^x + 2 , 此时%3=2
        // 因此4的幂就是，2的幂，同时%3==1
        return (n & (n - 1)) == 0 && n % 3 == 1;
    }

    public boolean isPowerOfFour1(int n) {
        // 位运算
        // 如果 n 是 4 的幂，那么 n 的二进制表示中有且仅有一个 1，
        // 并且这个 1 出现在从低位开始的第偶数个二进制位上（这是因为这个 1 后面必须有偶数个 0）
        // 例如16： (10000)2 2进制
        // 因此，构造一个整数 mask，它的所有偶数二进制位都是 0，所有奇数二进制位都是 1
        // mask=(10101010101010101010101010101010)2 2进制
        // 或者mask=(AAAAAAAA)16 16进制
        // 将 n 和 mask 进行按位与运算
        // 如果结果为 0，说明 n 二进制表示中的 1 出现在偶数的位置，
        // 否则说明其出现在奇数的位置
        return n>0 && (n & (n - 1)) == 0 && (n & 0xaaaaaaaa) == 0;
    }
}
