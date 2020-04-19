package amazon.online_assesment;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Reorganize A String
 * <p>
 * Given a string S, check if the letters can be rearranged so that two characters that are adjacent to each other are not the same.
 * <p>
 * If possible, output any possible result.  If not possible, return the empty string.
 * <p>
 * Example 1:
 * <p>
 * Input: S = "aab"
 * Output: "aba"
 * Example 2:
 * <p>
 * Input: S = "aaab"
 * Output: ""
 * Note:
 * <p>
 * S will consist of lowercase letters and have length in range [1, 500].
 */

public class ReorganizeAString {
  public String reorganizeString(String S) {
    if (S == null || S.length() == 0) {
      return "";
    }

    Map<Character, Integer> map = new HashMap<>();
    for (char c : S.toCharArray()) {
      map.put(c, map.getOrDefault(c, 0) + 1);
    }

    PriorityQueue<Map.Entry<Character, Integer>> priorityQueue = new PriorityQueue<>((a, b) -> (b.getValue() - a.getValue()));
    priorityQueue.addAll(map.entrySet());

    StringBuilder sb = new StringBuilder();
    Deque<Map.Entry<Character, Integer>> queue = new ArrayDeque<>();

    while (!priorityQueue.isEmpty()) {
      Map.Entry<Character, Integer> nextChar = priorityQueue.poll();
      sb.append(nextChar.getKey());

      nextChar.setValue(nextChar.getValue() - 1);
      queue.offer(nextChar);

      while (queue.size() > 1) {
        Map.Entry<Character, Integer> temp = queue.poll();
        if (temp.getValue() > 0) {
          priorityQueue.offer(temp);
        }
      }
    }

    return sb.length() == S.length() ? sb.toString() : "";
  }
}
