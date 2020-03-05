package graphs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

/**
 * String Transform into Another String
 * <p>
 * Given two strings str1 and str2 of the same length, determine whether you can transform str1 into str2 by doing zero
 * or more conversions.
 * In one conversion you can convert all occurrences of one character in str1 to any other lowercase English character.
 * Return true if and only if you can transform str1 into str2.
 * <p>
 * Example 1:
 * <p>
 * Input: str1 = "aabcc", str2 = "ccdee"
 * Output: true
 * Explanation: Convert 'c' to 'e' then 'b' to 'd' then 'a' to 'c'. Note that the order of conversions matter.
 * <p>
 * Example 2:
 * <p>
 * Input: str1 = "leetcode", str2 = "codeleet"
 * Output: false
 * Explanation: There is no way to transform str1 to str2.
 * <p>
 * Note:
 * <p>
 * 1 <= str1.length == str2.length <= 10^4
 * Both str1 and str2 contain only lowercase English letters.
 * <p>
 * REFER: https://leetcode.com/problems/string-transforms-into-another-string/discuss/355382/JavaC%2B%2BPython-Need-One-Unused-Character
 */

public class StringTransformIntoAnotherString {
  public boolean canConvert(String str1, String str2) {
    if (str1.equals(str2)) {
      return true;
    }
    Map<Character, Character> map = new HashMap<>();
    for (int i = 0; i < str1.length(); i++) {
      if (map.getOrDefault(str1.charAt(i), str2.charAt((i))) != str2.charAt(i)) {
        return false;
      }
      map.put(str1.charAt(i), str2.charAt(i));
    }
    return new HashSet<>(map.values()).size() < 26;
  }
}
