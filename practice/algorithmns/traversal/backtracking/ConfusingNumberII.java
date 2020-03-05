package algorithmns.traversal.backtracking;

import java.util.HashSet;
import java.util.Set;

/**
 * Confusing Number II
 * <p>
 * We can rotate digits by 180 degrees to form new digits. When 0, 1, 6, 8, 9 are rotated 180 degrees, they become
 * 0, 1, 9, 8, 6 respectively. When 2, 3, 4, 5 and 7 are rotated 180 degrees, they become invalid.
 * <p>
 * A confusing number is a number that when rotated 180 degrees becomes a different number with each digit valid.(Note
 * that the rotated number can be greater than the original number.)
 * <p>
 * Given a positive integer N, return the number of confusing numbers between 1 and N inclusive.
 * <p>
 * Example 1:
 * Input: 20
 * Output: 6
 * Explanation:
 * The confusing numbers are [6,9,10,16,18,19].
 * 6 converts to 9.
 * 9 converts to 6.
 * 10 converts to 01 which is just 1.
 * 16 converts to 91.
 * 18 converts to 81.
 * 19 converts to 61.
 * <p>
 * Example 2:
 * Input: 100
 * Output: 19
 * Explanation:
 * The confusing numbers are [6,9,10,16,18,19,60,61,66,68,80,81,86,89,90,91,98,99,100].
 */

public class ConfusingNumberII {
  public static void main(String[] args) {
    ConfusingNumberII confusingNumberII = new ConfusingNumberII();
    int ans = confusingNumberII.confusingNumberII(1000000000);
    System.out.println(ans);
  }

  public int confusingNumberII(int N) {
    if (N <= 5) {
      return 0;
    }
    int[] nums = {0, 1, 6, 8, 9};
    Set<String> ans = new HashSet<>();
    backtrack(ans, nums, N, Integer.toString(N), new StringBuilder());
    return ans.size();
  }

  private void backtrack(Set<String> ans, int[] nums, long N, String target, StringBuilder temp) {
    if (temp.length() > 0 && temp.length() <= target.length() && !ans.contains(temp.toString())) {
      String confusedNum = getConfusedNum(temp.toString()); // Implement
      if (!temp.toString().equals(confusedNum)) {
        ans.add(temp.toString());
      }
    }
    for (int i = 0; i < nums.length; i++) {
      if (i == 0 && temp.length() == 0) {
        continue;
      }
      temp.append(nums[i]);
      if (temp.length() <= target.length() && Long.parseLong(temp.toString()) <= N) {
        backtrack(ans, nums, N, target, temp);
      }
      temp.deleteCharAt(temp.length() - 1);
    }
  }

  private String getConfusedNum(String n) {
    char[] c = n.toCharArray();
    int i = 0;
    int j = c.length - 1;
    while (i <= j) {
      char t = c[i];
      c[i] = c[j];
      c[j] = t;

      if (c[i] == '6' || c[i] == '9') {
        c[i] = (c[i] == '6') ? '9' : '6';
      }

      if (i != j) {
        if (c[j] == '6' || c[j] == '9') {
          c[j] = (c[j] == '6') ? '9' : '6';
        }
      }

      i++;
      j--;
    }
    return new String(c);
  }
}
