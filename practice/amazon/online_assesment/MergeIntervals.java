package amazon.online_assesment;

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
 */

public class MergeIntervals {
  public int[][] merge(int[][] intervals) {
    List<Interval> q = new ArrayList<>();
    for (int i = 0; i < intervals.length; i++) {
      Interval temp = new Interval(intervals[i][0], intervals[i][1]);
      q.add(temp);
    }

    Collections.sort(q, new IntervalComparator());

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
      i++;
    }
    return ans;
  }

  private static class Interval {
    int start;
    int end;

    Interval(int s, int e) {
      start = s;
      end = e;
    }
  }

  private static class IntervalComparator implements Comparator<Interval> {
    @Override
    public int compare(Interval a, Interval b) {
      return Integer.compare(a.start, b.start);
    }
  }
}
