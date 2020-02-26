package algorithmns.recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Letter Combinations of a Phone Number
 *
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.
 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
 * Example:
 * Input: "23"
 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
 */

public class LetterCombinationsPhoneNumber {
  public List<String> letterCombinations(String digits) {
    if (digits == null || digits.equals("")) {
      return new ArrayList<>();
    }
    Map<Character, Character[]> map = new HashMap<>();
    map.put('2', new Character[]{'a','b','c'});
    map.put('3', new Character[]{'d','e','f'});
    map.put('4', new Character[]{'g','h','i'});
    map.put('5', new Character[]{'j','k','l'});
    map.put('6', new Character[]{'m','n','o'});
    map.put('7', new Character[]{'p','q','r','s'});
    map.put('8', new Character[]{'t','u','v'});
    map.put('9', new Character[]{'w','x','y','z'});
    return recurse(digits.toCharArray(), map, 0);
  }

  private List<String> recurse(char[] digits, Map<Character, Character[]> map, int position) {
    if (position == digits.length - 1) {
      List<String> res = new ArrayList<>();
      for (char c : map.get(digits[position])) {
        res.add(Character.toString(c));
      }
      return res;
    }
    List<String> temp = recurse(digits, map, position + 1);
    List<String> newAns = new ArrayList<>();
    for (char c : map.get(digits[position])) {
      for (int i = 0; i < temp.size(); i++) {
        newAns.add(c + temp.get(i));
      }
    }
    return newAns;
  }
}
