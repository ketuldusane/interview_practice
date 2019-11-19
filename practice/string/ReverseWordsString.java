package string;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an input string, reverse the string word by word.
 *
 *
 *
 * Example 1:
 *
 * Input: "the sky is blue"
 * Output: "blue is sky the"
 * Example 2:
 *
 * Input: "  hello world!  "
 * Output: "world! hello"
 * Explanation: Your reversed string should not contain leading or trailing spaces.
 * Example 3:
 *
 * Input: "a good   example"
 * Output: "example good a"
 * Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
 *
 *
 * Note:
 *
 * A word is defined as a sequence of non-space characters.
 * Input string may contain leading or trailing spaces. However, your reversed string should not contain leading or trailing spaces.
 * You need to reduce multiple spaces between two words to a single space in the reversed string.
 */

public class ReverseWordsString {
  public static void main(String[] args) {
    String input = " the sky is  blue  ";
    ReverseWordsString reverseWordsString = new ReverseWordsString();
    System.out.println(reverseWordsString.reverseWords(input));
    System.out.println(reverseWordsString.reverseWordsHashMap(input));
  }

  public String reverseWords(String s) {
    if (s.length() == 0) return s;

    boolean found = false;
    int start = -1, end = -1;
    StringBuilder sb = new StringBuilder();

    for (int i = s.length() - 1; i >= 0; i--) {
      if (s.charAt(i) == ' ') {
        if (found) {
          end = i;
          sb.append(s.substring(end + 1, start + 1));
          sb.append(" ");
        }
        found = false;
        start = -1;
        end = -1;
      } else {
        if (!found) {
          start = i;
        }
        found = true;
      }
    }

    if (found) {
      sb.append(s, 0, start + 1);
    }

    if (sb.length() > 0 && sb.charAt(sb.length() - 1) == ' ') {
      sb.deleteCharAt(sb.length() - 1);
    }

    return sb.toString();
  }

  public String reverseWordsHashMap(String s) {
    int count = 1;
    boolean found = false;
    StringBuilder sb = new StringBuilder();
    Map<Integer, String> words = new HashMap<>();
    for (int i = 0; i < s.length(); i++) {
      if (s.charAt(i) == ' ') {
        if (found) {
          words.put(count, sb.toString());
          sb.delete(0, sb.length());
          count++;
        }
        found = false;
      } else {
        sb.append(s.charAt(i));
        found = true;
      }
    }

    if (found) {
      words.put(count, sb.toString());
      count++;
    }

    sb.delete(0, sb.length());
    for (int i = count - 1; i > 0; i--) {
      sb.append(words.get(i));
      if (i != 1)
        sb.append(" ");
    }

    return sb.toString();
  }
}
