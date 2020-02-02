package algoritmns.sliding_window;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Sliding Window Maximum
 *
 * Given an array nums, there is a sliding window of size k which is moving from the very left of the array to the very right. You can only see the k numbers in the window. Each time the sliding window moves right by one position. Return the max sliding window.

 Example:

 Input: nums = [1,3,-1,-3,5,3,6,7], and k = 3
 Output: [3,3,5,5,6,7]
 Explanation:

 Window position                Max
 ---------------               -----
 [1  3  -1] -3  5  3  6  7       3
 1 [3  -1  -3] 5  3  6  7       3
 1  3 [-1  -3  5] 3  6  7       5
 1  3  -1 [-3  5  3] 6  7       5
 1  3  -1  -3 [5  3  6] 7       6
 1  3  -1  -3  5 [3  6  7]      7
 Note:
 You may assume k is always valid, 1 ≤ k ≤ input array's size for non-empty array.

 Follow up:
 Could you solve it in linear time?
 */

public class SlidingWindowMaximum {
  public int[] maxSlidingWindow(int[] nums, int k) {
    if (nums == null || nums.length == 0) {
      return new int[0];
    }

    int left = 0;
    int right = k - 1;
    int[] ans = new int[nums.length - k + 1];

    // Maintain a map to look at the current window - a map is needed instead of a set because window can contain duplicate elements
    // PQ keeps the elements in the window sorted in reverse order
    // We will pop out all the elements in the queue that are not present in the set window as we move our window forward
    PriorityQueue<Integer> queue = new PriorityQueue<>(new CompareNums());
    Map<Integer, Integer> window = new HashMap<>();

    for (int i = 0; i < k ; i++) {
      window.put(nums[i], window.getOrDefault(nums[i], 0) + 1);
      queue.offer(nums[i]);
    }

    while (right < nums.length) {
      ans[left] = queue.peek();
      window.put(nums[left], window.get(nums[left]) - 1);
      if (window.get(nums[left]) == 0) {
        window.remove(nums[left]);
      }

      left++;
      right++;

      if (right >= nums.length) {
        break;
      }
      queue.offer(nums[right]);
      window.put(nums[right], window.getOrDefault(nums[right], 0) + 1);
      while (!window.containsKey(queue.peek())) {
        queue.poll();
      }
    }

    return ans;
  }

  class CompareNums implements Comparator<Integer> {
    public int compare(Integer a, Integer b) {
      if (a > b) {
        return -1;
      } else {
        return 1;
      }
    }
  }
}
