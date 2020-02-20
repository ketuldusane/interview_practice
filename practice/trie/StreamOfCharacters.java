package trie;

/**
 * Stream of Characters
 *
 * Implement the StreamChecker class as follows:
 *
 * StreamChecker(words): Constructor, init the data structure with the given words.
 * query(letter): returns true if and only if for some k >= 1, the last k characters queried (in order from oldest to
 * newest, including this letter just queried) spell one of the words in the given list.
 *
 * Example:
 *
 * StreamChecker streamChecker = new StreamChecker(["cd","f","kl"]); // init the dictionary.
 * streamChecker.query('a');          // return false
 * streamChecker.query('b');          // return false
 * streamChecker.query('c');          // return false
 * streamChecker.query('d');          // return true, because 'cd' is in the wordlist
 * streamChecker.query('e');          // return false
 * streamChecker.query('f');          // return true, because 'f' is in the wordlist
 * streamChecker.query('g');          // return false
 * streamChecker.query('h');          // return false
 * streamChecker.query('i');          // return false
 * streamChecker.query('j');          // return false
 * streamChecker.query('k');          // return false
 * streamChecker.query('l');          // return true, because 'kl' is in the wordlist
 *
 * Note:
 *
 * 1 <= words.length <= 2000
 * 1 <= words[i].length <= 2000
 * Words will only consist of lowercase English letters.
 * Queries will only consist of lowercase English letters.
 * The number of queries is at most 40000.
 */

public class StreamOfCharacters {
  private Node root;
  private StringBuilder history;

  public StreamOfCharacters(String[] words) {
    root = buildTrie(words);
    history = new StringBuilder();
  }

  public boolean query(char letter) {
    history.append(letter);
    Node node = root;
    for (int i = history.length() - 1; i >= 0 && node != null; i--) {
      char c = history.charAt(i);
      node = node.nodes[c - 'a'];
      if (node != null && node.isWord) {
        return true;
      }
    }
    return false;
  }

  private Node buildTrie(String[] words) {
    root = new Node();
    for (String word : words) {
      Node node = root;
      for (int i = word.length() - 1; i >= 0; i--) {
        char c = word.charAt(i);
        if (node.nodes[c - 'a'] == null) {
          node.nodes[c - 'a'] = new Node();
        }
        node = node.nodes[c - 'a'];
      }
      node.isWord = true;
    }
    return root;
  }

  private static class Node {
    Node[] nodes = new Node[26];
    boolean isWord = false;
  }
}
