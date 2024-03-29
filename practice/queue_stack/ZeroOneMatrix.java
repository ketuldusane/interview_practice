package queue_stack;

import java.util.Arrays;

public class ZeroOneMatrix {
  public int[][] updateMatrix(int[][] matrix) {
    int[][] m = new int[matrix.length][matrix[0].length];
    for (int[] am : m) {
      Arrays.fill(am, Integer.MAX_VALUE - 100000);
    }

    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        if (matrix[i][j] == 0) {
          m[i][j] = 0;
        } else {
          if (i > 0)
            m[i][j] = Math.min(m[i][j], m[i - 1][j] + 1);
          if (j > 0)
            m[i][j] = Math.min(m[i][j], m[i][j - 1] + 1);
        }
      }
    }

    for (int i = matrix.length - 1; i >= 0; i--) {
      for (int j = matrix[0].length - 1; j >= 0; j--) {
        if (i < matrix.length - 1)
          m[i][j] = Math.min(m[i][j], m[i + 1][j] + 1);
        if (j < matrix[0].length - 1)
          m[i][j] = Math.min(m[i][j], m[i][j + 1] + 1);
      }
    }

    return m;
  }
}
