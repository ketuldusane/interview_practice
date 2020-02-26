package algorithmns.backtracking;

public class WordSearch {
  public boolean exist(char[][] board, String word) {
    boolean[][] visited = new boolean[board.length][board[0].length];
    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (board[i][j] == word.charAt(0) && search(board, word, i, j, 0, visited)) {
          return true;
        }
      }
    }
    return false;
  }

  private boolean search(char[][] board, String word, int i, int j, int index, boolean[][] visited) {
    if (index == word.length()) {
      return true;
    }

    if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] != word.charAt(index) || visited[i][j]) {
      return false;
    }

    visited[i][j] = true;
    if (search(board, word, i - 1, j, index + 1, visited) || search(board, word, i, j - 1, index + 1, visited) || search(board, word, i, j + 1, index + 1, visited) || search(board, word, i + 1, j, index + 1, visited)) {
      return true;
    }
    visited[i][j] = false;

    return false;
  }

  public static void main(String[] args) {
    char[][] b = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
    System.out.println(new WordSearch().exist(b, "ABCCED"));
  }
}
