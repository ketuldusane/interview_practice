package amazon.online_assesment;

import java.util.HashMap;
import java.util.Map;

/**
 * Subarrays With K Different Integers
 * <p>
 * Given an array A of positive integers, call a (contiguous, not necessarily distinct) subarray of A good if the number
 * of different integers in that subarray is exactly K.
 * <p>
 * (For example, [1,2,3,1,2] has 3 different integers: 1, 2, and 3.)
 * <p>
 * Return the number of good subarrays of A.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: A = [1,2,1,2,3], K = 2
 * Output: 7
 * Explanation: Subarrays formed with exactly 2 different integers: [1,2], [2,1], [1,2], [2,3], [1,2,1], [2,1,2], [1,2,1,2].
 * Example 2:
 * <p>
 * Input: A = [1,2,1,3,4], K = 3
 * Output: 3
 * Explanation: Subarrays formed with exactly 3 different integers: [1,2,1,3], [2,1,3], [1,3,4].
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= A.length <= 20000
 * 1 <= A[i] <= A.length
 * 1 <= K <= A.length
 */

public class SubArraysWithKDifferentIntegers {
  public int subarraysWithKDistinct(int[] A, int K) {
    int first = subarraysWithAtMostK(A, K);
    int second = subarraysWithAtMostK(A, K - 1);
    return first - second;
  }

  private int subarraysWithAtMostK(int[] A, int K) {
    Map<Integer, Integer> map = new HashMap<>();
    int counter = 0;
    int left = 0;
    int right = 0;
    int subarrays = 0;

    while (right < A.length) {
      int val = A[right];
      if (map.getOrDefault(val, 0) == 0) {
        counter++;
      }
      map.put(val, map.getOrDefault(val, 0) + 1);

      while (counter > K) {
        map.put(A[left], map.get(A[left]) - 1);
        if (map.get(A[left]) == 0) {
          counter--;
        }
        left++;
      }
      subarrays += right - left + 1;
      right++;
    }

    return subarrays;
  }
}
