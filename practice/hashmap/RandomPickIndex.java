package hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

/**
 * Given an array of integers with possible duplicates, randomly output the index of a given target number. You can
 * assume that the given target number must exist in the array.
 *
 * Note:
 * The array size can be very large. Solution that uses too much extra space will not pass the judge.
 *
 * Example:
 *
 * int[] nums = new int[] {1,2,3,3,3};
 * Solution solution = new Solution(nums);
 *
 * // pick(3) should return either index 2, 3, or 4 randomly. Each index should have equal probability of returning.
 * solution.pick(3);
 *
 * // pick(1) should return 0. Since in the array only nums[0] is equal to 1.
 * solution.pick(1);
 */

public class RandomPickIndex {
  private Map<Integer, List<Integer>> map = new HashMap<>();

  public RandomPickIndex(int[] nums) {
    if (nums != null || nums.length > 0) {
      for (int i = 0; i < nums.length; i++) {
        List<Integer> list = map.getOrDefault(nums[i], new ArrayList<>());
        list.add(i);
        map.put(nums[i], list);
      }
    }
  }

  public int pick(int target) {
    List<Integer> list = map.get(target);
    return getRandom(list);
  }

  private int getRandom(List<Integer> list) {
    Random random = new Random();
    int i = random.nextInt(list.size());
    return list.get(i);
  }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */