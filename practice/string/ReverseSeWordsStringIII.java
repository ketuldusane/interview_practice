package string;

/**
 * Reverse Words in a String III
 * <p>
 * Given a string, you need to reverse the order of characters in each word within a sentence while still preserving whitespace and initial word order.
 * <p>
 * Example 1:
 * <p>
 * Input: "Let's take LeetCode contest"
 * Output: "s'teL ekat edoCteeL tsetnoc"
 * Note: In the string, each word is separated by single space and there will not be any extra space in the string.
 */

public class ReverseSeWordsStringIII {
  public String reverseWords(String s) {
    if (s == null || s.equals("")) return s;

    char[] words = s.trim().toCharArray();
    int start = 0;

    for (int i = s.indexOf(' ', 0); i >= 0; i = s.indexOf(' ', start)) {
      reverse(words, start, i - 1);
      start = i + 1;
    }

    reverse(words, start, words.length - 1);
    return new String(words).trim();
  }

  private void reverse(char[] words, int start, int end) {
    int i = start, j = end;
    while (i < j) {
      char c = words[i];
      words[i] = words[j];
      words[j] = c;
      i++;
      j--;
    }
  }
}
