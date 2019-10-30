public class Test {
  public static void main(String[] args) throws CloneNotSupportedException {
    A a1 = new A();
    System.out.println(a1.x + " : " + a1.y);

    A a2 = (A) a1.clone();
    System.out.println(a2.x + " : " + a2.y);

    a2.x = 100;
    System.out.println(a1.x + " : " + a2.x);
  }
}