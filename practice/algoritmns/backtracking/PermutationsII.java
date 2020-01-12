package algoritmns.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Permutations II
 * <p>
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 * <p>
 * Example:
 * <p>
 * Input: [1,1,2]
 * Output:
 * [
 * [1,1,2],
 * [1,2,1],
 * [2,1,1]
 * ]
 */

public class PermutationsII {
  public static void main(String[] args) {
    int[] arr = {2, 1, 1};
    List<List<Integer>> ans = new PermutationsII().permuteUnique(arr);
    for (List<Integer> l : ans) {
      System.out.println(Arrays.toString(l.toArray()));
    }
  }

  public List<List<Integer>> permuteUnique(int[] nums) {
    List<List<Integer>> ans = new ArrayList<>();
    Arrays.sort(nums);
    backtrack(ans, new ArrayList<Integer>(), nums, new boolean[nums.length]);
    return ans;
  }

  private void backtrack(List<List<Integer>> ans, ArrayList<Integer> temp, int[] nums, boolean[] visited) {
    if (temp.size() == nums.length) {
      ans.add(new ArrayList<Integer>(temp));
    } else {
      for (int i = 0; i < nums.length; i++) {
        if (visited[i] || i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
          continue;
        }
        temp.add(nums[i]);
        visited[i] = true;
        backtrack(ans, temp, nums, visited);
        temp.remove(temp.size() - 1);
        visited[i] = false;
      }
    }
  }
}
