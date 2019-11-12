package queue_stack;

import java.util.Stack;

/**
 * Decode String
 * Given an encoded string, return its decoded string.
 * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated
 * exactly k times. Note that k is guaranteed to be a positive integer.
 * You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.
 * Furthermore, you may assume that the original data does not contain any digits and that digits are only for those
 * repeat numbers, k. For example, there won't be input like 3a or 2[4].
 * <p>
 * Examples:
 * <p>
 * s = "3[a]2[bc]", return "aaabcbc".
 * s = "3[a2[c]]", return "accaccacc".
 * s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
 */

public class DecodeString {
  public static void main(String[] args) {
    System.out.println(new DecodeString().decodeString("3[a]2[bc]"));
  }

  public String decodeString(String s) {
    Stack<Integer> num = new Stack<>();
    Stack<String> res = new Stack<>();
    String ans = "";
    int i = 0;

    while (i < s.length()) {
      if (Character.isDigit(s.charAt(i))) {
        int count = 0;
        while (Character.isDigit(s.charAt(i))) {
          count = count * 10 + (s.charAt(i) - '0');
          i++;
        }
        num.push(count);
      } else if (s.charAt(i) == '[') {
        res.push(ans);
        ans = "";
        i++;
      } else if (s.charAt(i) == ']') {
        StringBuilder temp = new StringBuilder(res.pop());
        int n = num.pop();
        for (int j = 0; j < n; j++) {
          temp.append(ans);
        }
        ans = temp.toString();
        i++;
      } else {
        ans += s.charAt(i);
        i++;
      }
    }
    return ans;
  }
}
