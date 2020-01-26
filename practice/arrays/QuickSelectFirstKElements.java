package arrays;

import java.util.*;

public class QuickSelectFirstKElements {
  public int[] findFirstK(int[] arr, int k) {
    if (arr == null || arr.length == 0 || k <= 0) {
      return new int[0];
    }

    if (arr.length < k) {
      return new int[0];
    }

    int[] t = Arrays.copyOf(arr, arr.length);
    quickSelect(t, k, 0, arr.length - 1);
    int[] ans =  Arrays.copyOf(t, k);
    Map<Integer, Integer> map = new HashMap<>();
    for (int i : ans) {
      map.put(i, map.getOrDefault(i, 0) + 1);
    }
    int[] res = new int[k];
    int j = 0;
    for (int i : arr) {
      if (map.containsKey(i)) {
        res[j] = i;
        j++;
      }
    }
    return res;
  }

  private void quickSelect(int[] arr, int k, int low, int high) {
    int p = partition(arr, low, high);

    if (k - 1 <= p) {
      return;
    } else {
      quickSelect(arr, k, p + 1, high);
    }
  }

  private int partition(int[] arr, int low, int high) {
    int pivot = arr[high];
    int i = low;
    for (int j = low; j < high; j++) {
      if (arr[j] < pivot) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
        i++;
      }
    }
    int temp = arr[i];
    arr[i] = arr[high];
    arr[high] = temp;
    return i;
  }

  public static void main(String[] args) {
    QuickSelectFirstKElements q = new QuickSelectFirstKElements();
    int[] arr = {4,8,1,3};
    int[] ans = q.findFirstK(arr, 3);
    System.out.println(Arrays.toString(ans));
  }
}
