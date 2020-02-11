class TestTemp {
  public static void main(String[] args) {
    TestTemp t = new TestTemp();
    int[][] grid = {{1,0,0,0},{0,0,0,0},{0,0,0,2}};
    int ans = t.uniquePathsIII(grid);
    System.out.println(ans);
  }

  private int count = 0;
  private int wall = 0;
  private int[][] dir = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};

  public int uniquePathsIII(int[][] grid) {
    if (grid == null || grid.length == 0) {
      return count;
    }
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == -1) {
          wall++;
        }
      }
    }
    for (int i = 0; i < grid.length; i++) {
      for (int j = 0; j < grid[0].length; j++) {
        if (grid[i][j] == 1) {
          boolean[][] visited = new boolean[grid.length][grid[0].length];
          visited[i][j] = true;
          backtrack(grid, i, j, 1, visited);
        }
      }
    }
    return count;
  }

  private void backtrack(int[][] grid, int i, int j, int pathSize, boolean[][] visited) {
    if (grid[i][j] == -1) {
      return;
    }
    if (grid[i][j] == 2) {
      if (pathSize == (grid.length * grid[0].length) - wall) {
        count++;
      }
    }
    for (int k = 0; k < dir.length; k++) {
      int x = i + dir[k][0];
      int y = j + dir[k][1];
      if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length && !visited[x][y]) {
        visited[x][y] = true;
        backtrack(grid, x, y, pathSize + 1, visited);
        visited[x][y] = false;
      }
    }
  }
}