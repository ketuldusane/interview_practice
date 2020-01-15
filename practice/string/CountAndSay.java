package string;

/**
 * Count and Say
 * The count-and-say sequence is the sequence of integers with the first five terms as following:
 * <p>
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * <p>
 * Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the count-and-say sequence. You can do so recursively, in other words from the previous member read off the digits, counting the number of digits in groups of the same digit.
 * <p>
 * Note: Each term of the sequence of integers will be represented as a string.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: 1
 * Output: "1"
 * Explanation: This is the base case.
 * Example 2:
 * <p>
 * Input: 4
 * Output: "1211"
 * Explanation: For n = 3 the term was "21" in which we have two groups "2" and "1", "2" can be read as "12" which means frequency = 1 and value = 2, the same way "1" is read as "11", so the answer is the concatenation of "12" and "11" which is "1211".
 */

public class CountAndSay {
  public static void main(String[] args) {
    System.out.println(new CountAndSay().countAndSay(4));
  }

  public String countAndSay(int n) {
    StringBuilder curr = new StringBuilder("1");
    StringBuilder prev;
    for (int i = 2; i <= n; i++) {
      prev = curr;
      curr = new StringBuilder();

      int count = 0;
      char a = '\0';
      for (int j = 0; j < prev.length(); j++) {
        if (j == 0) {
          count++;
          a = prev.charAt(j);
        } else if (prev.charAt(j) == a) {
          count++;
        } else {
          curr.append(count);
          curr.append(a);
          a = prev.charAt(j);
          count = 1;
        }
      }
      curr.append(count);
      curr.append(a);
    }
    return curr.toString();
  }
}
