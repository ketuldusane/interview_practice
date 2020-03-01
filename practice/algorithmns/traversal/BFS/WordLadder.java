package algorithmns.traversal.BFS;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * Word Ladder
 * <p>
 * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:
 * <p>
 * Only one letter can be changed at a time.
 * Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 * Note:
 * <p>
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * You may assume no duplicates in the word list.
 * You may assume beginWord and endWord are non-empty and are not the same.
 * Example 1:
 * <p>
 * Input:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 * <p>
 * Output: 5
 * <p>
 * Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 * Example 2:
 * <p>
 * Input:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 * <p>
 * Output: 0
 * <p>
 * Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
 */

public class WordLadder {
  public int ladderLength(String beginWord, String endWord, List<String> wordList) {
    Set<String> dict = new HashSet<>(wordList);
    Set<String> visited = new HashSet<>();
    int ladder = 1;
    Queue<String> queue = new ArrayDeque<>();
    queue.add(beginWord);
    while (!queue.isEmpty()) {
      int size = queue.size();
      for (int k = 0; k < size; k++) {
        String word = queue.poll();
        if (word.equals(endWord)) {
          return ladder;
        }
        for (String neighbor : getNeighbors(word, dict, visited)) {
          queue.offer(neighbor);
        }
      }
      ladder++;
    }
    return 0;
  }

  private List<String> getNeighbors(String word, Set<String> wordList, Set<String> visited) {
    List<String> neighbors = new ArrayList<>();
    for (int i = 0; i < word.length(); i++) {
      char[] w = word.toCharArray();
      for (char c = 'a'; c <= 'z'; c++) {
        if (c == w[i]) {
          continue;
        }
        w[i] = c;
        String test = new String(w);
        if (wordList.contains(test) && !visited.contains(test)) {
          neighbors.add(test);
          visited.add(test);
        }
      }
    }
    return neighbors;
  }
}
