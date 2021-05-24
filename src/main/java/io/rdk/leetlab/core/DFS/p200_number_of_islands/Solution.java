package io.rdk.leetlab.core.DFS.p200_number_of_islands;

/**
 * DFS
 * 该题还是有BFS、UnionFind的方法
 */
public class Solution {
    // 遍历表格
    // 当发现1，说明发现岛屿，则result+1
    // 并把当前1以及周围四个方向的1变为0，随后递归，把周围四个方向1全部变为0
    // 递归完毕后，继续循环遍历表格，直到结束
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int result = 0;
        int row = grid.length;
        int col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') { // 当发现1，说明发现岛屿，则result+1
                    result++;
                    dfs(grid, i, j, row, col); // 用递归将自己以及周围四个方向的1变为0
                }
            }
        }
        return result;
    }

    private void dfs(char[][] grid, int x, int y, int row, int col) {
        // 越界处理
        if (x < 0 || y < 0 || x >= row || y >= col || grid[x][y] == '0') {
            return;
        }

        grid[x][y] = '0';
        dfs(grid, x-1, y, row, col);
        dfs(grid, x+1, y, row, col);
        dfs(grid, x, y-1, row, col);
        dfs(grid, x, y+1, row, col);
    }
}
