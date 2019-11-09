package algoritmns.dynamic_programming_recursion;

/**
 * Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...)
 * which sum to n.
 * <p>
 * Example 1:
 * <p>
 * Input: n = 12
 * Output: 3
 * Explanation: 12 = 4 + 4 + 4.
 * Example 2:
 * <p>
 * Input: n = 13
 * Output: 2
 * Explanation: 13 = 4 + 9.
 */

public class PerfectSquares {
  public static void main(String[] args) {
    System.out.println(new PerfectSquares().numSquares(17));
  }

  public int numSquares(int n) {
    int[] num = new int[n + 1];
    num[0] = 0;
    num[1] = 1;

    for (int i = 2; i <= n; i++) {
      num[i] = num[i - 1] + 1;
      for (int k = 2; i - k * k >= 0; k++) {
        int nextNum = num[i - k * k] + 1;
        if (nextNum < num[i]) {
          num[i] = nextNum;
        }
      }
    }

    return num[n];
  }
}
