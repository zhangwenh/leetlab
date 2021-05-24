package io.rdk.leetlab.core.BFS.p200_number_of_islands;

import java.util.LinkedList;
import java.util.Queue;

/**
 * BFS
 * 该题还是有DFS、UnionFind的方法
 */
public class Solution1 {
    // 遍历表格
    // 一旦发现1，result++，并将对应坐标放到队列中
    // 然后从队列中取出坐标，检查周围是否有1，若有，也放到队列中
    // 把1对应坐标的值置为0
    // 继续遍历
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) {
            return 0;
        }
        int result = 0;
        int row = grid.length;
        int col = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == '1') {
                    result++;
                    queue.add(new int[]{i,j});
                    grid[i][j] = '0';
                    while (queue.size() > 0) {
                        int[]  cur = queue.poll();
                        int x = cur[0];
                        int y = cur[1];
                        if (x-1 >= 0 && grid[x-1][y] == '1' ) {
                            queue.add(new int[]{x-1, y});
                            grid[x-1][y] = '0';
                        }
                        if (y-1 >= 0 && grid[x][y-1] == '1') {
                            queue.add(new int[]{x, y-1});
                            grid[x][y-1] = '0';
                        }
                        if (x+1 < row && grid[x+1][y] == '1') {
                            queue.add(new int[]{x+1, y});
                            grid[x+1][y] = '0';
                        }
                        if (y+1 < col && grid[x][y+1] == '1') {
                            queue.add(new int[]{x, y+1});
                            grid[x][y+1] = '0';
                        }
                    }
                }
            }
        }
        return result;
    }

}
