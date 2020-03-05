package algorithmns.dynamic_programming_recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringPermutations {
  public static void main(String[] ans) {
    StringPermutations s = new StringPermutations();
    List<String> l = s.getAllPermutations("abc");
    for (String str : l) {
      System.out.println(str);
    }
  }

  public List<String> getAllPermutations(String s) {
    List<String> ans = new ArrayList<>();
    if (s == null || s.length() == 0) {
      return ans;
    }
    char[] chars = s.toCharArray();
    Arrays.sort(chars);
    backtrack(ans, new StringBuilder(), chars, new boolean[chars.length]);
    return ans;
  }

  private void backtrack(List<String> ans, StringBuilder sb, char[] chars, boolean[] visited) {
    if (sb.length() == chars.length) {
      ans.add(sb.toString());
    } else {
      for (int i = 0; i < chars.length; i++) {
        if (visited[i] || i > 0 && chars[i] == chars[i - 1] && !visited[i - 1]) {
          continue;
        }
        sb.append(chars[i]);
        visited[i] = true;
        backtrack(ans, sb, chars, visited);
        sb.deleteCharAt(sb.length() - 1);
        visited[i] = false;
      }
    }
  }
}
