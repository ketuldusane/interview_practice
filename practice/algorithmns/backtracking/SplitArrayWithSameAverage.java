package algorithmns.backtracking;

/**
 * Split Array With Same Average
 *
 * In a given integer array A, we must move every element of A to list B or list C. (B and C initially start empty.)
 * Return true if and only if after such a move, it is possible that the average value of B is equal to the average
 * value of C, and B and C are both non-empty.
 *
 * Example :
 * Input:
 * [1,2,3,4,5,6,7,8]
 * Output: true
 * Explanation: We can split the array into [1,4,5,8] and [2,3,6,7], and both of them have the average of 4.5.
 * Note:
 * The length of A will be in the range [1, 30].
 * A[i] will be in the range of [0, 10000].
 */

public class SplitArrayWithSameAverage {
  public boolean splitArraySameAverage(int[] A) {
    if (A == null || A.length == 0) {
      return false;
    }
    int n = A.length;
    int sum = 0;
    for (int num : A) {
      sum += num;
    }
    /*
      Intuition:
        sum / n = listAsum / k = listBsum / (n - k)
          where k = length of listA
      Then,
        listAsum = sum * k / n
      Hence,
        sum * k % n = 0
      So, find all such k and check
    */
    for (int i = 1; i <= n / 2; i++) {
      if (sum * i % n == 0) {
        if (find(A, sum * i / n, i, 0)) {
          return true;
        }
      }
    }
    return false;
  }

  private boolean find(int[] A, int target, int k, int i) {
    if (k == 0) {
      return target == 0;
    }
    for (int j = i; j < A.length; j++) {
      if (j != i && A[j] == A[j - 1]) {
        continue; // Avoid duplicates
      }
      if (find(A, target - A[j], k - 1, j + 1)) {
        return true;
      }
    }
    return false;
  }
}
