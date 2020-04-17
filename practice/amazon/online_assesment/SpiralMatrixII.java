package amazon.online_assesment;

/**
 * Spiral Matrix II
 * <p>
 * Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
 * <p>
 * Example:
 * <p>
 * Input: 3
 * Output:
 * [
 * [ 1, 2, 3 ],
 * [ 8, 9, 4 ],
 * [ 7, 6, 5 ]
 * ]
 */

public class SpiralMatrixII {
  public int[][] generateMatrix(int n) {
    if (n <= 0) {
      return new int[0][0];
    }

    int top = 0;
    int bottom = n - 1;
    int left = 0;
    int right = n - 1;

    int[][] ans = new int[n][n];

    int x = 1;
    while (x <= n * n) {
      for (int i = left; i <= right; i++) {
        ans[top][i] = x;
        x++;
      }
      top++;

      for (int i = top; i <= bottom; i++) {
        ans[i][right] = x;
        x++;
      }
      right--;

      for (int i = right; i >= left; i--) {
        ans[bottom][i] = x;
        x++;
      }
      bottom--;

      for (int i = bottom; i >= top; i--) {
        ans[i][left] = x;
        x++;
      }
      left++;
    }

    return ans;
  }
}
