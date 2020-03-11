package algorithmns.traversal.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Subsets
 * <p>
 * Given a set of distinct integers, nums, return all possible subsets (the power set).
 * <p>
 * Note: The solution set must not contain duplicate subsets.
 * <p>
 * Example:
 * <p>
 * Input: nums = [1,2,3]
 * Output:
 * [
 * [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 */

public class Subsets {
  public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> ans = new ArrayList<>();
    backtrack(ans, nums, new ArrayList<>(), 0);
    return ans;
  }

  private void backtrack(List<List<Integer>> ans, int[] nums, List<Integer> temp, int pos) {
    ans.add(new ArrayList<>(temp));
    for (int i = pos; i < nums.length; i++) {
      temp.add(nums[i]);
      backtrack(ans, nums, temp, pos + 1);
      temp.remove(temp.size() - 1);
    }
  }
}
