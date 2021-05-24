package io.rdk.leetlab.core.UnionFind.p200_number_of_islands;

public class Solution {
    // UnionFind
    // 详见DFS目录

    // 先做union：
    // 先找到第一个1，然后将其周围的1进行同化（即祖先/数组索引修改为相同）
    // 然后做后续遍历
    // 完成全部同化后，开始计算：
    // 1的数据减掉同化的数量，就是岛屿的数量
}
