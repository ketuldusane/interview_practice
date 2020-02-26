package algorithmns.dynamic_programming_recursion;

/**
   Edit Distance

   Given two words word1 and word2, find the minimum number of operations required to convert word1 to word2.

   You have the following 3 operations permitted on a word:

   Insert a character
   Delete a character
   Replace a character
   Example 1:

   Input: word1 = "horse", word2 = "ros"
   Output: 3
   Explanation:
   horse -> rorse (replace 'h' with 'r')
   rorse -> rose (remove 'r')
   rose -> ros (remove 'e')
   Example 2:

   Input: word1 = "intention", word2 = "execution"
   Output: 5
   Explanation:
   intention -> inention (remove 't')
   inention -> enention (replace 'i' with 'e')
   enention -> exention (replace 'n' with 'x')
   exention -> exection (replace 'n' with 'c')
   exection -> execution (insert 'u')
 */

public class EditDistance {
  public int minDistance(String word1, String word2) {
    if (word1 == null || word1.length() == 0) {
      return word2.length();
    }
    if (word2 == null || word2.length() == 0) {
      return word1.length();
    }

    /*
     * The following solution uses Levenshtein Algorithm also known as Edit Distance Algorithm
     * https://web.stanford.edu/class/cs124/lec/med.pdf
     */

    int N = word1.length();
    int M = word2.length();

    int[][] d = new int[N + 1][M + 1];

    for (int i = 0; i < N + 1; i++) {
      d[i][0] = i;
    }

    for (int j = 0; j < M + 1; j++) {
      d[0][j] = j;
    }

    for (int i = 1; i < N + 1; i++) {
      for (int j = 1; j < M + 1; j++) {
        int del = d[i - 1][j] + 1;
        int ins = d[i][j - 1] + 1;
        int sub = d[i - 1][j - 1];
        if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
          sub = sub + 1;
        }
        d[i][j] = Math.min(del, Math.min(ins, sub));
      }
    }

    return d[N][M];
  }

  public static void main(String[] args) {
    String word1 = "horse";
    String word2 = "ros";

    System.out.println(new EditDistance().minDistance(word1, word2));
  }
}
