package string;

/**
 * Longest Chunked Palindrome Decomposition
 * <p>
 * Return the largest possible k such that there exists a_1, a_2, ..., a_k such that:
 * <p>
 * Each a_i is a non-empty string;
 * Their concatenation a_1 + a_2 + ... + a_k is equal to text;
 * For all 1 <= i <= k,  a_i = a_{k+1 - i}.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: text = "ghiabcdefhelloadamhelloabcdefghi"
 * Output: 7
 * Explanation: We can split the string on "(ghi)(abcdef)(hello)(adam)(hello)(abcdef)(ghi)".
 * Example 2:
 * <p>
 * Input: text = "merchant"
 * Output: 1
 * Explanation: We can split the string on "(merchant)".
 * Example 3:
 * <p>
 * Input: text = "antaprezatepzapreanta"
 * Output: 11
 * Explanation: We can split the string on "(a)(nt)(a)(pre)(za)(tpe)(za)(pre)(a)(nt)(a)".
 * Example 4:
 * <p>
 * Input: text = "aaa"
 * Output: 3
 * Explanation: We can split the string on "(a)(a)(a)".
 */

public class ChunkedPalindromeDecomposition {
  public static void main(String[] args) {
    ChunkedPalindromeDecomposition c = new ChunkedPalindromeDecomposition();
    int i = c.longestDecomposition("aaa");
    System.out.println(i);
  }

  public int longestDecomposition(String text) {
    if (text == null || text.length() == 0) {
      return 0;
    }
    return iterative(text);
  }

  private int decompose(String text) {
    if (text.length() == 0) {
      return 0;
    }

    int length = 1;
    String valid = "";
    int lastIndex = 0;
    while (true) {
      valid = text.substring(0, length);
      lastIndex = text.lastIndexOf(valid);
      if ((lastIndex + valid.length()) == text.length()) {
        break;
      }
      length++;
    }

    if (valid.length() == text.length()) {
      return 1;
    }

    return 2 + decompose(text.substring(length, text.length() - length));
  }

  private int anotherDecompose(String text) {
    if (text.length() == 0) {
      return 0;
    }

    StringBuilder start = new StringBuilder();
    StringBuilder end = new StringBuilder();

    int i = 0;
    int j = text.length() - 1;

    do {
      start.append(text.charAt(i));
      end.insert(0, text.charAt(j));
      i++;
      j--;
    } while (!start.toString().equals(end.toString()));

    if (end.toString().equals(text)) {
      return 1;
    }

    return 2 + anotherDecompose(text.substring(start.length(), text.lastIndexOf(end.toString())));
  }

  private int iterative(String text) {
    int i = 0;
    int j = text.length() - 1;

    int ans = 0;

    StringBuilder start = new StringBuilder();
    StringBuilder end = new StringBuilder();
    while (i <= j) {
      start.append(text.charAt(i));
      end.insert(0, text.charAt(j));

      if (i < j && start.toString().equals(end.toString())) {
        ans += 2;
        start = new StringBuilder();
        end = new StringBuilder();
      }

      i++;
      j--;
    }

    if (!start.toString().equals("") && !end.toString().equals("")) {
      ans += 1;
    }

    return ans;
  }
}
