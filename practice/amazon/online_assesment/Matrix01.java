package amazon.online_assesment;

/**
 * 01 Matrix
 * <p>
 * Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell.
 * <p>
 * The distance between two adjacent cells is 1.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input:
 * [[0,0,0],
 * [0,1,0],
 * [0,0,0]]
 * <p>
 * Output:
 * [[0,0,0],
 * [0,1,0],
 * [0,0,0]]
 * Example 2:
 * <p>
 * Input:
 * [[0,0,0],
 * [0,1,0],
 * [1,1,1]]
 * <p>
 * Output:
 * [[0,0,0],
 * [0,1,0],
 * [1,2,1]]
 * <p>
 * <p>
 * Note:
 * <p>
 * The number of elements of the given matrix will not exceed 10,000.
 * There are at least one 0 in the given matrix.
 * The cells are adjacent in only four directions: up, down, left and right.
 */

public class Matrix01 {
  public int[][] updateMatrix(int[][] matrix) {
    if (matrix == null || matrix.length == 0) {
      return new int[0][0];
    }

    for (int i = 0; i < matrix.length; i++) {
      for (int j = 0; j < matrix[0].length; j++) {
        if (matrix[i][j] == 0) {
          matrix[i][j] = 0;
        } else {
          matrix[i][j] = matrix.length + matrix[0].length + 1;
          if (i > 0) {
            matrix[i][j] = Math.min(matrix[i][j], matrix[i - 1][j] + 1);
          }

          if (j > 0) {
            matrix[i][j] = Math.min(matrix[i][j], matrix[i][j - 1] + 1);
          }
        }
      }
    }

    for (int i = matrix.length - 1; i >= 0; i--) {
      for (int j = matrix[0].length - 1; j >= 0; j--) {
        if (i < matrix.length - 1) {
          matrix[i][j] = Math.min(matrix[i][j], matrix[i + 1][j] + 1);
        }

        if (j < matrix[0].length - 1) {
          matrix[i][j] = Math.min(matrix[i][j], matrix[i][j + 1] + 1);
        }
      }
    }

    return matrix;
  }
}
