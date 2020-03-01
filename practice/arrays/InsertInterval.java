package arrays;

import java.util.ArrayList;
import java.util.List;

/**
 * Insert Interval
 * <p>
 * Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).
 * You may assume that the intervals were initially sorted according to their start times.
 * <p>
 * Example 1:
 * Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * Output: [[1,5],[6,9]]
 * <p>
 * Example 2:
 * Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * Output: [[1,2],[3,10],[12,16]]
 * Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
 */

public class InsertInterval {
  public int[][] insert(int[][] intervals, int[] newInterval) {
    List<int[]> ans = new ArrayList<>();
    if (intervals == null || intervals.length == 0) {
      ans.add(newInterval);
      return ans.toArray(new int[ans.size()][]);
    }
    int[] compare = newInterval;

    for (int[] i : intervals) {
      // Check if there is an overlap
      if ((compare[0] >= i[0] && compare[0] <= i[1]) || (i[0] >= compare[0] && i[0] <= compare[1])) {
        // find the new interval
        int s = Math.min(compare[0], i[0]);
        int e = Math.max(compare[1], i[1]);
        compare = new int[]{s, e};
      } else {
        if (compare[1] < i[0]) {
          ans.add(compare);
          compare = i;
        } else {
          ans.add(i);
        }
      }
    }
    ans.add(compare);

    return ans.toArray(new int[ans.size()][]);
  }
}
