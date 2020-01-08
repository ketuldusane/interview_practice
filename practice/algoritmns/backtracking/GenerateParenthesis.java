package algoritmns.backtracking;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {
  private List<String> output = new ArrayList<>();

  public List<String> generateParenthesis(int n) {
    generate("", 0, 0, n);
    return output;
  }

  private void generate(String s, int open, int close, int n) {
    if (s.length() == n * 2) {
      output.add(s);
      return;
    }

    if (open < n) {
      generate(s + "(", open + 1, close, n);
    }
    if (close < open) {
      generate(s + ")", open, close + 1, n);
    }
  }

  public static void main(String[] args) {
    GenerateParenthesis g = new GenerateParenthesis();
    List<String> o = g.generateParenthesis(3);
  }
}
