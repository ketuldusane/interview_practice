package math;

/**
 * Closest Divisors
 *
 * Given an integer num, find the closest two integers in absolute difference whose product equals num + 1 or num + 2.
 *
 * Return the two integers in any order.
 *
 *
 *
 * Example 1:
 *
 * Input: num = 8
 * Output: [3,3]
 * Explanation: For num + 1 = 9, the closest divisors are 3 & 3, for num + 2 = 10, the closest divisors are 2 & 5, hence 3 & 3 is chosen.
 * Example 2:
 *
 * Input: num = 123
 * Output: [5,25]
 * Example 3:
 *
 * Input: num = 999
 * Output: [40,25]
 *
 *
 * Constraints:
 *
 * 1 <= num <= 10^9
 */

public class ClosestDivisors {
  public int[] closestDivisors(int num) {
    for (int i = (int) Math.sqrt(num + 2); i > 0; i--) {
      if ((num + 1) % i == 0) {
        return new int[]{i, (num + 1) / i};
      }
      if ((num + 2) % i == 0) {
        return new int[]{i, (num + 2) / i};
      }
    }
    return new int[]{};
  }
}
