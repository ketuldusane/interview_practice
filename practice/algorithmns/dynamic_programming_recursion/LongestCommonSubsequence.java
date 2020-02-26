package algorithmns.dynamic_programming_recursion;

public class LongestCommonSubsequence {
  public int longestCommonSubsequence(String s1, String s2) {
    int n = s1.length();
    int m = s2.length();

    if (n * m == 0) {
      return 0;
    }

    /*
      Longest Common Sub-sequence
      Algorithm: Dynamic Programming

        if A[i] == B[j]
          d(i, j) = 1 + d(i - 1, j - 1)
        else
          d(i, j) = Math.max(d(i - 1, j), d[(i, j - 1))

      TC: O(mn)
     */

    int[][] d = new int[n + 1][m + 1];

    for (int i = 0; i < n + 1; i++) {
      d[i][0] = 0;
    }

    for (int j = 0; j < m + 1; j++) {
      d[0][j] = 0;
    }

    for (int i = 1; i < n + 1; i++) {
      for (int j = 1; j < m + 1; j++) {
        if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
          d[i][j] = 1 + d[i - 1][j - 1];
        } else {
          d[i][j] = Math.max(d[i - 1][j], d[i][j - 1]);
        }
      }
    }

    return d[n][m];
  }

  public static void main(String[] args) {
    String s1 = "abcdefghi";
    String s2 = "bacfgi";
    System.out.println(new LongestCommonSubsequence().longestCommonSubsequence(s1, s2));
  }
}
