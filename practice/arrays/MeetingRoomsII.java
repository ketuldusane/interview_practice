package arrays;

import java.util.HashMap;

/**
 * Meetings Rooms II
 * <p>
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.
 * <p>
 * Example 1:
 * <p>
 * Input: [[0, 30],[5, 10],[15, 20]]
 * Output: 2
 * Example 2:
 * <p>
 * Input: [[7,10],[2,4]]
 * Output: 1
 * NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.
 */
public class MeetingRoomsII {
  public int minMeetingRooms(int[][] intervals) {
    if (intervals == null || intervals.length == 0 || intervals[0].length == 0) {
      return 0;
    }

    HashMap<Integer, Integer> startTimes = new HashMap<>();
    HashMap<Integer, Integer> stopTimes = new HashMap<>();

    int earliestStart = Integer.MAX_VALUE;
    int latestStop = Integer.MIN_VALUE;
    int maxConcurrentMeetings = 0;
    int activeMeetings = 0;

    for (int[] interval : intervals) {
      int start = interval[0];
      int stop = interval[1];

      startTimes.put(start, startTimes.getOrDefault(start, 0) + 1);
      stopTimes.put(stop, stopTimes.getOrDefault(stop, 0) + 1);

      earliestStart = Math.min(earliestStart, start);
      latestStop = Math.max(latestStop, stop);
    }

    for (int i = earliestStart; i <= latestStop; i++) {
      if (stopTimes.containsKey(i)) {
        activeMeetings -= stopTimes.get(i);
        if (activeMeetings < 0) {
          activeMeetings = 0;
        }
        maxConcurrentMeetings = Math.max(activeMeetings, maxConcurrentMeetings);
      }
      if (startTimes.containsKey(i)) {
        activeMeetings += startTimes.get(i);
        maxConcurrentMeetings = Math.max(activeMeetings, maxConcurrentMeetings);
      }
    }

    return maxConcurrentMeetings;
  }
}
