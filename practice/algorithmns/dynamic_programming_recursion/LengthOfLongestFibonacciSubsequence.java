package algorithmns.dynamic_programming_recursion;

import java.util.HashMap;
import java.util.Map;

/**
 * Length of Longest Fibonacci Subsequence
 * <p>
 * A sequence X_1, X_2, ..., X_n is fibonacci-like if:
 * <p>
 * n >= 3
 * X_i + X_{i+1} = X_{i+2} for all i + 2 <= n
 * Given a strictly increasing array A of positive integers forming a sequence, find the length of the longest
 * fibonacci-like subsequence of A.  If one does not exist, return 0.
 * <p>
 * (Recall that a subsequence is derived from another sequence A by deleting any number of elements (including none)
 * from A, without changing the order of the remaining elements.  For example, [3, 5, 8] is a subsequence of
 * [3, 4, 5, 6, 7, 8].)
 * <p>
 * Example 1:
 * Input: [1,2,3,4,5,6,7,8]
 * Output: 5
 * Explanation:
 * The longest subsequence that is fibonacci-like: [1,2,3,5,8].
 * <p>
 * Example 2:
 * Input: [1,3,7,11,12,14,18]
 * Output: 3
 * Explanation:
 * The longest subsequence that is fibonacci-like:
 * [1,11,12], [3,11,14] or [7,11,18].
 * <p>
 * Note:
 * 3 <= A.length <= 1000
 * 1 <= A[0] < A[1] < ... < A[A.length - 1] <= 10^9
 */

public class LengthOfLongestFibonacciSubsequence {
  public int lenLongestFibSubseq(int[] A) {
    int n = A.length;
    Map<Integer, Integer> index = new HashMap<>();
    for (int i = 0; i < A.length; i++) {
      index.put(A[i], i);
    }

    int ans = 0;
    int[][] dp = new int[n][n];

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < i; j++) {
        int k = index.getOrDefault(A[i] - A[j], -1);
        if (k >= 0 && k < j) {
          // ... k .. j .. i ...
          int temp = Math.max(dp[k][j], 2) + 1;
          dp[j][i] = temp;
          ans = Math.max(temp, ans);
        }
      }
    }

    return ans >= 3 ? ans : 0;
  }
}
