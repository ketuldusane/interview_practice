package algoritmns.binary_search;

/**
 * Find Minimum in Rotated Sorted Array
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
 * Find the minimum element.
 * You may assume no duplicate exists in the array.
 *
 * Example 1:
 * Input: [3,4,5,1,2]
 * Output: 1
 *
 * Example 2:
 * Input: [4,5,6,7,0,1,2]
 * Output: 0
 */

public class MinRotatedArray {
  public int findMin(int[] num) {
    int l = 0, r = num.length - 1, m = 0;
    if (num[l] < num[r]) return num[l];
    while (l < r) {
      m = l + (r - l) / 2;
      if (num[m] > num[m + 1]) return num[m + 1];
      if (num[m] > num[r]) { l = m + 1; }
      else { r = m; }
    }
    return num[m];
  }
}
