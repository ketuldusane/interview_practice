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
    Map<String, ArrayList<String>> map = new HashMap<>();
    for (String str : strs) {
      char[] temp = str.toCharArray();
      Arrays.sort(temp);
      String s = new String(temp);
      ArrayList<String> a;
      if (map.containsKey(s)) {
        a = map.get(s);
      } else {
        a = new ArrayList<>();
      }
      a.add(str);
      map.put(s, a);
    }

    List<List<String>> ans = new ArrayList<>();
    for (String key : map.keySet()) {
      ans.add(map.get(key));
    }

    return ans;
  }
}
