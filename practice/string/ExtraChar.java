import java.util.HashMap;

class ExtraChar {
  private String oneExtraChar(String a, String b) {
    if (a == "" || b == "" || a == null || b == null || b.length() - a.length() > 1 || b.length() - a.length() == 0) {
      return "Not Possible";
    }

    HashMap<Character, Integer> map = new HashMap<>();
    for (int i = 0; i < a.length(); i++) {
      map.put(a.charAt(i), 1);
    }

    for (int i = 0; i < b.length(); i++) {
      if (!map.containsKey(b.charAt(i))) {
        return String.valueOf(b.charAt(i));
      }
    }

    return null;
  }

  private String oneExtraChar2(String a, String b) {
    if (a == "" || b == "" || a == null || b == null || b.length() - a.length() > 1 || b.length() - a.length() == 0) {
      return "Not Possible";
    }

    int result = 0;

    for (int i = 0; i < a.length(); i++) {
      result ^= a.charAt(i);
    }

    for (int i = 0; i < b.length(); i++) {
      result ^= b.charAt(i);
    }

    return (String.valueOf((char) result));
  }

  public static void main(String[] args) {
    ExtraChar e = new ExtraChar();
    // System.out.println(e.oneExtraChar("abc", "abcd"));
    // System.out.println(e.oneExtraChar("abc", "abcde"));
    // System.out.println(e.oneExtraChar("abc", ""));
    // System.out.println(e.oneExtraChar(null, null));

    System.out.println(e.oneExtraChar2("abcdd", "abcdde"));
  }
}