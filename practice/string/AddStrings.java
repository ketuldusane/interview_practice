package string;

/**
 * Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.
 *
 * Note:
 *
 * The length of both num1 and num2 is < 5100.
 * Both num1 and num2 contains only digits 0-9.
 * Both num1 and num2 does not contain any leading zero.
 * You must not use any built-in BigInteger library or convert the inputs to integer directly.
 */

public class AddStrings {
  public String addStrings(String num1, String num2) {
    StringBuilder num = new StringBuilder();
    int i = num1.length() - 1;
    int j = num2.length() - 1;
    int carry = 0;
    while (i >= 0 && j >= 0) {
      int a = num1.charAt(i) - '0';
      int b = num2.charAt(j) - '0';
      int ans = a + b + carry;
      carry = ans / 10;
      ans = ans % 10;
      num.append(ans);
      i--;
      j--;
    }
    while (i >= 0) {
      int a = num1.charAt(i) - '0';
      a = a + carry;
      carry = a / 10;
      a = a % 10;
      num.append(a);
      i--;
    }
    while (j >= 0) {
      int b = num2.charAt(j) - '0';
      b = b + carry;
      carry = b / 10;
      b = b % 10;
      num.append(b);
      j--;
    }
    if (carry != 0) {
      num.append(carry);
    }
    return num.reverse().toString();
  }
}
