package algorithmns.BFS;

import java.util.*;

/**
 * Sliding Puzzle
 *
 * On a 2x3 board, there are 5 tiles represented by the integers 1 through 5, and an empty square represented by 0.
 * A move consists of choosing 0 and a 4-directionally adjacent number and swapping it.
 * The state of the board is solved if and only if the board is [[1,2,3],[4,5,0]].
 * Given a puzzle board, return the least number of moves required so that the state of the board is solved. If it is
 * impossible for the state of the board to be solved, return -1.
 *
 * Examples:
 *
 * Input: board = [[1,2,3],[4,0,5]]
 * Output: 1
 * Explanation: Swap the 0 and the 5 in one move.
 *
 * Input: board = [[1,2,3],[5,4,0]]
 * Output: -1
 * Explanation: No number of moves will make the board solved.
 *
 * Input: board = [[4,1,2],[5,0,3]]
 * Output: 5
 * Explanation: 5 is the smallest number of moves that solves the board.
 * An example path:
 * After move 0: [[4,1,2],[5,0,3]]
 * After move 1: [[4,1,2],[0,5,3]]
 * After move 2: [[0,1,2],[4,5,3]]
 * After move 3: [[1,0,2],[4,5,3]]
 * After move 4: [[1,2,0],[4,5,3]]
 * After move 5: [[1,2,3],[4,5,0]]
 *
 * Input: board = [[3,2,4],[1,5,0]]
 * Output: 14
 *
 * Note:
 * board will be a 2 x 3 array as described above.
 * board[i][j] will be a permutation of [0, 1, 2, 3, 4, 5].
 */

public class SlidingPuzzle {
  // Lets assume that each matrix state is a node
  // Taking all these nodes, we will run a standard BFS and search for the shortest path
  // initial state will be the given board and final state is {{1,2,3},{4,5,0}}
  // We will store states as string in a hashset

  public int slidingPuzzle(int[][] board) {
    if (board == null || board.length == 0) {
      return -1;
    }
    int[][] dir = new int[][]{{1,3}, {0, 2, 4}, {1, 5}, {0, 4}, {1, 3, 5}, {2, 4}};
    int result = 0;
    // Terminal State
    String terminal = "123450";
    // Initial State
    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        sb.append(board[i][j]);
      }
    }
    Set<String> visited = new HashSet<>();
    Deque<String> queue = new ArrayDeque<>();
    visited.add(sb.toString());
    queue.offer(sb.toString());
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int i = 0; i < size; i++) {
        String curr = queue.poll();
        if (curr.equals(terminal)) {
          return result;
        }
        int zero = curr.indexOf('0');
        List<String> neighbors = getNeighbors(curr, dir[zero], zero);
        for (String neighbor : neighbors) {
          if (visited.contains(neighbor)) {
            continue;
          }
          visited.add(neighbor);
          queue.offer(neighbor);
        }
      }
      result++;
    }
    return -1;
  }

  private List<String> getNeighbors(String s, int[] dir, int zero) {
    List<String> neighbors = new ArrayList<>();
    for (int d : dir) {
      neighbors.add(swap(s, zero, d));
    }
    return neighbors;
  }

  private String swap(String s, int i, int j) {
    StringBuilder sb = new StringBuilder(s);
    char a = sb.charAt(i);
    sb.setCharAt(i, sb.charAt(j));
    sb.setCharAt(j, a);
    return sb.toString();
  }
}
