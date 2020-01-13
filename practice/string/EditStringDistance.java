package string;

import java.util.Arrays;

public class EditStringDistance {
  public int compare(String s1, String s2, int tolerance) {
    int[][] dp = new int[2][s1.length() + 1];
    Arrays.fill(dp[0], 0);
    for (int i = 1; i < s2.length(); i++) {
      for (int j = 0; j < s1.length(); j++) {
        if (j == 0) {
          dp[i % 2][j] = i;
        } else if (Character.toLowerCase(s1.charAt(j - 1)) == Character.toLowerCase(s2.charAt(i - 1))) {
          dp[i%2][j] = dp[(i - 1)%2][j - 1];
        } else {
          dp[i%2][j] = 1 + min(dp[(i - 1)%2][j], dp[i][j - 1], dp[(i - 1)%2][j - 1]);
        }
      }
    }
    return dp[s2.length() % 2][s1.length()];
  }

  int min(int x, int y, int z)
  {
    if (x <= y && x <= z)
      return x;
    if (y <= x && y <= z)
      return y;
    else
      return z;
  }

  public static void main(String[] args) {
    EditStringDistance e = new EditStringDistance();
    System.out.println(e.compare("sunday", "hello", 0));
  }
}