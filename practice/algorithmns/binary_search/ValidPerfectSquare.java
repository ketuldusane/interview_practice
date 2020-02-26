package algorithmns.binary_search;

/**
 * Valid Perfect Square
 *
 * Given a positive integer num, write a function which returns True if num is a perfect square else False.
 *
 * Note: Do not use any built-in library function such as sqrt.
 *
 * Example 1:
 *
 * Input: 16
 * Output: true
 * Example 2:
 *
 * Input: 14
 * Output: false
 */

public class ValidPerfectSquare {
  public boolean isPerfectSquare(int num) {
    if (num <= 0) return false;
    if (num == 1) return true;

    long low = 2, high = num / 2;
    while (low <= high) {
      long mid = (low + high) / 2;
      if (mid * mid == (long) num) {
        return true;
      } else if (mid * mid < num) {
        low = mid + 1;
      } else {
        high = mid - 1;
      }
    }
    return false;
  }
}
