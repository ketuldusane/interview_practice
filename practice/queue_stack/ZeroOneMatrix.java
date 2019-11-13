package queue_stack;

import java.util.Arrays;

public class ZeroOneMatrix {
  class Solution {
    public int[][] updateMatrix(int[][] matrix) {
      int[][] m = new int[matrix.length][matrix[0].length];
      for (int[] t : m) {
        Arrays.fill(t, Integer.MAX_VALUE - 100000);
      }

      for (int i = 0; i < m.length; i++) {
        for (int j = 0; j < m[0].length; j++) {
          if (matrix[i][j] == 0)
            m[i][j] = 0;
          else {
            if (i > 0)
              m[i][j] = Math.min(m[i][j], m[i - 1][j] + 1);
            if (j > 0)
              m[i][j] = Math.min(m[i][j], m[i][j - 1] + 1);
          }
        }
      }

      for (int i = m.length - 1; i >= 0; i--) {
        for (int j = m[0].length - 1; j > 0; j--) {
          if (i < m.length - 1)
            m[i][j] = Math.min(m[i][j], m[i + 1][j] + 1);
          if (j < m[0].length - 1)
            m[i][j] = Math.min(m[i][j], m[i][j + 1] + 1);
        }
      }

      return m;
    }
  }
}
