package amazon.online_assesment;

import java.util.Arrays;

/**
 * K Closest Points To Origin
 * <p>
 * We have a list of points on the plane.  Find the K closest points to the origin (0, 0).
 * <p>
 * (Here, the distance between two points on a plane is the Euclidean distance.)
 * <p>
 * You may return the answer in any order.  The answer is guaranteed to be unique (except for the order that it is in.)
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: points = [[1,3],[-2,2]], K = 1
 * Output: [[-2,2]]
 * Explanation:
 * The distance between (1, 3) and the origin is sqrt(10).
 * The distance between (-2, 2) and the origin is sqrt(8).
 * Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
 * We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].
 * Example 2:
 * <p>
 * Input: points = [[3,3],[5,-1],[-2,4]], K = 2
 * Output: [[3,3],[-2,4]]
 * (The answer [[-2,4],[3,3]] would also be accepted.)
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= K <= points.length <= 10000
 * -10000 < points[i][0] < 10000
 * -10000 < points[i][1] < 10000
 */

public class KClosestPointsToOrigin {
  // Implement Quick Select
  public int[][] kClosest(int[][] points, int k) {
    if (points == null || points.length == 0) {
      return new int[0][0];
    }
    if (k == points.length) {
      return points;
    }
    kthSmallest(points, 0, points.length - 1, k);
    int[][] ans = Arrays.copyOfRange(points, 0, k);
    return ans;
  }

  private int kthSmallest(int[][] points, int low, int high, int k) {
    int p = partition(points, low, high);
    if (p < k) {
      return kthSmallest(points, p + 1, high, k);
    } else if (p > k) {
      return kthSmallest(points, low, p - 1, k);
    } else {
      return p;
    }
  }

  private int partition(int[][] points, int low, int high) {
    int[] pivot = points[high];
    int p = low;
    for (int i = low; i <= high; i++) {
      if (distance(points[i]) < distance(pivot)) {
        // Swap the arrays
        int[] temp = points[i];
        points[i] = points[p];
        points[p] = temp;
        p++;
      }
    }
    int[] temp = points[high];
    points[high] = points[p];
    points[p] = temp;
    return p;
  }

  private double distance(int[] point) {
    return Math.sqrt(Math.pow(point[0], 2) + Math.pow(point[1], 2));
  }
}
