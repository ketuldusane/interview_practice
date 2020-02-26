package algorithmns.DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
