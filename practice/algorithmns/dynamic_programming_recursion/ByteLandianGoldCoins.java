package algorithmns.dynamic_programming_recursion;

import java.util.HashMap;
import java.util.Map;

/**
 * In Byteland they have a very strange monetary system.

 Each Bytelandian gold coin has an integer number written on it. A coin n can be exchanged in a bank into three coins: n/2, n/3 and n/4. But these numbers are all rounded down (the banks have to make a profit).

 You can also sell Bytelandian coins for American dollars. The exchange rate is 1:1. But you can not buy Bytelandian coins.

 You have one gold coin. What is the maximum amount of American dollars you can get for it?

 Input
 The input will contain several test cases (not more than 10). Each testcase is a single line with a number n, 0 <= n <= 1 000 000 000. It is the number written on your coin.

 Output
 For each test case output a single line, containing the maximum amount of American dollars you can make.

 Example
 Input:
 12
 2

 Output:
 13
 2
 */

public class ByteLandianGoldCoins {
  public int getDollars(int N) {
    Map<Integer, Integer> cache = new HashMap<>();
    return solve(N, cache);
  }

  private int solve(int N, Map<Integer, Integer> cache) {
    if (N <= 0) {
      return 0;
    } else if (N == 1 || N == 2) {
      return N;
    } else if (cache.containsKey(N)) {
      return cache.get(N);
    }
    cache.put(N, Math.max(N, solve(N/2, cache) + solve(N/3, cache) + solve(N/4, cache)));
    return cache.get(N);
  }

  public static void main(String[] args) {
    System.out.println(new ByteLandianGoldCoins().getDollars(12));
  }
}
