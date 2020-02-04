package algoritmns.binary_search;

/**
 * Median of Two Sorted Arrays
 *
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 *
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 *
 * You may assume nums1 and nums2 cannot be both empty.
 *
 * Example 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * The median is 2.0
 * Example 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * The median is (2 + 3)/2 = 2.5
 */

public class MedianOfTwoSortedArrays {
  public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    if (nums1.length > nums2.length) {
      return findMedianSortedArrays(nums2, nums1);
    }

    int x = nums1.length;
    int y = nums2.length;

    int low = 0;
    int high = x;

    while (low <= high) {
      int pX = (low + high) / 2;
      int pY = (x + y + 1) / 2 - pX;

      int maxLeftX = pX == 0 ? Integer.MIN_VALUE : nums1[pX - 1];
      int minRightX = pX == x ? Integer.MAX_VALUE : nums1[pX];

      int maxLeftY = pY == 0 ? Integer.MIN_VALUE : nums2[pY - 1];
      int minRightY = pY == y ? Integer.MAX_VALUE : nums2[pY];

      if (maxLeftX <= minRightY && maxLeftY <= minRightX) {
        if ((x + y) % 2 == 0) {
          return (double) (Math.max(maxLeftX, maxLeftY) + Math.min(minRightX, minRightY)) / 2;
        } else {
          return Math.max(maxLeftX, maxLeftY);
        }
      } else if (maxLeftX > minRightY) {
        high = pX - 1;
      } else {
        low = pX + 1;
      }
    }

    return (double) 0;
  }
}
