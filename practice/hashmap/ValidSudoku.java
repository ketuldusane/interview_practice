package hashmap;

import java.util.HashMap;

/**
 * Valid Sudoku

 Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

 Each row must contain the digits 1-9 without repetition.
 Each column must contain the digits 1-9 without repetition.
 Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.

 A partially filled sudoku which is valid.

 The Sudoku board could be partially filled, where empty cells are filled with the character '.'.

 Example 1:

 Input:
 [
 ["5","3",".",".","7",".",".",".","."],
 ["6",".",".","1","9","5",".",".","."],
 [".","9","8",".",".",".",".","6","."],
 ["8",".",".",".","6",".",".",".","3"],
 ["4",".",".","8",".","3",".",".","1"],
 ["7",".",".",".","2",".",".",".","6"],
 [".","6",".",".",".",".","2","8","."],
 [".",".",".","4","1","9",".",".","5"],
 [".",".",".",".","8",".",".","7","9"]
 ]
 Output: true
 Example 2:

 Input:
 [
 ["8","3",".",".","7",".",".",".","."],
 ["6",".",".","1","9","5",".",".","."],
 [".","9","8",".",".",".",".","6","."],
 ["8",".",".",".","6",".",".",".","3"],
 ["4",".",".","8",".","3",".",".","1"],
 ["7",".",".",".","2",".",".",".","6"],
 [".","6",".",".",".",".","2","8","."],
 [".",".",".","4","1","9",".",".","5"],
 [".",".",".",".","8",".",".","7","9"]
 ]
 Output: false
 Explanation: Same as Example 1, except with the 5 in the top left corner being
 modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.
 Note:

 A Sudoku board (partially filled) could be valid but is not necessarily solvable.
 Only the filled cells need to be validated according to the mentioned rules.
 The given board contain only digits 1-9 and the character '.'.
 The given board size is always 9x9.
 */

public class ValidSudoku {
  public static void main(String[] args) {
    char[][] board = new char[][] {
      {'.','.','.','.','8','.','.','.','.'},
      {'.','.','.','.','.','.','5','.','.'},
      {'.','.','.','.','4','.','.','2','.'},
      {'.','.','.','3','.','9','.','.','.'},
      {'.','.','1','8','.','.','9','.','.'},
      {'.','.','.','.','.','5','1','.','.'},
      {'.','.','3','.','.','8','.','.','.'},
      {'.','1','2','.','3','.','.','.','.'},
      {'.','.','.','.','.','7','.','.','1'}
    };

    System.out.println(new ValidSudoku().isValidSudoku(board));
  }

  public boolean isValidSudoku(char[][] board) {
    HashMap<Character, HashMap<Integer, Integer[]>> boardMap = new HashMap<>();

    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (board[i][j] != '.') {
          int quadrant = getQuadrant(i, j);
          HashMap<Integer, Integer[]> quadrantMap;

          if (boardMap.containsKey(board[i][j])) {
            quadrantMap = boardMap.get(board[i][j]);

            if (quadrantMap.containsKey(quadrant)) return false;
            else {
              for (Integer[] values : quadrantMap.values()) {
                if (values[0] == i || values[1] == j) return false;
              }
            }
          } else {
            quadrantMap = new HashMap<>();
          }
          quadrantMap.put(quadrant, new Integer[]{i, j});
          boardMap.put(board[i][j], quadrantMap);
        }
      }
    }

    return true;
  }

  private int getQuadrant(int i, int j) {
    if (i >= 0 && i <= 2) {
      if (j >= 0 && j <= 2) {
        return 1;
      } else if (j >= 3 && j <= 5) {
        return 2;
      } else if (j >= 6 && j <= 8) {
        return 3;
      }
    } else if (i >= 3 && i <= 5) {
      if (j >= 0 && j <= 2) {
        return 4;
      } else if (j >= 3 && j <= 5) {
        return 5;
      } else if (j >= 6 && j <= 8) {
        return 6;
      }
    } else if (i >= 6 && i <= 8) {
      if (j >= 0 && j <= 2) {
        return 7;
      } else if (j >= 3 && j <= 5) {
        return 8;
      } else if (j >= 6 && j <= 8) {
        return 9;
      }
    }

    return -1;
  }
}
