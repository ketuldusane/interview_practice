package algoritmns.binary_search;

/**
 * Split Array Largest Sum
 * <p>
 * Given an array which consists of non-negative integers and an integer m, you can split the array into m non-empty
 * continuous subarrays. Write an algorithm to minimize the largest sum among these m subarrays.
 * <p>
 * Note:
 * If n is the length of array, assume the following constraints are satisfied:
 * <p>
 * 1 ≤ n ≤ 1000
 * 1 ≤ m ≤ min(50, n)
 * <p>
 * Examples:
 * Input:
 * nums = [7,2,5,10,8]
 * m = 2
 * Output:
 * 18
 * Explanation:
 * There are four ways to split nums into two subarrays.
 * The best way is to split it into [7,2,5] and [10,8],
 * where the largest sum among the two subarrays is only 18.
 */

public class SplitArrayLargestSum {
  // Binary Search and Greedy combo
  // https://leetcode.com/problems/split-array-largest-sum/discuss/89817/Clear-Explanation%3A-8ms-Binary-Search-Java

  public int splitArray(int[] nums, int m) {
    // Intuition:
    // We need to split in such a way that the sum of each partition is min
    // Notice that all numbers are positive
    // Hence, the minimum sum any partition will have is going to be equal to the max number in the array
    // Hence, the result is always going to be between max num in the array and the total sum of the array
    // Interesting : We can perform a binary search to find that ans
    int max = 0;
    int sum = 0;
    for (int num : nums) {
      max = Math.max(max, num);
      sum += num;
    }
    // Start binary search
    long left = max;
    long right = sum;
    while (left <= right) {
      long mid = (left + right) / 2;
      // check whether this sum is achievable
      if (isValid(nums, m, mid)) {
        right = mid - 1;
      } else {
        left = mid + 1;
      }
    }
    return (int) left;
  }

  private boolean isValid(int[] nums, int m, long target) {
    int count = 1;
    long total = 0;
    for (int num : nums) {
      total += num;
      if (total > target) {
        total = num;
        count++;
        if (count > m) {
          return false;
        }
      }
    }
    return true;
  }
}
