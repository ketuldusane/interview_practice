package hashmap;

import java.util.HashSet;
import java.util.Set;

/**
 * Add and Search Word - Data structure design
 * <p>
 * Design a data structure that supports the following two operations:
 * <p>
 * void addWord(word)
 * bool search(word)
 * search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.
 * <p>
 * Example:
 * <p>
 * addWord("bad")
 * addWord("dad")
 * addWord("mad")
 * search("pad") -> false
 * search("bad") -> true
 * search(".ad") -> true
 * search("b..") -> true
 * Note:
 * You may assume that all words are consist of lowercase letters a-z.
 */

public class AddSearchWord {
  private TrieNode root;

  /**
   * Initialize your data structure here.
   */
  public AddSearchWord() {
    root = new TrieNode();
  }

  public static void main(String[] args) {
    AddSearchWord a = new AddSearchWord();
    a.addWord("bad");
    a.addWord("dad");
    a.addWord("mad");
    a.search("pad");
    a.search("bad");
    a.search(".ad");
    a.search("b..");
  }

  /**
   * Adds a word into the data structure.
   */
  public void addWord(String word) {
    TrieNode node = root;
    for (char c : word.toCharArray()) {
      if (node.children[c - 'a'] == null) {
        node.children[c - 'a'] = new TrieNode();
      }
      node = node.children[c - 'a'];
    }
    node.isWord = true;
  }

  /**
   * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
   */
  public boolean search(String word) {
    return match(word.toCharArray(), 0, root);
  }

  private boolean match(char[] word, int k, TrieNode node) {
    if (word.length == k) {
      return node.isWord;
    }
    if (word[k] != '.') {
      return node.children[word[k] - 'a'] != null && match(word, k + 1, node.children[word[k] - 'a']);
    } else {
      for (int i = 0; i < 26; i++) {
        if (node.children[i] != null) {
          if (match(word, k + 1, node.children[i])) {
            return true;
          }
        }
      }
    }
    return false;
  }

  class TrieNode {
    TrieNode[] children = new TrieNode[26];
    boolean isWord = false;
  }
}
