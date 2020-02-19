package algoritmns.binary_search;

/**
 * Missing Element In Sorted Array
 *
 * Given a sorted array A of unique numbers, find the K-th missing number starting from the leftmost number of the array.
 *
 * Example 1:
 *
 * Input: A = [4,7,9,10], K = 1
 * Output: 5
 * Explanation:
 * The first missing number is 5.
 * Example 2:
 *
 * Input: A = [4,7,9,10], K = 3
 * Output: 8
 * Explanation:
 * The missing numbers are [5,6,8,...], hence the third missing number is 8.
 * Example 3:
 *
 * Input: A = [1,2,4], K = 3
 * Output: 6
 * Explanation:
 * The missing numbers are [3,5,6,7,...], hence the third missing number is 6.
 *
 * Note:
 *
 * 1 <= A.length <= 50000
 * 1 <= A[i] <= 1e7
 * 1 <= K <= 1e8
 */

public class MissingElementInSortedArray {
  public int missingElement(int[] nums, int k) {
    int n = nums.length;
    if (k > missing(n - 1, nums)) {
      return nums[n - 1] + k - missing(n - 1, nums);
    }
    int left = 0;
    int right = n - 1;
    int mid = 0;
    while (left != right) {
      mid = (left + right) / 2;
      if (missing(mid, nums) < k) {
        left = mid + 1;
      } else {
        right = mid;
      }
    }
    return nums[left - 1] + k - missing(left - 1, nums);
  }

  private int missing(int idx, int[] nums) {
    return nums[idx] - nums[0] - idx;
  }
}
