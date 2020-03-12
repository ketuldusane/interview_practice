package arrays;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * Kth Smallest Element in a Sorted Matrix
 * <p>
 * Given a n x n matrix where each of the rows and columns are sorted in ascending order, find the kth smallest element
 * in the matrix.
 * <p>
 * Note that it is the kth smallest element in the sorted order, not the kth distinct element.
 * <p>
 * Example:
 * <p>
 * matrix = [
 * [ 1,  5,  9],
 * [10, 11, 13],
 * [12, 13, 15]
 * ],
 * k = 8,
 * <p>
 * return 13.
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ n2.
 */

public class KthSmallestElementInSortedMatrix {
  public int kthSmallest(int[][] matrix, int k) {
    PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
    for (int[] ints : matrix) {
      for (int j = 0; j < matrix[0].length; j++) {
        q.add(ints[j]);
        if (q.size() > k) {
          q.poll();
        }
      }
    }
    return q.poll();
  }
}
