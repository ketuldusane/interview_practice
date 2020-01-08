package trie;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * Replace Words
 * <p>
 * In English, we have a concept called root, which can be followed by some other words to form another longer word -
 * let's call this word successor. For example, the root an, followed by other, which can form another word another.
 * <p>
 * Now, given a dictionary consisting of many roots and a sentence. You need to replace all the successor in the
 * sentence with the root forming it. If a successor has many roots can form it, replace it with the root with the
 * shortest length.
 * <p>
 * You need to output the sentence after the replacement.
 * <p>
 * Example 1:
 * <p>
 * Input: dict = ["cat", "bat", "rat"]
 * sentence = "the cattle was rattled by the battery"
 * Output: "the cat was rat by the bat"
 * <p>
 * <p>
 * Note:
 * <p>
 * The input will only have lower-case letters.
 * 1 <= dict words number <= 1000
 * 1 <= sentence words number <= 1000
 * 1 <= root length <= 100
 * 1 <= sentence words length <= 1000
 */

public class ReplaceWords {
  public static void main(String[] args) {
    ReplaceWords r = new ReplaceWords();
    List<String> l = Arrays.asList("cat", "bat", "rat");
    String sentence = "the cattle was rattled by the battery";

    String ans = r.replaceWords(l, sentence);
  }

  public String replaceWords(List<String> dict, String sentence) {
    TrieNode root = new TrieNode();
    build(root, dict);

    String[] words = sentence.split(" ");
    StringBuilder ans = new StringBuilder();
    for (String word : words) {
      String r = getRoot(word, root);
      ans.append(r);
      ans.append(" ");
    }

    return ans.toString();
  }

  private String getRoot(String word, TrieNode node) {
    TrieNode curr = node;
    if (curr.children.get(word.charAt(0)) == null) {
      return word;
    }
    int depth = 0;
    for (char c : word.toCharArray()) {
      curr = curr.children.get(c);
      depth++;

      if (curr == null) {
        return word;
      }

      if (curr.isRoot) {
        return word.substring(0, depth);
      }
    }
    return word;
  }

  private void build(TrieNode node, List<String> dict) {
    for (String root : dict) {
      TrieNode curr = node;
      for (char c : root.toCharArray()) {
        curr.children.putIfAbsent(c, new TrieNode());
        curr = curr.children.get(c);
      }
      curr.isRoot = true;
    }
  }

  class TrieNode {
    HashMap<Character, TrieNode> children = new HashMap<>();
    boolean isRoot = false;
  }
}
