package arrays;

/**
 * Find The Celebrity
 * <p>
 * Suppose you are at a party with n people (labeled from 0 to n - 1) and among them, there may exist one celebrity.
 * The definition of a celebrity is that all the other n - 1 people know him/her but he/she does not know any of them.
 * Now you want to find out who the celebrity is or verify that there is not one. The only thing you are allowed to do
 * is to ask questions like: "Hi, A. Do you know B?" to get information of whether A knows B. You need to find out the
 * celebrity (or verify there is not one) by asking as few questions as possible (in the asymptotic sense).
 * <p>
 * You are given a helper function bool knows(a, b) which tells you whether A knows B. Implement a function
 * int findCelebrity(n). There will be exactly one celebrity if he/she is in the party. Return the celebrity's label
 * if there is a celebrity in the party. If there is no celebrity, return -1.
 * <p>
 * Example 1:
 * <p>
 * Input: graph = [
 * [1,1,0],
 * [0,1,0],
 * [1,1,1]
 * ]
 * Output: 1
 * Explanation: There are three persons labeled with 0, 1 and 2. graph[i][j] = 1 means person i knows person j,
 * otherwise graph[i][j] = 0 means person i does not know person j. The celebrity is the person labeled as 1 because
 * both 0 and 2 know him but 1 does not know anybody.
 * <p>
 * Example 2:
 * <p>
 * Input: graph = [
 * [1,0,1],
 * [1,1,0],
 * [0,1,1]
 * ]
 * Output: -1
 * Explanation: There is no celebrity.
 * <p>
 * <p>
 * Note:
 * <p>
 * The directed graph is represented as an adjacency matrix, which is an n x n matrix where a[i][j] = 1 means person i
 * knows person j while a[i][j] = 0 means the contrary.
 * Remember that you won't have direct access to the adjacency matrix.
 */

public class FindTheCelebrity {
  public int findCelebrity(int n) {
    // Pick an initial candidate
    int candidate = 0;
    for (int i = 1; i < n; i++) {
      /*
        We go through each candidate and see it our current candidate knows the next person
        The rules of the problem are as follows:
          - Everyone knows the celebrity
          - Celebrity knows no one
        So, if we are scanning through all the people and if a celebrity exists, we are sure to stumble upon them
        As soon as we find that num, it will never change as stated by rule #2
      */
      if (knows(candidate, i)) {
        candidate = i;
      }
    }
    // Make sure that the candidate we think is the celebrity is actually a celebrity
    for (int i = 0; i < n; i++) {
      if (candidate != i && knows(candidate, i) || !knows(i, candidate)) {
        return -1;
      }
    }
    return candidate;
  }

  // A driver function provided on LeetCode
  boolean knows(int i, int j) {
    return true;
  }
}
