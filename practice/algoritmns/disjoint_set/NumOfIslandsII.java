package algoritmns.disjoint_set;

import java.util.*;

/**
 * Number of Islands II
 *
 * A 2d grid map of m rows and n columns is initially filled with water. We may perform an addLand operation which turns
 * the water at position (row, col) into a land. Given a list of positions to operate, count the number of islands after
 * each addLand operation. An island is surrounded by water and is formed by connecting adjacent lands horizontally or
 * vertically. You may assume all four edges of the grid are all surrounded by water.
 *
 * Example:
 *
 * Input: m = 3, n = 3, positions = [[0,0], [0,1], [1,2], [2,1]]
 * Output: [1,1,2,3]
 * Explanation:
 *
 * Initially, the 2d grid grid is filled with water. (Assume 0 represents water and 1 represents land).
 *
 * 0 0 0
 * 0 0 0
 * 0 0 0
 *
 * Operation #1: addLand(0, 0) turns the water at grid[0][0] into a land.
 * 1 0 0
 * 0 0 0   Number of islands = 1
 * 0 0 0
 *
 * Operation #2: addLand(0, 1) turns the water at grid[0][1] into a land.
 * 1 1 0
 * 0 0 0   Number of islands = 1
 * 0 0 0
 *
 * Operation #3: addLand(1, 2) turns the water at grid[1][2] into a land.
 * 1 1 0
 * 0 0 1   Number of islands = 2
 * 0 0 0
 *
 * Operation #4: addLand(2, 1) turns the water at grid[2][1] into a land.
 * 1 1 0
 * 0 0 1   Number of islands = 3
 * 0 1 0
 */

public class NumOfIslandsII {
  public List<Integer> numIslands2(int m, int n, int[][] positions) {
    List<Integer> ans = new ArrayList<>();
    if (m <= 0 || n <= 0) {
      return ans;
    }
    int count = 0;
    int[][] directions = new int[][]{{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    int[] parents = new int[m * n];
    Arrays.fill(parents, -1);
    for (int[] position : positions) {
      int id = n * position[0] + position[1];
      if (parents[id] != -1) {
        ans.add(count);
        continue;
      }
      parents[id] = id;
      count++;
      for (int[] dir : directions) {
        int nx = position[0] + dir[0];
        int ny = position[1] + dir[1];
        int nid = n * nx + ny;
        if (nx < 0 || nx >= m || ny < 0 || ny >= n || parents[nid] == -1) {
          continue;
        }
        int pneighbor = findSet(nid, parents);
        if (id != pneighbor) {
          parents[id] = pneighbor;
          id = pneighbor;
          count--;
        }
      }
      ans.add(count);
    }
    return ans;
  }

  private int findSet(int id, int[] parents) {
    int parent = parents[id];
    if (id == parent) {
      return parent;
    }
    parents[id] = findSet(parents[id], parents);
    return parents[id];
  }

  public static void main(String[] args) {
    NumOfIslandsII n = new NumOfIslandsII();
    int[][] p = new int[][]{{0,0}, {0,1}, {1,2}, {2,1}};
    System.out.println(n.numIslands2(3, 3, p));
  }
}
