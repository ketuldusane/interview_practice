package queue_stack;

/**
 Largest Rectangle in Histogram

 Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.

 Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].

 The largest rectangle is shown in the shaded area, which has area = 10 unit.
 */

public class LargestRectangleHistogram {
  public int largestRectangleArea(int[] heights) {
    if (heights == null || heights.length == 0) {
      return 0;
    }

    return calculate(heights, 0, heights.length - 1);
  }

  private int calculate(int[] heights, int start, int end) {
    if (start > end) {
      return 0;
    }

    int minIndex = start;

    for (int i = start; i <= end; i++) {
      if (heights[i] < heights[minIndex]) {
        minIndex = i;
      }
    }

    return Math.max(heights[minIndex] * (end - start + 1),
        Math.max(calculate(heights, start, minIndex - 1), calculate(heights, minIndex + 1, end)));
  }
}
