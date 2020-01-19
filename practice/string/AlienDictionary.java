package string;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 Alien Dictionary

 There is a new alien language which uses the latin alphabet. However, the order among letters are unknown to you. You receive a list of non-empty words from the dictionary, where words are sorted lexicographically by the rules of this new language. Derive the order of letters in this language.

 Example 1:

 Input:
 [
 "wrt",
 "wrf",
 "er",
 "ett",
 "rftt"
 ]

 Output: "wertf"
 Example 2:

 Input:
 [
 "z",
 "x"
 ]

 Output: "zx"
 Example 3:

 Input:
 [
 "z",
 "x",
 "z"
 ]

 Output: ""

 Explanation: The order is invalid, so return "".
 Note:

 You may assume all letters are in lowercase.
 You may assume that if a is a prefix of b, then a must appear before b in the given dictionary.
 If the order is invalid, return an empty string.
 There may be multiple valid order of letters, return any one of them is fine.
 */

public class AlienDictionary {
  public String alienOrder(String[] words) {
    if (words == null || words.length == 0) {
      return "";
    }

    Map<Character, Set<Character>> adj = new HashMap<>();
    Map<Character, Integer> degree = new HashMap<>();
    StringBuilder ans = new StringBuilder();

    // Set degree to 0 for each character in each word the list
    for (String s : words) {
      for (char c : s.toCharArray()) {
        degree.put(c, 0);
      }
    }

    // Compare two words at a time - compare until the length of shorter word
    // - if first characters are same, then skip
    // - if not same, create a link in adj map and increment the degree for second char
    for (int i = 0; i < words.length - 1; i++) {
      String first = words[i];
      String second = words[i + 1];
      int len = Math.min(first.length(), second.length());

      for (int j = 0; j < len; j++) {
        char c1 = first.charAt(j);
        char c2 = second.charAt(j);

        if (c1 != c2) {
          Set<Character> set;
          if (adj.containsKey(c1)) {
            set = adj.get(c1);
          } else {
            set = new HashSet<>();
          }
          if (!set.contains(c2)) {
            set.add(c2);
            adj.put(c1, set);
            degree.put(c2, degree.get(c2) + 1);
          }
          break;
        }
      }
    }

    // Topologiocal sort - BFS using queue
    Deque<Character> queue = new ArrayDeque<>();
    for (char c : degree.keySet()) {
      if (degree.get(c) == 0) {
        queue.add(c);
      }
    }

    while (!queue.isEmpty()) {
      char current = queue.remove();
      ans.append(current);
      if (adj.containsKey(current)) {
        for (char neighbor : adj.get(current)) {
          degree.put(neighbor, degree.get(neighbor) - 1);
          if (degree.get(neighbor) == 0) {
            queue.add(neighbor);
          }
        }
      }
    }

    if (ans.length() != degree.size()) return "";

    return ans.toString();
  }
}
