package algorithmns.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 Subsets II

 Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).

 Note: The solution set must not contain duplicate subsets.

 Example:

 Input: [1,2,2]
 Output:
 [
 [2],
 [1],
 [1,2,2],
 [2,2],
 [1,2],
 []
 ]
 */

public class SubsetsII {
  public List<List<Integer>> subsetsWithDup(int[] nums) {
    List<List<Integer>> ans = new ArrayList<>();
    if (nums == null || nums.length == 0) {
      return ans;
    }
    Arrays.sort(nums);
    backtrack(ans, new ArrayList<Integer>(), nums, 0);
    return ans;
  }

  private void backtrack(List<List<Integer>> ans, List<Integer> temp, int[] nums, int start) {
    ans.add(new ArrayList<>(temp));
    for (int i = start; i < nums.length; i++) {
      if (i > start && nums[i] == nums[i - 1]) {
        continue;
      }
      temp.add(nums[i]);
      backtrack(ans, temp, nums, i + 1);
      temp.remove(temp.size() - 1);
    }
  }
}
