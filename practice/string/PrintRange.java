class PrintRange {

  // 1-5, 8, 11-14, 18, 20, 26-29

  public String expand(String s) {
    String num1 = "", num2 = "";
    boolean dash = false;
    StringBuilder result = new StringBuilder();

    if (s.equals("") || s == null)
      return s;

    for (int i = 0; i < s.length(); i++) {
      if (!dash) {
        if (s.charAt(i) == '-') {
          dash = true;            
        } else if (s.charAt(i) == ',' || (i == s.length() - 1)) {
          if (i == s.length() - 1) {
            num1 += s.charAt(i);
          }
          result.append(num1);
          result.append(",");
          num1 = "";
        } else if (Character.isDigit(s.charAt(i))) {
          num1 += s.charAt(i);
        }
      } else if (s.charAt(i) == ',' || (i == s.length() - 1)) {
        if (i == s.length() - 1) {
          num2 += s.charAt(i);
        }

        int n1 = Integer.parseInt(num1);
        int n2 = Integer.parseInt(num2);

        for (int j = n1; j <= n2; j++) {
          result.append(j);
          result.append(",");
        }
        dash = false;
        num1 = "";
        num2 = "";
      } else if (Character.isDigit(s.charAt(i))) {
        num2 += s.charAt(i);
      }
    }

    return result.toString();
  }

  public static void main(String[] args) {
    PrintRange pr = new PrintRange();
    System.out.println(pr.expand("1-50, 8, 11-14, 18, 20, 26-29"));
    System.out.println(pr.expand("5-1, 8, 11-14, 18, 20, 26"));
  }
}