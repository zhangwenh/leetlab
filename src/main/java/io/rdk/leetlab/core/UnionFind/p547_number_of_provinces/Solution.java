package io.rdk.leetlab.core.UnionFind.p547_number_of_provinces;


import io.rdk.leetlab.core.UnionFind.UnionFindOne;

/**
 * union(x,y)：合并两个元素为同一个根节点
 * find(x)：找到某个元素的根节点
 */
public class Solution {
    public int findCircleNum(int[][] isConnected) {
        // 图的顶点数为 n，则初始化 n 个单顶点集合，每个集合指向自身。
        // 然后遍历图中的每个顶点，将当前顶点与其邻接点进行合并。
        // 最终结果返回合并后的集合的数量即可。
        if (isConnected == null || isConnected.length == 0) {
            return 0;
        }
        int n = isConnected.length;
        // 初始化并查集
        UnionFindOne uf = new UnionFindOne(n);
        // 遍历每个顶点，将当前顶点与其邻接点进行合并
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) { // 去掉重复合并的
                if (isConnected[i][j] == 1) {
                    uf.union(i, j);
                }
            }
        }
        // 返回最终合并后的集合的数量（总数-相连）
        return uf.getCount();
    }
}
