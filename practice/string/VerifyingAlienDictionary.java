package string;

/**
 * Verifying an Alien Dictionary
 *
 * In an alien language, surprisingly they also use english lowercase letters, but possibly in a different order. The
 * order of the alphabet is some permutation of lowercase letters.
 * Given a sequence of words written in the alien language, and the order of the alphabet, return true if and only if
 * the given words are sorted lexicographicaly in this alien language.
 *
 * Example 1:
 *
 * Input: words = ["hello","leetcode"], order = "hlabcdefgijkmnopqrstuvwxyz"
 * Output: true
 * Explanation: As 'h' comes before 'l' in this language, then the sequence is sorted.
 * Example 2:
 *
 * Input: words = ["word","world","row"], order = "worldabcefghijkmnpqstuvxyz"
 * Output: false
 * Explanation: As 'd' comes after 'l' in this language, then words[0] > words[1], hence the sequence is unsorted.
 * Example 3:
 *
 * Input: words = ["apple","app"], order = "abcdefghijklmnopqrstuvwxyz"
 * Output: false
 * Explanation: The first three characters "app" match, and the second string is shorter (in size.) According to
 * lexicographical rules "apple" > "app", because 'l' > '∅', where '∅' is defined as the blank character which is less
 * than any other character (More info).
 *
 * Constraints:
 *
 * 1 <= words.length <= 100
 * 1 <= words[i].length <= 20
 * order.length == 26
 * All characters in words[i] and order are English lowercase letters.
 */

public class VerifyingAlienDictionary {
  public boolean isAlienSorted(String[] words, String order) {
    int[] orderIndex = new int[26];
    for (int i = 0; i < order.length(); i++) {
      int c = order.charAt(i) - 'a';
      orderIndex[c] = i;
    }
    for (int i = 0; i < words.length - 1; i++) {
      String w1 = words[i];
      String w2 = words[i + 1];
      int min = Math.min(w1.length(), w2.length());
      for (int j = 0; j < min; j++) {
        if (w1.charAt(j) != w2.charAt(j)) {
          int a = w1.charAt(j) - 'a';
          int b = w2.charAt(j) - 'a';
          if (orderIndex[a] > orderIndex[b]) {
            return false;
          }
          break;
        } else if (j == min - 1 && w2.length() == min) {
          return false;
        }
      }
    }
    return true;
  }
}
