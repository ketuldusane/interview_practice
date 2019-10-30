class URLify {
  char[] urlify(char[] s, int len) {
    if (s.length == len) {
      return s;
    }

    int i = s.length - 1;
    int j = s.length - 1;

    while (s[i] == ' ') {
      i--;
    }

    while (i >= 0) {
      if (i == j) {
        i--;
        continue;
      }
      if (s[i] != ' ' && s[j] == ' ') {
        s[j] = s[i];
        s[i] = ' ';
        j--;
      } else if (s[i] == ' ' && Math.abs(i-j)>=2) {
        s[j] = '0';
        j--;
        s[j] = '2';
        j--;
        s[j] = '%';
        j--;
      }
      i--;
    }

    return s;
  } 

  public static void main(String[] args) {
    URLify u = new URLify();
    System.out.println(new String(u.urlify("".toCharArray(), 0)));
    System.out.println(new String(u.urlify("Hello World  ".toCharArray(), 11)));
    System.out.println(new String(u.urlify("Hello w orld    ".toCharArray(), 12)));
    System.out.println(new String(u.urlify("Mr John Smith %      ".toCharArray(), 13)));
  }
}