class TestTemp {
  public static void main(String[] args) {
    TestTemp t = new TestTemp();
    String num1 = "999999999999";
    String num2 = "99999999999999999";
    StringBuilder num = new StringBuilder();
    int i = num1.length() - 1;
    int j = num2.length() - 1;
    int carry = 0;
    while (i >= 0 && j >= 0) {
      int a = num1.charAt(i) - '0';
      int b = num2.charAt(j) - '0';
      int ans = a + b + carry;
      carry = ans / 10;
      ans = ans % 10;
      num.append(ans);
      i--;
      j--;
    }
    while (i >= 0) {
      int a = num1.charAt(i) - '0';
      a = a + carry;
      carry = a / 10;
      a = a % 10;
      num.append(a);
      i--;
    }
    while (j >= 0) {
      int a = num2.charAt(j) - '0';
      a = a + carry;
      carry = a / 10;
      a = a % 10;
      num.append(a);
      j--;
    }
    if (carry != 0) {
      num.append(carry);
    }
    String ans = num.reverse().toString();
  }
}