package queue_stack.monotonic_stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * Next Greater Element I
 *
 * You are given two arrays (without duplicates) nums1 and nums2 where nums1’s elements are subset of nums2. Find all
 * the next greater numbers for nums1's elements in the corresponding places of nums2.
 *
 * The Next Greater Number of a number x in nums1 is the first greater number to its right in nums2. If it does not
 * exist, output -1 for this number.
 *
 * Example 1:
 * Input: nums1 = [4,1,2], nums2 = [1,3,4,2].
 * Output: [-1,3,-1]
 * Explanation:
 *    For number 4 in the first array, you cannot find the next greater number for it in the second array, so output -1.
 *    For number 1 in the first array, the next greater number for it in the second array is 3.
 *    For number 2 in the first array, there is no next greater number for it in the second array, so output -1.
 * Example 2:
 * Input: nums1 = [2,4], nums2 = [1,2,3,4].
 * Output: [3,-1]
 * Explanation:
 *    For number 2 in the first array, the next greater number for it in the second array is 3.
 *    For number 4 in the first array, there is no next greater number for it in the second array, so output -1.
 * Note:
 * All elements in nums1 and nums2 are unique.
 * The length of both nums1 and nums2 would not exceed 1000.
 */

public class NextGreaterElementI {
  public int[] nextGreaterElement(int[] nums1, int[] nums2) {
    // Use monotonic stack
    int[] ans = new int[nums1.length];
    Deque<Integer> stack = new ArrayDeque<>();
    Map<Integer, Integer> map = new HashMap<>();
    /*
      for every number in the array,
        push that element on the stack if the stack is empty OR the number is less than stack top
        Basically, we want a descending stack
        If at any point, num > stack.top, then we have found the next greater element for stack top
        So, we pop it and store it in map { stack.top -> num } and then push curr element on stack
    */
    for (int value : nums2) {
      while (!stack.isEmpty() && value > stack.peek()) {
        map.put(stack.pop(), value);
      }
      stack.push(value);
    }
    // There will be elements remaining in the stack, it means we could not find a num greater than
    // these nums in arr.
    while (!stack.isEmpty()) {
      map.put(stack.pop(), -1);
    }
    for (int i = 0; i < nums1.length; i++) {
      ans[i] = map.get(nums1[i]);
    }
    return ans;
  }
}
