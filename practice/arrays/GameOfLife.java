package arrays;

/**
 * Game of Life
 * <p>
 * According to the Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton devised by the British mathematician John Horton Conway in 1970."
 * <p>
 * Given a board with m by n cells, each cell has an initial state live (1) or dead (0). Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):
 * <p>
 * Any live cell with fewer than two live neighbors dies, as if caused by under-population.
 * Any live cell with two or three live neighbors lives on to the next generation.
 * Any live cell with more than three live neighbors dies, as if by over-population..
 * Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
 * Write a function to compute the next state (after one update) of the board given its current state. The next state is created by applying the above rules simultaneously to every cell in the current state, where births and deaths occur simultaneously.
 * <p>
 * Example:
 * <p>
 * Input:
 * [
 * [0,1,0],
 * [0,0,1],
 * [1,1,1],
 * [0,0,0]
 * ]
 * Output:
 * [
 * [0,0,0],
 * [1,0,1],
 * [0,1,1],
 * [0,1,0]
 * ]
 * Follow up:
 * <p>
 * Could you solve it in-place? Remember that the board needs to be updated at the same time: You cannot update some cells first and then use their updated values to update other cells.
 * In this question, we represent the board using a 2D array. In principle, the board is infinite, which would cause problems when the active area encroaches the border of the array. How would you address these problems?
 */

public class GameOfLife {
  public void gameOfLife(int[][] board) {
    if (board == null || board.length == 0 || board[0].length == 0) {
      return;
    }

    // 0 -> 2
    // 1 -> -1

    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        int t = getLiveNeighbors(board, i, j);
        if (board[i][j] == 1) {
          if (t < 2) {
            // Rule 1 : if live & live n < 2 then die
            board[i][j] = -1;
          } else if (t == 2 || t == 3) {
            // Rule 2 : if live with 2 | 3 live n then live
            board[i][j] = 1;
          } else {
            // Rule 3 : if live with more than 3 live n then die
            board[i][j] = -1;
          }
        } else {
          if (t == 3) {
            // Rule 4 : if dead with 3 live n then live
            board[i][j] = 2;
          }
        }
      }
    }

    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (board[i][j] == -1) {
          board[i][j] = 0;
        } else if (board[i][j] == 2) {
          board[i][j] = 1;
        }
      }
    }
  }

  private int getLiveNeighbors(int[][] board, int i, int j) {
    int m = board.length;
    int n = board[0].length;
    int count = 0;

    int[] is = {i - 1, i - 1, i - 1, i, i, i + 1, i + 1, i + 1};
    int[] js = {j - 1, j, j + 1, j - 1, j + 1, j - 1, j, j + 1};

    for (int k = 0; k < is.length; k++) {
      if (isValid(m, n, is[k], js[k]) && (board[is[k]][js[k]] == 1 || board[is[k]][js[k]] == -1)) {
        count++;
      }
    }
    return count;
  }

  private boolean isValid(int m, int n, int i, int j) {
    return (i >= 0 && i < m) && (j >= 0 && j < n);
  }
}
