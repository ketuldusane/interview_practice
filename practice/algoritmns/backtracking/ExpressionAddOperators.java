package algoritmns.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Expression Add Operators
 *
 * Given a string that contains only digits 0-9 and a target value, return all possibilities to add binary operators
 * (not unary) +, -, or * between the digits so they evaluate to the target value.
 *
 * Example 1:
 *
 * Input: num = "123", target = 6
 * Output: ["1+2+3", "1*2*3"]
 * Example 2:
 *
 * Input: num = "232", target = 8
 * Output: ["2*3+2", "2+3*2"]
 * Example 3:
 *
 * Input: num = "105", target = 5
 * Output: ["1*0+5","10-5"]
 * Example 4:
 *
 * Input: num = "00", target = 0
 * Output: ["0+0", "0-0", "0*0"]
 * Example 5:
 *
 * Input: num = "3456237490", target = 9191
 * Output: []
 */

public class ExpressionAddOperators {
  public List<String> addOperators(String num, int target) {
    List<String> ans = new ArrayList<>();
    if (num == null || num.length() == 0) {
      return ans;
    }
    backtrack(ans, num, new StringBuilder(), 0, 0, 0, target);
    return ans;
  }

  private void backtrack(List<String> ans, String num, StringBuilder temp, int pos, long val, long past, long target) {
    if (pos == num.length()) {
      if (target == val) {
        ans.add(temp.toString());
      }
    } else {
      for (int i = pos; i < num.length(); i++) {
        if (i != pos && num.charAt(pos) == '0') {
          break;
        }
        int len = temp.length();
        long curr = Long.parseLong(num.substring(pos, i + 1));
        if (pos == 0) {
          backtrack(ans, num, temp.append(curr), i + 1, curr, curr, target);
          temp.setLength(len);
        } else {
          backtrack(ans, num, temp.append('+').append(curr), i + 1, val + curr, curr, target);
          temp.setLength(len);
          backtrack(ans, num, temp.append('-').append(curr), i + 1, val - curr, -curr, target);
          temp.setLength(len);
          backtrack(ans, num, temp.append('*').append(curr), i + 1, val - past + past * curr, past * curr, target);
          temp.setLength(len);
        }
      }
    }
  }
}
