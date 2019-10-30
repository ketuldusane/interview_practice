class SameCharacters {
  private boolean check(String s) {
    if (s == null)
      return false;
    if (s.length() == 1)
      return true;

    for (int i = 1; i < s.length(); i++) {
      if (!(s.charAt(i) == s.charAt(i - 1))) {
        return false;
      }
    }

    return true;
  }

  public static void main(String[] args) {
    SameCharacters sc = new SameCharacters();
    System.out.println(sc.check("abckjsF"));
    System.out.println(sc.check("aaaaa"));
  }
}