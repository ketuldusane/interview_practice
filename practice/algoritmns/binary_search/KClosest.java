package algoritmns.binary_search;

import java.util.ArrayList;
import java.util.List;

public class KClosest {
  public static void main(String[] args) {
    int[] a = new int[]{1,2,3,4,5};
    List<Integer> l = new KClosest().findClosestElements(a, 4, 3);
  }

  public List<Integer> findClosestElements(int[] arr, int k, int x) {
    int low = 0, high = arr.length - k;
    while (low < high) {
      int mid = (low + high) / 2;
      if (x - arr[mid] > arr[mid + k] - x) low = mid + 1;
      else high = mid;
    }
    List<Integer> ret = new ArrayList<>();
    for (int i = low; i < low + k; ++i) {
      ret.add(arr[i]);
    }
    return ret;
  }

  private List<Integer> getList(int[] arr) {
    List<Integer> l = new ArrayList<>();
    for (int i : arr) {
      l.add(i);
    }
    return l;
  }

  static class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
  }
}
