package string;

/**
 * You are playing the following Flip Game with your friend: Given a string that contains only these two characters: + and -, you and your friend take turns to flip two consecutive "++" into "--". The game ends when a person can no longer make a move and therefore the other person will be the winner.

 Write a function to determine if the starting player can guarantee a win.

 Example:

 Input: s = "++++"
 Output: true
 Explanation: The starting player can guarantee a win by flipping the middle "++" to become "+--+".
 */

public class FlipGameII {
  private boolean ans = false;

  public boolean canWin(String s) {
//    if (s == null) {
//      return false;
//    }
//
//    ans = ans || backtrack(s.toCharArray(), s, 1);
//    return ans;

    if (s == null || s.length() < 2) {
      return false;
    }

    for (int i = 0; i < s.length() - 1; i++) {
      if (s.startsWith("++", i)) {
        String t = s.substring(0, i) + "--" + s.substring(i + 2);

        if (!canWin(t)) {
          return true;
        }
      }
    }

    return false;
  }

  private boolean backtrack(char[] c, String s, int player) {
    if (player == 1) {
      if (!s.contains("++")) {
        return false;
      }
    } else if (player == 2) {
      if (!s.contains("++")) {
        return true;
      }
    }

    for (int i = 0; i < s.length() - 1; i++) {
      if (c[i] == '+' && c[i + 1] == '+') {
        c[i] = '-';
        c[i + 1] = '-';
        s = new String(c);
        ans = ans || backtrack(c, s, player == 1 ? 2: 1);
        c[i] = '+';
        c[i + 1] = '+';
        s = new String(c);
      }
    }

    return ans;
  }

  public static void main(String[] args) {
    System.out.println(new FlipGameII().canWin("+++++++++"));
  }
}
