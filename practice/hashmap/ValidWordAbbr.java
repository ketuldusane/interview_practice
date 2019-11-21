package hashmap;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Unique Word Abbreviation
 *
 * An abbreviation of a word follows the form <first letter><number><last letter>. Below are some examples of word abbreviations:
 *
 * a) it                      --> it    (no abbreviation)
 *
 *      1
 *      ↓
 * b) d|o|g                   --> d1g
 *
 *               1    1  1
 *      1---5----0----5--8
 *      ↓   ↓    ↓    ↓  ↓
 * c) i|nternationalizatio|n  --> i18n
 *
 *               1
 *      1---5----0
 *      ↓   ↓    ↓
 * d) l|ocalizatio|n          --> l10n
 * Assume you have a dictionary and given a word, find whether its abbreviation is unique in the dictionary. A word's abbreviation is unique if no other word from the dictionary has the same abbreviation.
 *
 * Example:
 *
 * Given dictionary = [ "deer", "door", "cake", "card" ]
 *
 * isUnique("dear") -> false
 * isUnique("cart") -> true
 * isUnique("cane") -> false
 * isUnique("make") -> true
 */

public class ValidWordAbbr {
  Map<String, HashSet<String>> abbr;

  public static void main(String[] args) {
    String[] dict = new String[]{"hello"};
    ValidWordAbbr validWordAbbr = new ValidWordAbbr(dict);
    System.out.println(validWordAbbr.isUnique("hello"));
  }

  public ValidWordAbbr(String[] dictionary) {
    abbr = new HashMap<>();
    for (String word : dictionary) {
      String a = getAbbr(word);
      HashSet<String> h = abbr.containsKey(a) ? abbr.get(a) : new HashSet<>();
      h.add(word);
      abbr.put(a, h);
    }
  }

  public boolean isUnique(String word) {
    String a = getAbbr(word);
    Set<String> words = abbr.get(a);
    return words == null || (words.size() == 1 && words.contains(word));
  }

  private String getAbbr(String s) {
    if (s.length() <= 2) return s;
    return s.charAt(0) + Integer.toString(s.length() - 2) + s.charAt(s.length() - 1);
  }
}

/**
 * Your ValidWordAbbr object will be instantiated and called as such:
 * ValidWordAbbr obj = new ValidWordAbbr(dictionary);
 * boolean param_1 = obj.isUnique(word);
 */
