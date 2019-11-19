package hashmap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array
 * such that nums[i] = nums[j] and the absolute difference between i and j is at most k.
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,1], k = 3
 * Output: true
 * Example 2:
 *
 * Input: nums = [1,0,1,1], k = 1
 * Output: true
 * Example 3:
 *
 * Input: nums = [1,2,3,1,2,3], k = 2
 * Output: false
 */

public class ContainsDuplicate {
  public static void main(String[] args) {
    System.out.println(new ContainsDuplicate().containsNearbyDuolicateOptimized(new int[]{2,2}, 3));
  }

  public boolean containsNearbyDuolicateOptimized(int[] nums, int k) {
    Set<Integer> set = new HashSet<>();
    for (int i = 0; i < nums.length; i++) {
      if (i > k)
        set.remove(nums[i - k - 1]);
      if (!set.add(nums[i]))
        return true;
    }
    return false;
  }

  public boolean containsNearbyDuplicate(int[] nums, int k) {
    if (nums.length == 0 || nums.length == 1) return false;

    Map<Integer, HashSet<Integer>> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
      HashSet<Integer> set;
      if (!map.containsKey(nums[i])) {
        set = new HashSet<>();
        set.add(i + k);
        map.put(nums[i], set);
      } else {
        set = map.get(nums[i]);
        for (int j : set) {
          if (i <= j) {
            return true;
          }
        }
        set.add(i + k);
        map.put(nums[i], set);
      }
    }
    return false;
  }
}
