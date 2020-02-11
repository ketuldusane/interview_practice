package math;

/**
 * Prime Palindrome
 *
 * TLE
 */

public class PrimePalindrome {
  public int primePalindrome(int N) {
    int n = findPrime(N + 1);
    do {
      if (isPalindrome(n)) {
        return n;
      }
      n = findPrime(n + 1);
    } while (true);
  }

  private int findPrime(int n) {
    for (int i = n;; i++) {
      boolean p = isPrime(i);
      if (p) {
        return i;
      }
    }
  }

  private boolean isPrime(int n) {
    if (n > 2 && n % 2 == 0) {
      return false;
    }
    int p = (int) Math.sqrt(n);
    for (int i = 3; i <= p; i++) {
      if (n % p == 0) {
        return false;
      }
    }
    return true;
  }

  private boolean isPalindrome(int n) {
    String s = String.valueOf(n);
    int i = 0;
    int j = s.length() - 1;
    while (i <= j) {
      if (s.charAt(i) != s.charAt(j)) {
        return false;
      }
      i++;
      j--;
    }
    return true;
  }
}
