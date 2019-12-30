package arrays;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Diagonal Traverse
 * <p>
 * Given a matrix of M x N elements (M rows, N columns), return all elements of the matrix in diagonal order as shown in the below image.
 * <p>
 * Example:
 * <p>
 * Input:
 * [
 * [ 1, 2, 3 ],
 * [ 4, 5, 6 ],
 * [ 7, 8, 9 ]
 * ]
 * <p>
 * Output:  [1,2,4,7,5,3,6,8,9]
 * <p>
 * Note:
 * The total number of elements of the given matrix will not exceed 10,000.
 */

public class DiagonalTraverse {
  public int[] findDiagonalOrder(int[][] matrix) {
    if (matrix == null || matrix.length == 0) {
      return new int[0];
    }

    int M = matrix.length;
    int N = matrix[0].length;
    int pos = 0;

    int[] result = new int[M * N];
    ArrayList<Integer> diagonal = new ArrayList<>();

    for (int d = 0; d < M + N - 1; d++) {
      diagonal.clear();
      int row = d < N ? 0 : d - N + 1;
      int column = d < N ? d : N - 1;

      while (row < M && column >= 0) {
        diagonal.add(matrix[row][column]);
        row++;
        column--;
      }

      if (d % 2 == 0) {
        Collections.reverse(diagonal);
      }

      for (int i : diagonal) {
        result[pos] = i;
        pos++;
      }
    }

    return result;
  }
}
