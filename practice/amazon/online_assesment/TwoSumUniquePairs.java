package amazon.online_assesment;

import java.util.HashSet;
import java.util.Set;

/**
 * Two Sum Unique Pairs
 * <p>
 * Given an int array nums and an int target, find how many unique pairs in the array such that their sum is equal to
 * target. Return the number of pairs.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1, 1, 2, 45, 46, 46], target = 47
 * Output: 2
 * Explanation:
 * 1 + 46 = 47
 * 2 + 45 = 47
 * Example 2:
 * <p>
 * Input: nums = [1, 1], target = 2
 * Output: 1
 * Explanation:
 * 1 + 1 = 2
 * Example 3:
 * <p>
 * Input: nums = [1, 5, 1, 5], target = 6
 * Output: 1
 * Explanation:
 * [1, 5] and [5, 1] are considered the same.
 */

public class TwoSumUniquePairs {
  public static void main(String[] args) {
    TwoSumUniquePairs t = new TwoSumUniquePairs();
    System.out.println(t.uniquePairs(new int[]{1, 1, 2, 45, 46, 46}, 47));
    System.out.println(t.uniquePairs(new int[]{1, 1}, 2));
    System.out.println(t.uniquePairs(new int[]{1, 5, 1, 5}, 6));
  }

  public int uniquePairs(int[] pairs, int target) {
    if (pairs == null || pairs.length == 0) {
      return 0;
    }

    Set<Integer> set = new HashSet<>();
    Set<Integer> visited = new HashSet<>();
    int count = 0;

    for (int i = 0; i < pairs.length; i++) {
      int val = target - pairs[i];
      if (set.contains(val) && !visited.contains(pairs[i])) {
        visited.add(val);
        visited.add(pairs[i]);
        count++;
      }
      set.add(pairs[i]);
    }

    return count;
  }
}
