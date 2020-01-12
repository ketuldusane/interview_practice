package algoritmns.recursion;

/**
 * Get Nth Smallest Number in an array
 */

public class OrderStatistics {
  public static void main(String[] args) {
    int[] arr = {2, 5, 6, 10, 11, 3, 15};
    System.out.println(nthSmallest(arr, 100));
  }

  private static int nthSmallest(int[] arr, int m) {
    return nth(arr, 0, arr.length - 1, m - 1);
  }

  private static int nth(int[] arr, int l, int r, int m) {
    if (l < r) {
      int p = partition(arr, l, r);
      if (p < m) {
        return nth(arr, p + 1, r, m);
      } else if (p > m) {
        return nth(arr, l, p - 1, m);
      } else {
        return arr[p];
      }
    }
    return arr[l];
  }

  private static int partition(int[] arr, int l, int r) {
    int i = l;
    int p = arr[r];
    for (int j = l; j < r; j++) {
      if (arr[j] < p) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
        i++;
      }
    }
    int temp = arr[i];
    arr[i] = arr[r];
    arr[r] = temp;
    return i;
  }
}
