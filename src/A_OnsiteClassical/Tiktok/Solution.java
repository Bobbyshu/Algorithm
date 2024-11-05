package A_OnsiteClassical.Tiktok;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution {
  private static final int[][] DIRECTIONS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

  public static int minSteps(char[][] map) {
    int rows = map.length;
    int cols = map[0].length;
    PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> o1[2] - o2[2]);
    boolean[][] visited = new boolean[rows][cols];

    // 找到起点 'S'
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < cols; j++) {
        if (map[i][j] == 'S') {
          queue.offer(new int[]{i, j, 0}); // 坐标 (i, j) 和步数 0
          visited[i][j] = true;
          break;
        }
      }
    }

    // BFS 搜索
    while (!queue.isEmpty()) {
      int[] current = queue.poll();
      int x = current[0], y = current[1], steps = current[2];

      // 如果到达终点 'T'
      if (map[x][y] == 'T') {
        return steps;
      }

      // 遍历四个方向
      for (int[] dir : DIRECTIONS) {
        int nx = x + dir[0], ny = y + dir[1];

        // 检查边界和是否访问过
        if (nx >= 0 && nx < rows && ny >= 0 && ny < cols && !visited[nx][ny] && map[nx][ny] != 'W') {
          visited[nx][ny] = true;
          int extraSteps = (map[nx][ny] == 'B') ? 1 : 0; // 障碍 'B' 需要额外一步
          queue.offer(new int[]{nx, ny, steps + 1 + extraSteps});
        }
      }
    }

    // 如果找不到路径，返回 -1
    return -1;
  }

  public static void main(String[] args) {
    char[][] arr1 = {{'W', 'E', 'B', 'S'}, {'W', 'T', 'B', 'B'}};
    char[][] arr2 = {{'W', 'B', 'B', 'S'}, {'W', 'T', 'B', 'E'}};

    System.out.println(minSteps(arr1));
    System.out.println(minSteps(arr2));
  }
}

