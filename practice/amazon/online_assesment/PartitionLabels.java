package amazon.online_assesment;

import java.util.ArrayList;
import java.util.List;

/**
 * Partition Labels
 * <p>
 * A string S of lowercase letters is given. We want to partition this string into as many parts as possible so that
 * each letter appears in at most one part, and return a list of integers representing the size of these parts.
 * <p>
 * Example 1:
 * Input: S = "ababcbacadefegdehijhklij"
 * Output: [9,7,8]
 * Explanation:
 * The partition is "ababcbaca", "defegde", "hijhklij".
 * This is a partition so that each letter appears in at most one part.
 * A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.
 * Note:
 * <p>
 * S will have length in range [1, 500].
 * S will consist of lowercase letters ('a' to 'z') only.
 */

public class PartitionLabels {
  public List<Integer> partitionLabels(String S) {
    if (S == null || S.length() == 0) {
      return new ArrayList<>();
    }

    int[] pos = new int[26];
    for (int i = 0; i < S.length(); i++) {
      pos[S.charAt(i) - 'a'] = i;
    }

    List<Integer> ans = new ArrayList<>();
    int start = 0;
    int end = 0;
    while (end < S.length()) {
      int i = start;
      while (start <= end) {
        char c = S.charAt(start);
        if (pos[c - 'a'] > end) {
          end = pos[c - 'a'];
        }
        start++;
      }
      ans.add(end - i + 1);
      end++;
      start = end;
    }

    return ans;
  }
}
