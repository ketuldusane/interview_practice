package queue_stack;

/**
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water
 * and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are
 * all surrounded by water.
 * <p>
 * Input:
 * 11110
 * 11010
 * 11000
 * 00000
 * <p>
 * Output: 1
 */

public class NumberOfIslands {
  public static void main(String[] args) {
    NumberOfIslands numberOfIslands = new NumberOfIslands();
    char[][] grid = {
            {'1', '1', '1', '1', '0'},
            {'1', '1', '0', '1', '0'},
            {'1', '1', '0', '0', '1'},
            {'0', '0', '0', '1', '0'}
    };
    System.out.println(numberOfIslands.numIslands(grid));
  }

  public int numIslands(char[][] grid) {
    if (grid.length == 0) return 0;

    int islandCount = 0;

    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == '1') {
          islandCount++;
          updateIsland(i, j, grid);
        }
      }
    }

    return islandCount;
  }

  private void updateIsland(int i, int j, char[][] grid) {
    if (i >= grid.length || j >= grid[0].length) return;

    grid[i][j] = '0';

    if (isSafe(i - 1, j, grid) && grid[i - 1][j] == '1') updateIsland(i - 1, j, grid);
    if (isSafe(i, j - 1, grid) && grid[i][j - 1] == '1') updateIsland(i, j - 1, grid);
    if (isSafe(i, j + 1, grid) && grid[i][j + 1] == '1') updateIsland(i, j + 1, grid);
    if (isSafe(i + 1, j, grid) && grid[i + 1][j] == '1') updateIsland(i + 1, j, grid);
  }

  private boolean isSafe(int i, int j, char[][] grid) {
    return (i < grid.length && i >= 0 && j >= 0 && j < grid[0].length);
  }
}
