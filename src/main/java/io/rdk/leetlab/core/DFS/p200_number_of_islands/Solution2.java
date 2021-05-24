package io.rdk.leetlab.core.DFS.p200_number_of_islands;

import java.util.LinkedList;
import java.util.Queue;

/**
 * UnionFind
 * 该题还是有DFS、BFS的方法
 */
class Solution2 {
    // 先做union：
    // 先找到第一个1，然后将其周围的1进行同化（即祖先/数组索引修改为相同）
    // 然后做后续遍历
    // 完成全部同化后，开始计算：
    // 1的数据减掉同化的数量，就是岛屿的数量
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int row = grid.length;
        int col = grid[0].length;
        int waters = 0;
        UnionFind uf = new UnionFind(grid);
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '0') {
                    waters++;
                } else {
                    int[][] directions = new int[][]{{0,1}, {0, -1}, {1, 0}, {-1, 0}};
                    for (int[] dir : directions) {
                        int x = i + dir[0];
                        int y = j + dir[1];
                        if (x >= 0 && y >= 0 && x < row && y < col && grid[x][y] == '1') {
                            uf.union(x*col+y, i*col+j);
                        }
                    }
                }
            }
        }
        return uf.getCount() - waters;
    }
}

class UnionFind {
    private int[] root = null;
    private int count = 0;

    public UnionFind(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        count = row * col;
        root = new int[row*col];
        for(int i = 0; i < row*col; i++) {
            root[i] = i;
        }
    }

    // Find the root of X
    public int find(int x) {
        if (x == root[x]) {
            return x;
        }
        return root[x] = find(root[x]); // 递归
    }

    // Union two element into one root
    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) {
            root[rootX] = rootY;
            count--;
        }
    }

    public int getCount() {
        return count;
    }
}
