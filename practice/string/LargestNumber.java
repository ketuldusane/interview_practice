package string;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Largest Number
 * <p>
 * Given a list of non negative integers, arrange them such that they form the largest number.
 * <p>
 * Example 1:
 * <p>
 * Input: [10,2]
 * Output: "210"
 * Example 2:
 * <p>
 * Input: [3,30,34,5,9]
 * Output: "9534330"
 * Note: The result may be very large, so you need to return a string instead of an integer.
 */

public class LargestNumber {
  public String largestNumber(int[] nums) {
    String[] n = new String[nums.length];
    for (int i = 0; i < nums.length; i++) {
      n[i] = Integer.toString(nums[i]);
    }

    Arrays.sort(n, new NumCompare());

    if (n[0].equals("0")) {
      return "0";
    }

    StringBuilder sb = new StringBuilder();
    for (String s : n) {
      sb.append(s);
    }

    return sb.toString();
  }

  private static class NumCompare implements Comparator<String> {
    @Override
    public int compare(String a, String b) {
      String first = a + b;
      String second = b + a;
      return second.compareTo(first);
    }
  }
}
