import java.util.ArrayList;

class RotateArrays {
  public static void main(String[] args) {
    int a[] = { 1, 2, 3, 4, 5, 6, 7 };
    int d = 3;

    int x[] = new int[a.length];
    int j = d - 1;

    for (int i = 0; i < a.length; i++) {
      if (j < a.length) {
        x[i] = a[j];
      } else {
        if (j == a.length)
          j = 0;
        x[i] = a[j];
      }
      j++;

      System.out.print(x[i] + " , ");


    }
  }
}