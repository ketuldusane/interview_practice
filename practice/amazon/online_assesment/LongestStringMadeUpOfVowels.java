package amazon.online_assesment;

import java.util.ArrayList;
import java.util.List;

public class LongestStringMadeUpOfVowels {
  public static void main(String[] args) {
    LongestStringMadeUpOfVowels l = new LongestStringMadeUpOfVowels();

    System.out.println(l.longestString("aaabbaaba"));
    System.out.println(l.longestString("aaabbaab"));
    System.out.println(l.longestString("bbaaabbaa"));
    System.out.println(l.longestString("bbaaabbaabbb"));
    System.out.println(l.longestString("ffaoaoeffaaff"));
    System.out.println(l.longestString("aoao"));
    System.out.println(l.longestString("frfr"));
  }

  public int longestString(String s) {
    List<String> parts = new ArrayList<>();
    StringBuilder current = new StringBuilder();

    for (char c : s.toCharArray()) {
      if (isVowel(c)) {
        current.append(c);
      } else {
        if (current.length() > 0) {
          parts.add(current.toString());
          current = new StringBuilder();
        }
      }
    }

    if (current.length() > 0) {
      parts.add(current.toString());
    }

    int best = Integer.MIN_VALUE;

//    if vowel substring is at front and end, aaaBBaaaBBaaa
//    we could consider front, 1 middle, end which makes 3 elements
    if (parts.size() > 1 && s.startsWith(parts.get(0))) {
      best = Math.max(best, parts.get(0).length() + parts.get(parts.size() - 1).length() + getMax(parts, 1, parts.size() - 2));
    }

//    if vowel substring is at front only, aaaBBaaBBaaaBB,
//    we could consider front, 1 middle which is 2 elements only
    if (parts.size() > 1 && s.startsWith(parts.get(0))) {
      best = Math.max(best, parts.get(0).length() + getMax(parts, 1, parts.size() - 1));
    }

//    if vowel substring is at the end, BBaaBBaaa,
//    we could consider 1 middle, end which makes 2 elements only
    if (parts.size() > 1 && s.endsWith(parts.get(parts.size() - 1))) {
      best = Math.max(best, parts.get(parts.size() - 1).length() + getMax(parts, 0, parts.size() - 1));
    }

//    if substring does not happen at front or end, BBaaaBBBaaaaBBB,
//    we could consider 1 middle only
    best = Math.max(best, getMax(parts, 0, parts.size() - 1));

    return best;
  }

  private int getMax(List<String> l, int start, int end) {
    int max = 0;
    for (int i = start; i <= end; i++) {
      max = Math.max(l.get(i).length(), max);
    }
    return max;
  }

  private boolean isVowel(char c) {
    return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
  }
}
