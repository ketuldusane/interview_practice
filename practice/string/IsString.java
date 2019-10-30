class IsString {
  private String isString(String input) {
    for (int i = 0; i < input.length(); i++) {
      int val = input.charAt(i);
      if (val > 57 || val < 48) {
        return "String";
      }
    }

    return "Integer";
  }

  public static void main(String[] args) {
    IsString is = new IsString();
    System.out.println(is.isString("123"));
    System.out.println(is.isString("123.4"));
    System.out.println(is.isString("123243045031659skfgk24905u5434635"));
  }
}