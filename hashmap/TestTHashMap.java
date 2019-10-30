class TestTHashMap {
  public static void main(String[] args) {
    MHashMap<String, String> map = new MHashMap();

    map.put("Hello", "World");
    map.put("Hello", "Now");
    // map.put("Hello", 1);

    // String s = map.get("Hello").get(1);

    // System.out.println(s);
  }
}