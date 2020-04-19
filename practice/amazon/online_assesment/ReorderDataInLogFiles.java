package amazon.online_assesment;

import java.util.*;

/**
 * Reorder Data In Log Files
 * <p>
 * You have an array of logs.  Each log is a space delimited string of words.
 * <p>
 * For each log, the first word in each log is an alphanumeric identifier.  Then, either:
 * <p>
 * Each word after the identifier will consist only of lowercase letters, or;
 * Each word after the identifier will consist only of digits.
 * We will call these two varieties of logs letter-logs and digit-logs.  It is guaranteed that each log has at least one word after its identifier.
 * <p>
 * Reorder the logs so that all of the letter-logs come before any digit-log.  The letter-logs are ordered lexicographically ignoring identifier, with the identifier used in case of ties.  The digit-logs should be put in their original order.
 * <p>
 * Return the final order of the logs.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: logs = ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"]
 * Output: ["let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"]
 * <p>
 * <p>
 * Constraints:
 * <p>
 * 0 <= logs.length <= 100
 * 3 <= logs[i].length <= 100
 * logs[i] is guaranteed to have an identifier, and a word after the identifier.
 */

public class ReorderDataInLogFiles {
  public String[] reorderLogFiles(String[] logs) {
    if (logs == null || logs.length == 0) {
      return new String[0];
    }

    List<String> letters = new ArrayList<>();
    List<String> digits = new ArrayList<>();
    getLettersAndDigitsFromLogs(logs, letters, digits);

    letters.sort(new LetterComparator());

    String[] ans = new String[logs.length];
    for (int i = 0; i < letters.size(); i++) {
      ans[i] = letters.get(i);
    }
    for (int i = letters.size(); i < ans.length; i++) {
      ans[i] = digits.get(i - letters.size());
    }

    return ans;
  }

  private void getLettersAndDigitsFromLogs(String[] logs, List<String> letters, List<String> digits) {
    for (String log : logs) {
      if (Character.isDigit(log.charAt(log.length() - 1))) {
        digits.add(log);
      } else {
        letters.add(log);
      }
    }
  }

  private static class LetterComparator implements Comparator<String> {
    @Override
    public int compare(String s1, String s2) {
      String a = s1.substring(s1.indexOf(" ") + 1);
      String b = s2.substring(s2.indexOf(" ") + 1);
      return a.equals(b) ? s1.compareTo(s2) : a.compareTo(b);
    }
  }
//  public String[] reorderLogFiles(String[] logs) {
//    Arrays.sort(logs, new LogComparator());
//    return logs;
//  }
//
//  private static class LogComparator implements Comparator<String> {
//    public int compare(String s1, String s2) {
//      String[] split1 = s1.split(" ", 2);
//      String[] split2 = s2.split(" ", 2);
//
//      boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
//      boolean isDigit2 = Character.isDigit(split2[1].charAt(0));
//
//      if (isDigit1 && isDigit2) {
//        // both are numbers
//        return 0;
//      } else if (isDigit1) {
//        // if first is number and second is letter, bring letter to front
//        return 1;
//      } else if (isDigit2) {
//        // if first is letter and second is number, push second to back
//        return -1;
//      } else {
//        // if both are letters
//        int c = split1[1].compareTo(split2[1]);
//        if (c == 0) {
//          return split1[0].compareTo(split2[0]);
//        }
//        return c;
//      }
//    }
//  }
}
