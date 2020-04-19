package amazon.online_assesment;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Prison Cell After N Days
 * <p>
 * There are 8 prison cells in a row, and each cell is either occupied or vacant.
 * <p>
 * Each day, whether the cell is occupied or vacant changes according to the following rules:
 * <p>
 * If a cell has two adjacent neighbors that are both occupied or both vacant, then the cell becomes occupied.
 * Otherwise, it becomes vacant.
 * (Note that because the prison is a row, the first and the last cells in the row can't have two adjacent neighbors.)
 * <p>
 * We describe the current state of the prison in the following way: cells[i] == 1 if the i-th cell is occupied, else cells[i] == 0.
 * <p>
 * Given the initial state of the prison, return the state of the prison after N days (and N such changes described above.)
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: cells = [0,1,0,1,1,0,0,1], N = 7
 * Output: [0,0,1,1,0,0,0,0]
 * Explanation:
 * The following table summarizes the state of the prison on each day:
 * Day 0: [0, 1, 0, 1, 1, 0, 0, 1]
 * Day 1: [0, 1, 1, 0, 0, 0, 0, 0]
 * Day 2: [0, 0, 0, 0, 1, 1, 1, 0]
 * Day 3: [0, 1, 1, 0, 0, 1, 0, 0]
 * Day 4: [0, 0, 0, 0, 0, 1, 0, 0]
 * Day 5: [0, 1, 1, 1, 0, 1, 0, 0]
 * Day 6: [0, 0, 1, 0, 1, 1, 0, 0]
 * Day 7: [0, 0, 1, 1, 0, 0, 0, 0]
 * <p>
 * Example 2:
 * <p>
 * Input: cells = [1,0,0,1,0,0,1,0], N = 1000000000
 * Output: [0,0,1,1,1,1,1,0]
 * <p>
 * <p>
 * Note:
 * <p>
 * cells.length == 8
 * cells[i] is in {0, 1}
 * 1 <= N <= 10^9
 */

public class PrisonCellAfterNDays {
  public int[] prisonAfterNDays(int[] cells, int N) {
    Map<String, Integer> map = new HashMap<>();
    String s = Arrays.toString(cells);

    for (int i = 0; i < N; i++) {
      map.put(s, i); // keep track of the state and day
      cells = getNextDay(cells); // advance the state
      s = Arrays.toString(cells); // serialize it

      // if we've seen this state before, fast-forward
      if (map.containsKey(s)) {
        int numOfDaysAgo = i + 1 - map.get(s); // how many days ago was it when we saw this state?
        int numberOfDaysLeft = N - (i + 1); // how many days do we have left (if we don't fast-forward)?
        return lastNDays(cells, numberOfDaysLeft % numOfDaysAgo);
      }
    }

    // if we never get a cycle, the for-loop will exit on its own after N days.
    return cells;
  }

  // do N days of advancement
  private int[] lastNDays(int[] cells, int N) {
    for (int i = 0; i < N; i++) {
      cells = getNextDay(cells);
    }

    return cells;
  }

  // advance the state by one day
  private int[] getNextDay(int[] cells) {
    int[] newCells = new int[8];

    for (int i = 1; i < cells.length - 1; i++) {
      if (cells[i - 1] == cells[i + 1])
        newCells[i] = 1;
      else
        newCells[i] = 0;
    }

    return newCells;
  }
}
