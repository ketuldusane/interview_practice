package hashmap;

import java.util.*;

/**
 * Group Anagrams
 * Solution
 * Given an array of strings, group anagrams together.
 *
 * Example:
 *
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * Note:
 *
 * All inputs will be in lowercase.
 * The order of your output does not matter.
 */

public class GroupAnagrams {
  public static void main(String[] args) {
    String[] input = new String[]{"eat","tea","tan","ate","nat","bat"};
    List<List<String>> ans = new GroupAnagrams().groupAnagrams(input);
    for (List a : ans) {
      System.out.println(a.toString());
    }
  }

  public List<List<String>> groupAnagrams(String[] strs) {
    List<List<String>> ans = new ArrayList<>();
    Map<String, List<String>> map = new HashMap<>();

    for (String s : strs) {
      String baseS = getBase(s);
      if (map.containsKey(baseS)) {
        map.get(baseS).add(s);
      } else {
        List<String> list = new ArrayList<>();
        list.add(s);
        map.put(baseS, list);
        ans.add(list);
      }
    }

    return ans;
  }

  private String getBase(String s) {
    char[] c = new char[26];
    for (int i = 0; i < s.length(); i++) {
      c[s.charAt(i) - 'a']++;
    }
    return new String(c);
  }
}
