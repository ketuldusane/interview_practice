package algorithmns.dynamic_programming_recursion;

/**
 * Partition Equal Subset Sum
 *
 * Given a non-empty array containing only positive integers, find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.

 Note:

 Each of the array element will not exceed 100.
 The array size will not exceed 200.


 Example 1:

 Input: [1, 5, 11, 5]

 Output: true

 Explanation: The array can be partitioned as [1, 5, 5] and [11].


 Example 2:

 Input: [1, 2, 3, 5]

 Output: false

 Explanation: The array cannot be partitioned into equal sum subsets.
 */

public class PartitionEqualSubsetSum {
  public boolean canPartition(int[] nums) {
    if (nums == null || nums.length == 0) {
      return true;
    }

    int sum = 0;
    for (int n : nums) {
      sum += n;
    }
    if (sum % 2 == 1) {
      return false;
    }
    sum = sum / 2;
    int n = nums.length;

    return recursive(nums, sum, 0, n - 1);
  }

  private boolean recursive(int[] nums, int sum, int curr, int idx) {
    if (curr == sum) {
      return true;
    }

    if (idx < 0 || curr + nums[idx] > sum) {
      return false;
    }

    return recursive(nums, sum, curr + nums[idx], idx - 1) || recursive(nums, sum, curr, idx - 1);
  }

  private boolean dynamic(int[] nums, int sum, int n) {
    boolean[][] dp = new boolean[n + 1][sum + 1];

    // Initial pre-filling of the table
    for (int j = 0; j < sum + 1; j++) {
      dp[0][j] = false;
    }
    for (int i = 0; i < n + 1; i++) {
      dp[i][0] = true;
    }
    // main logic
    for (int i = 1; i < n + 1; i++) {
      for (int j = 1; j < sum + 1; j++) {
        dp[i][j] = dp[i - 1][j];
        if (j >= nums[i - 1]) {
          dp[i][j] = dp[i][j] || dp[i - 1][j - nums[i - 1]];
        }
      }
    }
    return dp[n][sum];
  }
}
