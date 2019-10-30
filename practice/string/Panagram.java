class Panagram {
  private boolean isPanagram(String str) {
    String s = str.toLowerCase();
    boolean[] exists = new boolean[26];

    for (int i = 0; i < s.length(); i++) {
      int c = s.charAt(i) - 'a';
      if (c >= 0 && c < 27)
        exists[c] = true;
    }    

    String remaining = remainingCharacters(exists);
    if (remaining.length() != 0) {
      System.out.print(" Remaining characters: " + remaining + " 8 ");
      return false;
    }

    return true;
  }

  private String remainingCharacters(boolean[] exists) {
    StringBuilder sb = new StringBuilder();
    int count = 0;
    char missing = '\0';
    for(int i = 0; i < 26; i++) {
      if (exists[i] == false) {
        missing = (char) (i + 97);
        sb.append(missing);
        count++;
      }
    }

    if (count == 1) {
      System.out.print(" Panagrammatic Lipogram. Missing Char: " + missing);
    }

    return sb.toString();
  }

  public static void main(String[] args) {
    Panagram p = new Panagram();
    System.out.println(p.isPanagram("abc"));
    System.out.println(p.isPanagram("9824rkbfv09234=5646546;896>."));
    System.out.println(p.isPanagram("The quick brown fox jumps over the lazy dog"));
    System.out.println(p.isPanagram("The quick brown fox jumped over the lazy dog"));
    System.out.println(p.isPanagram("qwertyuiop   asdfgh564jklzx 54><?? cvbnm aabhfd"));
    System.out.println(p.isPanagram(new String()));
  }
}