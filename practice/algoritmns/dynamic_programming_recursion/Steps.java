import java.math.BigInteger;
import java.util.Arrays;

public class Steps {
  BigInteger steps(int n) {
    BigInteger memo[] = new BigInteger[n + 1];
    Arrays.fill(memo, BigInteger.valueOf(-1));
    return steps(n, memo);
  }

  BigInteger steps(int n, BigInteger[] memo) {
    if (n < 0) {
      return BigInteger.ZERO;
    } else if (n == 0) {
      return BigInteger.ONE;
    } else if (memo[n].compareTo(BigInteger.valueOf(-1)) > 1) {
      return memo[n];
    } else {
      BigInteger a = steps(n - 1, memo);
      BigInteger b = steps(n - 2, memo);
      BigInteger c = steps(n - 3, memo);
      memo[n] = a.add(b).add(c);
      return memo[n];
    }
  }

  public static void main(String[] args) {
    Steps s = new Steps();
    System.out.println(s.steps(3).toString());
  }
}                                                                                                      