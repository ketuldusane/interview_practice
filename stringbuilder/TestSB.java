class TestSB {
  public static void main(String[] args) {
    StringBuilder sb = new StringBuilder();
    String[] words = {"hello", "world"};
    for (String w : words) {
      sb.append(w);
    }
    System.out.println(sb.toString());
  }
}