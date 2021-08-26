package io.rdk.leetlab.core.UnionFind.p200_number_of_islands;

public class Solution {
    public int numIslands(char[][] grid) {
        // 遍历每个地区，如果当前地区为陆地，则同化其下右为陆地("1")
        // 注意：个别位置缺边
        UnionFind uf = new UnionFind(grid);
        int landCount = 0;
        int rows = grid.length;
        int cols = grid[0].length;
        int[][] directions = new int[][]{{0,1},{1,0},{-1,0},{0,-1}};
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                char curr = grid[i][j];
                if(curr == '1'){
                    landCount++;
                    for (int[] dir : directions) {
                        int x = i + dir[0];
                        int y = j + dir[1];
                        if (x >= 0 && y >= 0 && x < rows && y < cols && grid[x][y] == '1') {
                            uf.union(x*cols+y, i*cols+j);
                            // 由于下一级可能已被左上同化，因此不能直接count++
                        }
                    }
                }
            }
        }
        // 陆地数量-被union的数量 = 岛屿数量
        return landCount - uf.getUnionCount();
    }
}

class UnionFind{
    private int[] root;
    private int unionCount; // union的总数

    public UnionFind(char[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
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
        return root[x] = find(root[x]);
    }

    // Union two element into one root
    public void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX != rootY) { // 两者上一级若不一样，则同化
            root[rootX] = rootY; //把x的最祖先，替换为y的祖先。而不是仅仅替换x的祖先。有点类似树形
            unionCount++; // 去掉同化的部分
        }
    }

    public int getUnionCount() {
        return unionCount;
    }
}