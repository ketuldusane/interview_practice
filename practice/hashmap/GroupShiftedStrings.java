package hashmap;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupShiftedStrings {
  public static void main(String[] args) {
    String[] input = new String[]{"abc", "bcd", "acef", "xyz", "az", "ba", "a", "z"};
    List<List<String>> ans = new GroupShiftedStrings().groupStrings(input);
    for(List<String> a : ans) {
      System.out.println(a.toString());
    }
  }

  public List<List<String>> groupStrings(String[] strings) {
    Map<String, ArrayList<String>> map = new HashMap<>();
    for (String str : strings) {
      String s = normalize(str);
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
    for (String a : map.keySet()) {
      ans.add(map.get(a));
    }

    return ans;
  }

  private String normalize(String s) {
    if (s.charAt(0) == 'a') return s;

    int distance = s.charAt(0) - 'a';
    char[] newS = new char[s.length()];
    for (int i = 0; i < s.length(); i++) {
      int d = (int) s.charAt(i) - distance;
      d = d < 97 ? (122 - (97 - d) + 1) : d;
      d = d > 122 ? (d - 122 + 97) : d;
      newS[i] = (char) d;
    }

    return new String(newS);
  }
}
