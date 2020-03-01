package algorithmns.traversal.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Combination Sum II
 *
 * Given a collection of candidate numbers (candidates) and a target number (target), find all unique combinations in candidates where the candidate numbers sums to target.

 Each number in candidates may only be used once in the combination.

 Note:

 All numbers (including target) will be positive integers.
 The solution set must not contain duplicate combinations.
 Example 1:

 Input: candidates = [10,1,2,7,6,1,5], target = 8,
 A solution set is:
 [
 [1, 7],
 [1, 2, 5],
 [2, 6],
 [1, 1, 6]
 ]
 Example 2:

 Input: candidates = [2,5,2,1,2], target = 5,
 A solution set is:
 [
 [1,2,2],
 [5]
 ]
 */

public class CombinationSumII {
  public List<List<Integer>> combinationSum2(int[] candidates, int target) {
    List<List<Integer>> list = new ArrayList<>();
    Arrays.sort(candidates);
    backtrack(list, new ArrayList<Integer>(), candidates, target, 0);
    return list;
  }

  private void backtrack(List<List<Integer>> list, List<Integer> temp, int[] nums, int remain, int start) {
    if (remain < 0) {
      return;
    } else if (remain == 0) {
      list.add(new ArrayList<>(temp));
    } else {
      for (int i = start; i < nums.length; i++) {
        if (i > start && nums[i] == nums[i - 1]) {
          continue;
        }
        temp.add(nums[i]);
        backtrack(list, temp, nums, remain - nums[i], i + 1);
        temp.remove(temp.size() - 1);
      }
    }
  }
}
