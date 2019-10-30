import java.util.HashMap;

class IsPermutation {
  boolean isPerm(String s1, String s2) {
    String big, small;
    if (s1.length() > s2.length()) {
      big = s1;
      small = s2;
    } else {
      big = s2;
      small = s1;
    }
    HashMap<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < big.length(); i++) {
      if (map.containsKey(big.charAt(i))) {
        map.put(big.charAt(i), map.get(big.charAt(i)) + 1);
      } else {
        map.put(big.charAt(i), 1);
      }
    }
    for (int i = 0; i < small.length(); i++) {
      if (map.containsKey(small.charAt(i)) && map.get(small.charAt(i)) > 0) {
        map.put(small.charAt(i), map.get(small.charAt(i)) - 1);
      } else {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    IsPermutation isPermutation = new IsPermutation();
    System.out.println(isPermutation.isPerm("abcde", "bdc"));
    System.out.println(isPermutation.isPerm("abcde", "bdcf"));
    System.out.println(isPermutation.isPerm("abcde", "aa"));
    System.out.println(isPermutation.isPerm("aabc", "baa"));
    System.out.println(isPermutation.isPerm("aAbc", "baa"));
    System.out.println(isPermutation.isPerm("aAbc", "bAa"));
  }
}