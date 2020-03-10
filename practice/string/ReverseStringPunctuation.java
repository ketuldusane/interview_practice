package string;

import java.util.HashMap;
import java.util.Map;

/**
 * Reverse String Punctuation
 * <p>
 * I/P : "This, is a Test!"
 * O/P : "Test, a is This!"
 */

public class ReverseStringPunctuation {
  public static void main(String[] args) {
    ReverseStringPunctuation r = new ReverseStringPunctuation();
    System.out.println(r.reverseString("This, is a test!"));
  }

  public String reverseString(String s) {
    char[] punctuation = new char[]{',', '!', '.', '?'};
    Map<Integer, Character> punPos = new HashMap<>();
    String[] arr = s.split(" ");

    int left = 0;
    int right = arr.length - 1;
    while (left < right) {
      String a = arr[left];
      String b = arr[right];
      for (char p : punctuation) {
        if (p == a.charAt(a.length() - 1)) {
          punPos.put(left, p);
          a = a.substring(0, a.length() - 1);
          break;
        }
      }

      for (char p : punctuation) {
        if (p == b.charAt(b.length() - 1)) {
          punPos.put(right, p);
          b = b.substring(0, b.length() - 1);
          break;
        }
      }

      arr[left] = b;
      arr[right] = a;

      left++;
      right--;
    }

    StringBuilder sb = new StringBuilder();
    for (int i = 0; i < arr.length; i++) {
      sb.append(arr[i]);
      if (punPos.containsKey(i)) {
        sb.append(punPos.get(i));
      }
      sb.append(" ");
    }

    return sb.toString();
  }
}
