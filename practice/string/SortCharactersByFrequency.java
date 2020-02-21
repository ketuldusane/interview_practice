package string;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Sort Characters By Frequency
 *
 * Given a string, sort it in decreasing order based on the frequency of characters.
 *
 * Example 1:
 *
 * Input:
 * "tree"
 *
 * Output:
 * "eert"
 *
 * Explanation:
 * 'e' appears twice while 'r' and 't' both appear once.
 * So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
 * Example 2:
 *
 * Input:
 * "cccaaa"
 *
 * Output:
 * "cccaaa"
 *
 * Explanation:
 * Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
 * Note that "cacaca" is incorrect, as the same characters must be together.
 * Example 3:
 *
 * Input:
 * "Aabb"
 *
 * Output:
 * "bbAa"
 *
 * Explanation:
 * "bbaA" is also a valid answer, but "Aabb" is incorrect.
 * Note that 'A' and 'a' are treated as two different characters.
 */

public class SortCharactersByFrequency {
  public String frequencySort(String s) {
    if (s == null || s.length() == 0) {
      return s;
    }
    Map<Character, Node> map = new HashMap<>();
    PriorityQueue<Node> queue = new PriorityQueue<>(new NodeComparator());
    for (char c : s.toCharArray()) {
      Node n = map.getOrDefault(c, new Node(c, 0));
      n.count++;
      map.put(c, n);
    }
    for (char key : map.keySet()) {
      queue.offer(map.get(key));
    }
    StringBuilder ans= new StringBuilder();
    while (!queue.isEmpty()) {
      Node node = queue.poll();
      for (int i = 0; i < node.count; i++) {
        ans.append(node.character);
      }
    }
    return ans.toString();
  }

  private static class NodeComparator implements Comparator<Node> {
    @Override
    public int compare(Node a, Node b) {
      return b.count - a.count;
    }
  }

  private static class Node {
    char character;
    int count;
    Node (char c, int i) {
      character = c;
      count = i;
    }
  }
}
