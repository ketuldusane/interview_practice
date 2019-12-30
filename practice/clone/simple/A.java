package clone.simple;

import java.lang.Cloneable;

public class A implements Cloneable {
  int x;
  int y;

  public A() {
    x = 5;
    y = 10;
  }

  @Override
  public Object clone() throws CloneNotSupportedException {
    return super.clone();
  }
}