package algorithmns.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Combination Sum
 *
 * Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

 The same repeated number may be chosen from candidates unlimited number of times.

 Note:

 All numbers (including target) will be positive integers.
 The solution set must not contain duplicate combinations.
 Example 1:

 Input: candidates = [2,3,6,7], target = 7,
 A solution set is:
 [
 [7],
 [2,2,3]
 ]
 Example 2:

 Input: candidates = [2,3,5], target = 8,
 A solution set is:
 [
 [2,2,2,2],
 [2,3,3],
 [3,5]
 ]
 */

public class CombinationSum {
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    List<List<Integer>> list = new ArrayList<>();
    backtrack(list, new ArrayList<Integer>(), candidates, target, 0);
    return list;
  }

  private void backtrack(List<List<Integer>> list, List<Integer> temp, int[] candidates, int remain, int start) {
    if (remain < 0) {
      return;
    }
    if (remain == 0) {
      list.add(new ArrayList<>(temp));
    } else {
      for (int i = start; i < candidates.length; i++) {
        temp.add(candidates[i]);
        backtrack(list, temp, candidates, remain - candidates[i], i);
        temp.remove(temp.size() - 1);
      }
    }
  }
}
