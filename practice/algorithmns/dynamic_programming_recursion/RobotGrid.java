import java.util.ArrayList;
import java.util.HashSet;

class RobotGrid {
  class Point {
    int row, col;
    Point(int r, int c) {
      row = r;
      col = c;
    }

    public String toString() {
      return "{ " + row + " , " + col + " }";
    }
  }

  ArrayList<Point> getPath(boolean[][] maze) {
    if (maze == null || maze.length == 0) return null;
    ArrayList<Point> path = new ArrayList<>();
    HashSet<Point> failedPoints = new HashSet<>();
    if (getPath(maze, maze.length - 1, maze[0].length - 1, path, failedPoints)) {
      return path;
    }
    return null;
  }

  boolean getPath(boolean[][] maze, int row, int col, ArrayList<Point> path, HashSet<Point> failedPoints) {
    if (row < 0 || col < 0 || !maze[row][col]) return false;
    boolean isAtOrigin = (row == 0) && (col == 0);
    Point p = new Point(row, col);
    if (failedPoints.contains(p)) return false;
    if (isAtOrigin || getPath(maze, row, col - 1, path, failedPoints) || getPath(maze, row - 1, col, path, failedPoints)) {
      path.add(p);
      return true;
    }
    failedPoints.add(p);
    return false;
  }

  public static void main(String[] args) {
    boolean[][] maze = new boolean[][] {
      {true, true, false},
      {false, true, true},
      {true, false, true}
    };

    RobotGrid m = new RobotGrid();
    ArrayList<Point> a = m.getPath(maze);
    System.out.println(a.toString());
  }
}