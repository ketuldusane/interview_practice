package algorithmns.binary_search;

import java.util.Arrays;

/**
 * Valid Triangle Number
 * <p>
 * Given an array consists of non-negative integers, your task is to count the number of triplets chosen from the array
 * that can make triangles if we take them as side lengths of a triangle.
 * Example 1:
 * Input: [2,2,3,4]
 * Output: 3
 * Explanation:
 * Valid combinations are:
 * 2,3,4 (using the first 2)
 * 2,3,4 (using the second 2)
 * 2,2,3
 * Note:
 * The length of the given array won't exceed 1000.
 * The integers in the given array are in the range of [0, 1000].
 */

public class ValidTriangleNumber {
  public int triangleNumber(int[] nums) {
    Arrays.sort(nums);
    int cnt = 0;
    for (int k = 2; k < nums.length; k++) {
      int l = 0;
      int r = k - 1;
      while (l < r) {
        if (nums[l] + nums[r] > nums[k]) {
          cnt += r - l;
          r--;
        } else {
          l++;
        }
      }
    }
    return cnt;
  }

//   public int triangleNumber(int[] nums) {
//     if (nums == null || nums.length <= 2) {
//       return 0;
//     }

//     Arrays.sort(nums);
//     int count = 0;

//     for (int i = 0; i < nums.length - 2; i++) {
//       int k = i + 2;
//       for (int j = i + 1; j < nums.length - 1 && nums[i] != 0; j++) {
//         k = binarySearch(nums, k, nums.length - 1, nums[i] + nums[j]);
//         count += k - j - 1;
//       }
//     }

//     return count;
//   }

  private int binarySearch(int[] nums, int l, int r, int t) {
    while (l <= r) {
      int mid = (l + r) / 2;
      if (nums[mid] >= t) {
        r = mid - 1;
      } else {
        l = mid + 1;
      }
    }
    return l;
  }
}
