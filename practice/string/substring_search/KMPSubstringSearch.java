package string.substring_search;

/**
 * Knuth-Morris-Prath algorithm for substring matching.
 *
 * Time complexity in worst case O(m + n)
 * Space complexity O(m)
 */

public class KMPSubstringSearch {
  private int[] createPatternArr(char[] pattern) {
    int i = 1;
    int j = 0;
    int[] pArr = new int[pattern.length];
    while (i < pattern.length) {
      if (pattern[i] == pattern[j]) {
        pArr[i] = j + 1;
        i++;
        j++;
      } else {
        if (j != 0) {
          j = pArr[j - 1];
        } else {
          pArr[i] = 0;
          i++;
        }
      }
    }
    return pArr;
  }

  private boolean search(String text, String pattern) {
    if (pattern.length() > text.length()) {
      return false;
    }

    char[] t = text.toCharArray();
    char[] p = pattern.toCharArray();

    int i = 0;
    int j = 0;

    int[] pArr = createPatternArr(p);

    while (i < t.length && j < p.length) {
      if (t[i] == p[j]) {
        i++;
        j++;
      } else {
        if (j != 0) {
          j = pArr[j - 1];
        } else {
          i++;
        }
      }
    }

    return j == p.length;
  }

  public static void main(String[] args) {
    KMPSubstringSearch k = new KMPSubstringSearch();
    System.out.println(k.search("abgabc", "ga"));
  }
}
