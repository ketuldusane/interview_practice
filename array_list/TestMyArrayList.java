import java.util.ArrayList;
import java.util.HashMap;

public class TestMyArrayList {

  static class X {
    int a = 5;
    int b = 6;
  }

  public static void main(String[] args) {
    AList m = new AList();
    m.add("hello");
    m.add("world");
    m.add(1);
    m.add(new X());

    System.out.println(m.get(3));

    ArrayList a = new ArrayList();
    a.add("Why");
    a.add("Here");

    HashMap<String, String> h = new HashMap<>();
    h.put("test", "test");

    h.get("test");
  }
}