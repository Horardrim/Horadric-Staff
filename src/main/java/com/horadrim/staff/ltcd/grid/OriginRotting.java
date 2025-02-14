package com.horadrim.staff.ltcd.grid;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

import com.horadrim.staff.alg.grid.Grid;

public class OriginRotting {
    /*
     * 通过多源广度算法计算
     */
    int solution(Grid oranges) {
        int[][] grid = oranges.getGrid();
        int[] dr = new int[]{-1, 0, 1, 0};
        int[] dc = new int[]{0, -1, 0, 1};

        int R = grid.length, C = grid[0].length;
        Queue<Integer> queue = new ArrayDeque<>();
        Map<Integer, Integer> depth = new HashMap<>();

        // 寻找第一个腐烂的橘子
        for (int r = 0; r < R; ++r) {
            for (int c = 0; c < C; ++c) {
                if (grid[r][c] == 2) {
                    // 将腐烂橘子的位置信息计算为code并加入到队列中
                    int code = r * C + c;
                    queue.add(code);
                    depth.put(code, 0);
                }
            }
        }
        int ans = 0;
        while (!queue.isEmpty()) {
            // 弹出队列中第一个元素(腐烂的橘子并解码出他的位置信息
            int code = queue.remove();
            int r = code / C, c = code % C;

            // 进行上下左右搜索
            for (int k = 0; k < 4; ++k) {
                int nr = r + dr[k];
                int nc = c + dc[k];
                // 判断四周有无越界且有没有未腐烂的橘子，有的话则将位置信息计算出code并加入队列
                if (0 <= nr && nr < R && 0 <= nc && nc < C && grid[nr][nc] == 1) {
                    grid[nr][nc] = 2;
                    int ncode = nr * C + nc;
                    queue.add(ncode);
                    depth.put(ncode, depth.get(code) + 1);
                    ans = depth.get(ncode);
                }
            }
        }
        // 寻找有没有未腐烂的橘子
        for (int[] row: grid) {
            for (int v: row) {
                if (v == 1) {
                    return -1;
                }
            }
        }
        return ans;
    }
}
