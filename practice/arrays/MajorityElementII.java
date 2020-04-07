package arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Majority Element II
 * <p>
 * Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
 * <p>
 * Note: The algorithm should run in linear time and in O(1) space.
 * <p>
 * Example 1:
 * <p>
 * Input: [3,2,3]
 * Output: [3]
 * Example 2:
 * <p>
 * Input: [1,1,1,3,3,2,2,2]
 * Output: [1,2]
 */

public class MajorityElementII {
  public List<Integer> majorityElement(int[] nums) {
    List<Integer> ans = new ArrayList<>();
    if (nums == null || nums.length == 0) {
      return ans;
    }

    int first = 0;
    int second = 0;
    int firstCount = 0;
    int secondCount = 0;

    for (int n : nums) {
      if (n == first) {
        firstCount++;
      } else if (n == second) {
        secondCount++;
      } else if (firstCount == 0) {
        firstCount++;
        first = n;
      } else if (secondCount == 0) {
        secondCount++;
        second = n;
      } else {
        firstCount--;
        secondCount--;
      }
    }

    firstCount = 0;
    secondCount = 0;
    for (int n : nums) {
      if (n == first) {
        firstCount++;
      } else if (n == second) {
        secondCount++;
      }
    }

    if (firstCount > nums.length / 3) {
      ans.add(first);
    }

    if (secondCount > nums.length / 3) {
      ans.add(second);
    }

    return ans;
  }
}
