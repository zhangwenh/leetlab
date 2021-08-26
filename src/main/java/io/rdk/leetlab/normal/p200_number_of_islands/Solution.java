package io.rdk.leetlab.normal.p200_number_of_islands;

/**
 * DFS
 */
public class Solution {
    public int numIslands(char[][] grid) {
        if(grid == null || grid.length == 0){
            return 0;
        }
        // 遍历表格
        // 当发现1，说明发现岛屿，则result+1
        // 并把当前1以及周围四个方向的1变为0，随后递归，把周围四个方向1全部变为0
        // 递归完毕后，继续循环遍历表格，直到结束
        int res = 0;
        int rowSize = grid.length;
        int colSize = grid[0].length;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] == '1'){ // 当发现1，说明发现岛屿，则result+1
                    res ++;
                    dfs(grid,i,j,rowSize,colSize); // 把自己和四周全部变成0
                }
            }
        }
        return res;
    }

    /**
     * 把自己和四周全部变成0
     * @param grid grid
     * @param x x坐标
     * @param y y坐标
     * @param rowSize 行长度，用来判断x是否到达边界
     * @param colSize 列长度，用来判断y是否到达边界
     */
    private void dfs(char[][] grid, int x, int y, int rowSize, int colSize) {
        // 越界处理
        if (x < 0 || y < 0 || x >= rowSize || y >= colSize || grid[x][y] == '0') {
            return;
        }

        grid[x][y] = '0';//把自己变成0
        // 把四周变成0，注意一定是上下左右都要！
        dfs(grid, x-1, y, rowSize, colSize);
        dfs(grid, x+1, y, rowSize, colSize);
        dfs(grid, x, y-1, rowSize, colSize);
        dfs(grid, x, y+1, rowSize, colSize);
    }
}
