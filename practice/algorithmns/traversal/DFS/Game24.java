package algorithmns.traversal.DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 24 Game
 * <p>
 * You have 4 cards each containing a number from 1 to 9. You need to judge whether they could operated through *, /, +, -, (, ) to get the value of 24.
 * <p>
 * Example 1:
 * Input: [4, 1, 8, 7]
 * Output: True
 * Explanation: (8-4) * (7-1) = 24
 * Example 2:
 * Input: [1, 2, 1, 2]
 * Output: False
 * Note:
 * The division operator / represents real division, not integer division. For example, 4 / (1 - 2/3) = 12.
 * Every operation done is between two numbers. In particular, we cannot use - as a unary operator. For example, with [1, 1, 1, 1] as input, the expression -1 - 1 - 1 - 1 is not allowed.
 * You cannot concatenate numbers together. For example, if the input is [1, 2, 1, 2], we cannot write this as 12 + 12.
 */

public class Game24 {
  private boolean ans = false;

  public boolean judgePoint24(int[] nums) {
    ArrayList<Double> list = new ArrayList<>();
    for (int val : nums) {
      list.add((double) val);
    }
    check(list);
    return ans;
  }

  private void check(List<Double> list) {
    if (list.size() == 0) {
      return;
    }
    if (list.size() == 1) {
      if (Math.abs(list.get(0) - 24.0) < 0.001) {
        ans = true;
      }
      return;
    }
    for (int i = 0; i < list.size(); i++) {
      for (int j = 0; j < i; j++) {
        double a = list.get(i);
        double b = list.get(j);
        List<Double> next = new ArrayList<>(Arrays.asList(a + b, a * b, a - b, b - a, a / b, b / a));
        list.remove(i);
        list.remove(j);
        for (double d : next) {
          list.add(d);
          check(list);
          list.remove(list.size() - 1);
        }
        list.add(j, b);
        list.add(i, a);
      }
    }
  }
}
