package arrays;

import java.util.*;

/**
 * Given a collection of intervals, merge all overlapping intervals.
 * <p>
 * Example 1:
 * <p>
 * Input: [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 * Example 2:
 * <p>
 * Input: [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 * NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.
 */

public class MergeIntervals {
  public static void main(String[] args) {
    MergeIntervals m = new MergeIntervals();
    m.merge(new int[][]{{4, 5}, {1, 4}, {0, 1}});
  }

  public int[][] merge(int[][] intervals) {
    PriorityQueue<Interval> q = new PriorityQueue<>(new IntervalComparator());
    for (int i = 0; i < intervals.length; i++) {
      Interval temp = new Interval(intervals[i][0], intervals[i][1]);
      q.add(temp);
    }

    LinkedList<Interval> merged = new LinkedList<>();
    for (Interval interval : q) {
      if (merged.isEmpty() || merged.getLast().end < interval.start) {
        merged.add(interval);
      } else {
        merged.getLast().end = Math.max(merged.getLast().end, interval.end);
      }
    }

    int[][] ans = new int[merged.size()][2];
    int i = 0;
    for (Interval in : merged) {
      ans[i][0] = in.start;
      ans[i][1] = in.end;
    }
    return ans;
  }

  private class Interval {
    int start;
    int end;

    Interval(int s, int e) {
      start = s;
      end = e;
    }
  }

  private class IntervalComparator implements Comparator<Interval> {
    @Override
    public int compare(Interval a, Interval b) {
      return a.start < b.start ? -1 : a.start == b.start ? 0 : 1;
    }
  }
}
