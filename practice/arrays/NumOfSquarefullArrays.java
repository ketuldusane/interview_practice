package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Number of Squareful Arrays
 * <p>
 * Given an array A of non-negative integers, the array is squareful if for every pair of adjacent elements, their sum is a perfect square.
 * Return the number of permutations of A that are squareful.  Two permutations A1 and A2 differ if and only if there is some index i such that A1[i] != A2[i].
 * <p>
 * Example 1:
 * <p>
 * Input: [1,17,8]
 * Output: 2
 * Explanation:
 * [1,8,17] and [17,8,1] are the valid permutations.
 * Example 2:
 * <p>
 * Input: [2,2,2]
 * Output: 1
 * <p>
 * Note:
 * 1 <= A.length <= 12
 * 0 <= A[i] <= 1e9
 */

public class NumOfSquarefullArrays {
  int ans = 0;

  public static void main(String[] args) {
    int[] a = {1, 17, 8};
    System.out.println(new NumOfSquarefullArrays().numSquarefulPerms(a));
  }

  public int numSquarefulPerms(int[] A) {
    if (A == null || A.length == 0) {
      return ans;
    }
    Arrays.sort(A);
    permute(A, new ArrayList<>(), new boolean[A.length]);
    return ans;
  }

  private void permute(int[] A, List<Integer> temp, boolean[] visited) {
    if (temp.size() == A.length) {
      ans++;
    } else {
      for (int i = 0; i < A.length; i++) {
        if (visited[i] || i > 0 && A[i] == A[i - 1] && !visited[i - 1]) {
          continue;
        }
        visited[i] = true;
        temp.add(A[i]);

        if (temp.size() < 2 || isPerfectSquare(temp)) {
          permute(A, temp, visited);
        }

        temp.remove(temp.size() - 1);
        visited[i] = false;
      }
    }
  }

  private boolean isPerfectSquare(List<Integer> A) {
    if (A.size() >= 2) {
      for (int i = 1; i < A.size(); i++) {
        int num = A.get(i - 1) + A.get(i);
        double sqrt = Math.sqrt(num);
        if (sqrt % 1 != 0) {
          return false;
        }
      }
    }
    return true;
  }
}
