import java.util.*;

public class WordSearchII {
  HashMap<Character, List<String>> dict = new HashMap<>();

  public List<String> findWords(char[][] board, String[] words) {
    return findWordsWithTrie(board, words);
  }

  public List<String> findWordsWithTrie(char[][] board, String[] words) {
    HashSet<String> res = new HashSet<>();

    if (board == null || board.length == 0 || board[0].length == 0 || words == null || words.length == 0) {
      return new ArrayList<>(res);
    }

    TrieNode root = buildTrie(words);

    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        dfs(board, i, j, root, res);
      }
    }

    return new ArrayList<>(res);
  }

  private void dfs(char[][] board, int i, int j, TrieNode node, HashSet<String> res) {
    char c = board[i][j];
    if (c == '#' || node.children[c - 'a'] == null) {
      return;
    }
    node = node.children[c - 'a'];
    if (node.word != null) {
      res.add(node.word);
      node.word = null;
    }
    board[i][j] = '#';
    if (i > 0) dfs(board, i - 1, j, node, res);
    if (j > 0) dfs(board, i, j - 1, node, res);
    if (i < board.length - 1) dfs(board, i + 1, j, node, res);
    if (j < board[0].length - 1) dfs(board, i, j + 1, node, res);
    board[i][j] = c;
  }

  private TrieNode buildTrie(String[] words) {
    TrieNode root = new TrieNode();
    for (String word : words) {
      TrieNode node = root;
      for (char c : word.toCharArray()) {
        if (node.children[c - 'a'] == null) {
          node.children[c - 'a'] = new TrieNode();
        }
        node = node.children[c - 'a'];
      }
      node.word = word;
    }
    return root;
  }

  public List<String> findWordsBacktrack(char[][] board, String[] words) {
    HashSet<String> res = new HashSet<>();
    for (String word : words) {
      List<String> l = dict.getOrDefault(word.charAt(0), new ArrayList<String>());
      l.add(word);
      dict.put(word.charAt(0), l);
    }

    int[] moveX = {0, 0, -1, 1};
    int[] moveY = {1, -1, 0, 0};

    int[][] visited;

    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        if (dict.containsKey(board[i][j])) {
          for (String word : dict.get(board[i][j])) {
            visited = new int[board.length][board[0].length];

            if (findWordsUtil(board, word, 0, i, j, moveX, moveY, visited)) {
              res.add(word);
            }
          }
        }
      }
    }

    return new ArrayList<String>(res);
  }

  private boolean findWordsUtil(char[][] board, String word, int pos, int i, int j, int[] moveX, int[] moveY, int[][] visited) {
    if (board[i][j] != word.charAt(pos)) {
      return false;
    }

    if (pos == word.length() - 1 && board[i][j] == word.charAt(pos)) {
      return true;
    }

    visited[i][j] = 1;

    for (int k = 0; k < moveX.length; k++) {
      int nextX = i + moveX[k];
      int nextY = j + moveY[k];

      if (isSafe(board, nextX, nextY) && visited[nextX][nextY] == 0) {
        if (findWordsUtil(board, word, pos + 1, nextX, nextY, moveX, moveY, visited)) {
          return true;
        } else {
          visited[nextX][nextY] = 0;
        }
      }
    }

    return false;
  }

  private boolean isSafe(char[][] board, int i, int j) {
    return i >= 0 && i < board.length && j >= 0 && j < board[0].length;
  }

  static class TrieNode {
    TrieNode[] children = new TrieNode[26];
    String word = null;
  }

  public static void main(String[] args) {
    WordSearchII w = new WordSearchII();
    String[] words = {"ab","cb","ad","bd","ac","ca","da","bc","db","adcb","dabc","abb","acb"};
    char[][] board = {
        {'a', 'b'},
        {'c', 'd'}
    };

    List<String> ans = w.findWords(board, words);
  }
}
