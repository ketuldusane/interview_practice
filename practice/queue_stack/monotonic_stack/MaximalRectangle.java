package queue_stack.monotonic_stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Maximal Rectangle
 *
 * Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing only 1's and return its area.
 *
 * Example:
 * Input:
 * [
 *   ["1","0","1","0","0"],
 *   ["1","0","1","1","1"],
 *   ["1","1","1","1","1"],
 *   ["1","0","0","1","0"]
 * ]
 * Output: 6
 */

public class MaximalRectangle {
  // This question is an extension of largest rectangle in Histogram
  // The idea is:
  //  Somehow convert the 2D array of 0s and 1s to a 1D array of heights
  //  How? Traverse row by row. Each row is a height array
  //       Calculate the maximum area in the current height array using monotonic stack
  //       Now go to next row and update the height array and repeat the process

  // TC: O(nm)
  // SC: O(m)

  public int maximalRectangle(char[][] matrix) {
    if (matrix == null || matrix.length == 0) {
      return 0;
    }
    int area = 0;
    int[] heights = new int[matrix[0].length];
    for (int i = 0; i < matrix.length; i++) {
      // Generate and update the height array
      for (int j = 0; j < matrix[0].length; j++) {
        if (matrix[i][j] == '1') {
          heights[j] += 1;
        } else {
          heights[j] = 0;
        }
      }
      // Use monotonic stack to calculate area
      Deque<Integer> stack = new ArrayDeque<>();
      stack.push(-1);
      for (int j = 0; j < heights.length; j++) {
        while (stack.peek() != -1 && heights[j] <= heights[stack.peek()]) {
          area = Math.max(area, heights[stack.pop()] * (j - stack.peek() - 1));
        }
        stack.push(j);
      }
      while (stack.peek() != -1) {
        area = Math.max(area, heights[stack.pop()] * (heights.length - stack.peek() - 1));
      }
    }
    return area;
  }
}
