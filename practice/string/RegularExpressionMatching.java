package string;

import java.util.ArrayDeque;

public class RegularExpressionMatching {
  public boolean isMatch(String s, String p) {
    if (p == null || p.equals("")) {
      return true;
    }

    ArrayDeque<String> pattern = getPatternStack(p);
    ArrayDeque<Character> subject = getSubjectStack(s);
    char laspPop = '\0';

    while (!pattern.isEmpty()) {
      String currP = pattern.pop();
      if (currP.length() > 1) {
        if (currP.equals(".*")) {
          while (!subject.isEmpty()) {
            laspPop = subject.pop();
          }
        } else {
          char compare = currP.charAt(0);
          while (!subject.isEmpty() && subject.peek() == compare) {
            laspPop = subject.pop();
          }
        }
      } else {
        if (currP.equals(".")) {
          if (!subject.isEmpty()) {
            subject.pop();
          }
        } else {
          if (subject.isEmpty()) {
            if (laspPop != currP.charAt(0)) {
              return false;
            }
          } else {
            String testS = Character.toString(subject.peek());
            if (testS.equals(currP)) {
              laspPop = subject.pop();
            } else {
              return false;
            }
          }
        }
      }
    }
    return subject.isEmpty();
  }

  private ArrayDeque<String> getPatternStack(String p) {
    ArrayDeque<String> pattern = new ArrayDeque<>();
    int len = 0;
    for (int i = p.length() - 1; i > 0; i--) {
      if (p.charAt(i) != '*') {
        pattern.push(Character.toString(p.charAt(i)));
        len++;
      } else {
        pattern.push(p.charAt(i - 1) + "" + p.charAt(i));
        len += 2;
        i--;
      }
    }
    if (len != p.length() && p.charAt(0) != '*') {
      pattern.push(Character.toString(p.charAt(0)));
    }
    return pattern;
  }

  private ArrayDeque<Character> getSubjectStack(String s) {
    ArrayDeque<Character> subject = new ArrayDeque<>();
    for (int i = s.length() - 1; i >= 0; i--) {
      subject.push(s.charAt(i));
    }
    return subject;
  }

  public static void main(String[] args) {
    RegularExpressionMatching r = new RegularExpressionMatching();
    System.out.println(r.isMatch("aaa", ".*a"));
  }
}
