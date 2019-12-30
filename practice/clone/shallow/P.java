package clone.shallow;

import java.lang.Cloneable;

public class P implements Cloneable {
  X x = new X();

  @Override
  public Object clone() throws CloneNotSupportedException {
    P p = (P) super.clone();
    p.x = new X();

    return p;
  }
}