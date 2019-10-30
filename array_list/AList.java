import java.util.ArrayList;

public class AList<E> implements Cloneable, java.io.Serializable {
  private static final long serialVersionUID = 42L;

  private Object[] defaultArray;
  private int size = 0;

  public AList() {
    defaultArray = new Object[10];
  }

  public boolean add(E e) {
    if (defaultArray.length == size) {
      grow();
    } else {
      defaultArray[size] = e;
      size++;
    }
    return true;
  }

  public E get(int position) {
    E e = null;
    try {
      e = (E) defaultArray[position];
    } catch (IndexOutOfBoundsException ex) {
      ex.printStackTrace();
    }
    return e;
  }

  public E[] toArray() {
    return (E[]) defaultArray;
  }

  public int getSize() {
    return size;
  }

  private void grow() {
    if (defaultArray.length == size) {
      Object tempArray[] = new Object[size * 2];

      for (int i = 0; i < size; i++) {
        tempArray[i] = defaultArray[i];
      }

      defaultArray = tempArray;
    }
  }
}