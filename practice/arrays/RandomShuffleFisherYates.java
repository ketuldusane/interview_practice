package arrays;

import java.util.Random;

public class RandomShuffleFisherYates {
  private int[] shuffle(int[] a) {
    Random r = new Random();
    for (int i = a.length - 1; i > 0; i--) {
      int j = r.nextInt(a.length);
      int temp = a[i];
      a[i] = a[j];
      a[j] = temp;
    }
    return a;
  }
}
