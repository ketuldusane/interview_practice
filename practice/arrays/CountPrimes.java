package arrays;

/**
 * Count Primes
 *
 * Count the number of prime numbers less than a non-negative number, n.

 Example:

 Input: 10
 Output: 4
 Explanation: There are 4 prime numbers less than 10, they are 2, 3, 5, 7.
 */

public class CountPrimes {
  public int countPrimes(int n) {
    int count = 0;
    // memoization
    boolean[] notprime = new boolean[n];
    for (int i = 2; i < n; i++) {
      if (!notprime[i]) {
        count++;
        for (int j = 2; i * j < n; j++) {
          notprime[i * j] = true; // update values in memoized table
        }
      }
    }
    return count;
  }
}
