package string.substring_search;

import java.util.ArrayList;
import java.util.List;

/**
 * Rabin Karp algorithm for substring matching.
 *
 * Time complexity:
 *  Best and Average case: O(m + n) where m = pattern length and n is text length
 *  Worst case: O(mn) if all chars are a repetition of pattern or bad hash function
 *
 * Space complexity O(1)
 *
 * References
 * https://en.wikipedia.org/wiki/Rabin%E2%80%93Karp_algorithm
 */

public class RabinkarpSubstringSearch {
  private int prime = 101;

  private long generatePatternHash(char[] pattern, int start, int stop) {
    long hash = 0;
    for (int i = start; i < stop; i++) {
      hash += pattern[i] * Math.pow(prime, i);
    }
    return hash;
  }

  private long regenerateHash(char[] text, long currHash, int removeIdx, int addIdx, int patternLength) {
    currHash -= text[removeIdx];
    currHash /= prime;
    currHash += text[addIdx] * Math.pow(prime, patternLength - 1);
    return currHash;
  }

  private boolean isEqual(char[] text, int start, char[] pattern) {
    for (int i = start, j = 0; j < pattern.length; i++, j++) {
      if (text[i] != pattern[j]) {
        return false;
      }
    }
    return true;
  }

  private List<Integer> search(String text, String pattern) {
    List<Integer> ans = new ArrayList<>();

    int m = pattern.length();
    int n = text.length();

    if (m > n) {
      return ans;
    }

    char[] t = text.toCharArray();
    char[] p = pattern.toCharArray();

    long pHash = generatePatternHash(p, 0, m);
    long tHash = generatePatternHash(t, 0, m);

    for (int i = 0; i < n - m + 1; i++) {
      if (pHash == tHash && isEqual(t, i, p)) {
        ans.add(i);
      }
      if (i < n - m) {
        tHash = regenerateHash(t, tHash, i, i + m, m);
      }
    }

    return ans;
  }

  public static void main(String[] args) {
    RabinkarpSubstringSearch r = new RabinkarpSubstringSearch();
    System.out.println(r.search("helloworldhelloworld", "d"));
  }
}
