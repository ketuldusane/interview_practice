package amazon.online_assesment;

import java.util.ArrayList;
import java.util.List;

/**
 * Given 2 lists a and b. Each element is a pair of integers where the first integer represents the unique id and the second integer represents a value. Your task is to find an element from a and an element form b such that the sum of their values is less or equal to target and as close to target as possible. Return a list of ids of selected elements. If no pair is possible, return an empty list.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * a = [[1, 2], [2, 4], [3, 6]]
 * b = [[1, 2]]
 * target = 7
 * <p>
 * Output: [[2, 1]]
 * <p>
 * Explanation:
 * There are only three combinations [1, 1], [2, 1], and [3, 1], which have a total sum of 4, 6 and 8, respectively.
 * Since 6 is the largest sum that does not exceed 7, [2, 1] is the optimal pair.
 * Example 2:
 * <p>
 * Input:
 * a = [[1, 3], [2, 5], [3, 7], [4, 10]]
 * b = [[1, 2], [2, 3], [3, 4], [4, 5]]
 * target = 10
 * <p>
 * Output: [[2, 4], [3, 2]]
 * <p>
 * Explanation:
 * There are two pairs possible. Element with id = 2 from the list `a` has a value 5, and element with id = 4 from the list `b` also has a value 5.
 * Combined, they add up to 10. Similarily, element with id = 3 from `a` has a value 7, and element with id = 2 from `b` has a value 3.
 * These also add up to 10. Therefore, the optimal pairs are [2, 4] and [3, 2].
 * Example 3:
 * <p>
 * Input:
 * a = [[1, 8], [2, 7], [3, 14]]
 * b = [[1, 5], [2, 10], [3, 14]]
 * target = 20
 * <p>
 * Output: [[3, 1]]
 * Example 4:
 * <p>
 * Input:
 * a = [[1, 8], [2, 15], [3, 9]]
 * b = [[1, 8], [2, 11], [3, 12]]
 * target = 20
 * <p>
 * Output: [[1, 3], [3, 2]]
 */

public class OptimalUtilization {
  public static void main(String[] args) {
    OptimalUtilization s = new OptimalUtilization();
    List<int[]> a = new ArrayList<>();
    List<int[]> b = new ArrayList<>();

    a.add(new int[]{1, 8});
    a.add(new int[]{2, 15});
    a.add(new int[]{3, 9});

    b.add(new int[]{1, 8});
    b.add(new int[]{2, 11});
    b.add(new int[]{3, 12});

    List<int[]> ans = s.optimalUtilization(a, b, 20);
    for (int[] x : ans) {
      System.out.println(x[0] + "," + x[1]);
    }
  }

  // The idea here is to use binary search on the smaller array
  public List<int[]> optimalUtilization(List<int[]> a, List<int[]> b, int target) {
    if (a.size() < b.size()) {
      return getOptimalUtilization(b, a, target, true);
    }
    return getOptimalUtilization(a, b, target, false);
  }

  private List<int[]> getOptimalUtilization(List<int[]> a, List<int[]> b, int target, boolean flipped) {
    b.sort((i, j) -> i[1] - j[1]);
    List<int[]> results = new ArrayList<>();
    int max = Integer.MIN_VALUE;

    for (int[] x : a) {
      max = search(x, b, target, max, flipped, results);
    }

    return results;
  }

  private int search(int[] x, List<int[]> b, int target, int max, boolean flipped, List<int[]> results) {
    int start = 0;
    int end = b.size() - 1;

    while (start <= end) {
      int mid = (start + end) / 2;
      int value = x[1] + b.get(mid)[1];

      if (value <= target) {
        if (max < value) {
          results.clear();
          max = value;
        }
        int[] y = flipped ? new int[]{b.get(mid)[0], x[0]} : new int[]{x[0], b.get(mid)[0]};
        results.add(y);
        start = mid + 1;
      } else {
        end = mid - 1;
      }
    }

    return max;
  }
}
