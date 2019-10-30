import java.lang.Cloneable;

public class P implements Cloneable {
  X x = new X();

  @Override
  public Object clone() throws CloneNotSupportedException {
    return super.clone();
  }
}