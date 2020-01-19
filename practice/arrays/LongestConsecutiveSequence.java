package arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * Longest Consecutive Sequence
 *
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

 Your algorithm should run in O(n) complexity.

 Example:

 Input: [100, 4, 200, 1, 3, 2]
 Output: 4
 Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
 */

public class LongestConsecutiveSequence {
  public int longestConsecutive(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();
    int res = 0;
    for (int n : nums) {
      if (map.containsKey(n)) {
        continue;
      } else {
        int left = map.getOrDefault(n - 1, 0);
        int right = map.getOrDefault(n + 1, 0);
        int sum = left + right + 1;
        map.put(n, sum);
        res = Math.max(res, sum);
        map.put(n - left, sum);
        map.put(n + right, sum);
      }
    }
    return res;
  }
}
