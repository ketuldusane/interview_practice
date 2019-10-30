import java.io.Serializable;
import java.lang.Class;

public class X implements Serializable {
  private static final long serialVersionUID = 42L;

  int a, b;

  X(int i, int j) {
    this.a = i;
    this.b = j;
  }
}