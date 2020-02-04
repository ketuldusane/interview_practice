package math;

/**
 * Divide Two Integers
 * <p>
 * Given two integers dividend and divisor, divide two integers without using multiplication, division and mod operator.
 * <p>
 * Return the quotient after dividing dividend by divisor.
 * <p>
 * The integer division should truncate toward zero.
 * <p>
 * Example 1:
 * <p>
 * Input: dividend = 10, divisor = 3
 * Output: 3
 * Example 2:
 * <p>
 * Input: dividend = 7, divisor = -3
 * Output: -2
 * Note:
 * <p>
 * Both dividend and divisor will be 32-bit signed integers.
 * The divisor will never be 0.
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer
 * range: [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 231 − 1 when the division
 * result overflows.
 */

public class DivideTwoIntegers {
  public static void main(String[] args) {
    DivideTwoIntegers d = new DivideTwoIntegers();
    int ans = d.divide(Integer.MAX_VALUE, 1000);
    System.out.println(ans);
  }

  public int divide(int dividend, int divisor) {
    if (dividend == 0) {
      return 0;
    }

    int sign = 1;
    if (dividend < 0) {
      sign *= -1;
    }
    if (divisor < 0) {
      sign *= -1;
    }

    dividend = Math.abs(dividend);
    divisor = Math.abs(divisor);
    int div = Math.abs(divisor);

    int quotient = 0;
    while (div <= dividend) {
      if ((Integer.MAX_VALUE - div) < divisor) {
        quotient = Integer.MAX_VALUE;
        break;
      }
      div += divisor;
      quotient++;
    }

    if (quotient == Integer.MAX_VALUE) {
      return quotient;
    }
    return quotient * sign;
  }
}
