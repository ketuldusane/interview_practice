package string;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 Find All Anagrams in a String

 Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

 Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

 The order of output does not matter.

 Example 1:

 Input:
 s: "cbaebabacd" p: "abc"

 Output:
 [0, 6]

 Explanation:
 The substring with start index = 0 is "cba", which is an anagram of "abc".
 The substring with start index = 6 is "bac", which is an anagram of "abc".
 Example 2:

 Input:
 s: "abab" p: "ab"

 Output:
 [0, 1, 2]

 Explanation:
 The substring with start index = 0 is "ab", which is an anagram of "ab".
 The substring with start index = 1 is "ba", which is an anagram of "ab".
 The substring with start index = 2 is "ab", which is an anagram of "ab".
 */

public class FindAllAnagramsInString {
  public List<Integer> findAnagrams(String s, String p) {
    List<Integer> ans = new ArrayList<>();
    if (p.length() > s.length()) {
      return ans;
    }

    int start = 0;
    int end = 0;

    Map<Character, Integer> map = new HashMap<>();
    for (char c : p.toCharArray()) {
      map.put(c, map.getOrDefault(c, 0) + 1);
    }

    int counter = map.size();

    while (end < s.length()) {
      char c = s.charAt(end);
      if (map.containsKey(c)) {
        map.put(c, map.get(c) - 1);
        if (map.get(c) == 0) {
          counter--;
        }
      }
      end++;

      while (counter == 0) {
        char tempC = s.charAt(start);
        if (map.containsKey(tempC)) {
          map.put(tempC, map.get(tempC) + 1);
          if (map.get(tempC) > 0) {
            counter++;
          }
        }

        if (end - start == p.length()) {
          ans.add(start);
        }

        start++;
      }
    }

    return ans;
  }
}
