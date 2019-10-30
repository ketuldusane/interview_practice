class ReplaceFirstLastChar {
  private String swap(String s) {
    StringBuilder sb = new StringBuilder(s);
    int start = 0, end = 0;
    char c;

    for (int i = 1; i < s.length(); i++) {
      if (sb.charAt(i) == ' ' || i == s.length() - 1) {
        end = i - 1;
        if (i == s.length() - 1 && sb.charAt(i) != ' ') {
          end = i;
        }

        c = sb.charAt(start);
        sb.setCharAt(start, sb.charAt(end));
        sb.setCharAt(end, c);
        start = i + 1;
      }
    }

    return sb.toString();
  }

  public static void main(String[] args) {
    ReplaceFirstLastChar r = new ReplaceFirstLastChar();
    System.out.println(r.swap("How    a   39458734   are      you"));
    System.out.println(r.swap("Hello World"));
    System.out.println(r.swap("a"));
    System.out.println(r.swap("ab "));
    System.out.println(r.swap(""));
  }
}