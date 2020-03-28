package arrays;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Two City Scheduling
 * <p>
 * There are 2N people a company is planning to interview. The cost of flying the i-th person to city A is costs[i][0],
 * and the cost of flying the i-th person to city B is costs[i][1].
 * <p>
 * Return the minimum cost to fly every person to a city such that exactly N people arrive in each city.
 * <p>
 * Example 1:
 * Input: [[10,20],[30,200],[400,50],[30,20]]
 * Output: 110
 * Explanation:
 * The first person goes to city A for a cost of 10.
 * The second person goes to city A for a cost of 30.
 * The third person goes to city B for a cost of 50.
 * The fourth person goes to city B for a cost of 20.
 * <p>
 * The total minimum cost is 10 + 30 + 50 + 20 = 110 to have half the people interviewing in each city.
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= costs.length <= 100
 * It is guaranteed that costs.length is even.
 * 1 <= costs[i][0], costs[i][1] <= 1000
 */

public class TwoCityScheduling {
  public int twoCitySchedCost(int[][] costs) {
    Arrays.sort(costs, new Comparator<int[]>() {
      @Override
      public int compare(int[] o1, int[] o2) {
        return o1[0] - o1[1] - (o2[0] - o2[1]);
      }
    });

    int total = 0;
    int n = costs.length / 2;
    for (int i = 0; i < n; i++) {
      total += costs[i][0] + costs[i + n][1];
    }

    return total;
  }
}
