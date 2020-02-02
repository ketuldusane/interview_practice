package arrays;

/**
 * First Missing Positive
 *
 * Given an unsorted integer array, find the smallest missing positive integer.

 Example 1:

 Input: [1,2,0]
 Output: 3
 Example 2:

 Input: [3,4,-1,1]
 Output: 2
 Example 3:

 Input: [7,8,9,11,12]
 Output: 1
 Note:

 Your algorithm should run in O(n) time and uses constant extra space.
 */

public class FirstMissingPositive {
  public int firstMissingPositive(int[] nums) {
    if (nums == null || nums.length == 0) {
      return 1;
    }

    int n = nums.length;
    // Set all numbers in array which are 0, negative or more than to n + 1
    for (int i = 0; i < n; i++) {
      if (nums[i] <= 0 || nums[i] > n) {
        nums[i] = n + 1;
      }
    }

    // Convert indexes of numbers to negative to mark that they exist
    for (int i = 0; i < n; i++) {
      int num = Math.abs(nums[i]);
      if (num > n) {
        continue;
      }
      num--;
      if (nums[num] > 0) {
        nums[num] = -1 * nums[num];
      }
    }

    // Parse the array and the first index where number is >= 0 is the missing positive number
    for (int i = 0; i < n; i++) {
      if (nums[i] >= 0) {
        return i + 1;
      }
    }

    // If no positive number was found, that means all nums from 1 to n existed in the array
    return n + 1;
  }
}
