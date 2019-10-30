class Unique {
  private static boolean isUnique(String s) {
    boolean exists[] = new boolean[128];
    for (int i = 0; i < s.length(); i++) {
      int val = s.charAt(i);
      if (exists[val])
        return false;
      exists[val] = true;
    }
    return true;
  }

  private static boolean isStringUnique(String s) {
    int x = 0;
    for (int i = 0; i < s.length(); i++) {
      x ^= (int) s.charAt(i);
    }
    System.out.println(x);

    return x == 0 ? true : false;
  }

  public static void main(String[] args) {
    String s = "abcd";
    System.out.println(isUnique(s));
    System.out.println(isStringUnique(s));
  }
}