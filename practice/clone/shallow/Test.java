package clone.shallow;

public class Test {
  public static void main(String[] args) throws CloneNotSupportedException {
    P p1 = new P();

    p1.x.a = 5;
    p1.x.b = 10;

    System.out.println(p1.x.a);
    System.out.println(p1.x.b);

    P p2 = (P)p1.clone();

    p2.x.a = 6;

    System.out.println(p1.x.a);
  }
}