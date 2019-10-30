import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.io.IOException;

public class TestSerilization {
  static final String file = "a.txt";

  public static void main(String[] args) {
    serializeObject();
    deserializeObject();
  }
  
  private static void serializeObject() {
    X x = new X(5, 10);
    try {
      FileOutputStream fos = new FileOutputStream(file);
      ObjectOutputStream oos = new ObjectOutputStream(fos);

      oos.writeObject(x);

      oos.close();
      fos.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  private static void deserializeObject() {
    try {
      FileInputStream fis = new FileInputStream(file);
      ObjectInputStream ois = new ObjectInputStream(fis);

      X x = (X)ois.readObject();

      ois.close();
      fis.close();

      System.out.println(x.a + " : " + x.b);
    } catch (IOException e) {
      e.printStackTrace();
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    }
  }
}