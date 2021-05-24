package io.rdk.leetlab.core.UnionFind;

public class UnionFindOne {
    private int[] root = null;
    private int size = 0; // 集合数量

    public UnionFindOne(int n) {
        root = new int[n];
        for(int i = 0; i < n; i++) {
            root[i] = i;
        }
        size = n;
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
            size--;
        }
    }

    public int getCount() {
        return size;
    }
}
