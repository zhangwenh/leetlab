package io.rdk.leetlab.core.UnionFind;

public class UnionFind {
    private int[] root = null;
    private int count = 0;

    public UnionFind(int[][] grid) {
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
