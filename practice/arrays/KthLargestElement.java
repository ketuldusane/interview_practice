package arrays;

import java.util.PriorityQueue;

/**
 * Kth Largest Element in an Array
 *
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, not the kth distinct element.

 Example 1:

 Input: [3,2,1,5,6,4] and k = 2
 Output: 5
 Example 2:

 Input: [3,2,3,1,2,4,5,5,6] and k = 4
 Output: 4
 Note:
 You may assume k is always valid, 1 ≤ k ≤ array's length.
 */

public class KthLargestElement {
  public int findKthLargest(int[] nums, int k) {
    return heap(nums, k);
  }

  private int quickselect(int[] nums, int k) {
    int start = 0;
    int end = nums.length - 1;
    k = nums.length - k;
    while (start < end) {
      int p = partition(nums, start, end);
      if (k == p) {
        return nums[p];
      } else if (p < k) {
        start = p + 1;
      } else {
        end = p - 1;
      }
    }
    return nums[start];
  }

  private int partition(int[] nums, int low, int high) {
    int pivot = nums[high];
    int i = low - 1;
    for (int j = low; j < high; j++) {
      if (nums[j] < pivot) {
        i++;
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
      }
    }
    int temp = nums[i + 1];
    nums[i + 1] = nums[high];
    nums[high] = temp;
    return i + 1;
  }

  private int heap(int[] nums, int k) {
    PriorityQueue<Integer> pq = new PriorityQueue<>((n1, n2) -> n1 - n2);
    for (int n : nums) {
      pq.add(n);
      if (pq.size() > k) {
        pq.poll();
      }
    }

    return pq.poll();
  }
}
