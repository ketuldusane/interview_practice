package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Text Justification
 * <p>
 * Given an array of words and a width maxWidth, format the text such that each line has exactly maxWidth characters and
 * is fully (left and right) justified.
 * <p>
 * You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra
 * spaces ' ' when necessary so that each line has exactly maxWidth characters.
 * <p>
 * Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not
 * divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.
 * <p>
 * For the last line of text, it should be left justified and no extra space is inserted between words.
 * <p>
 * Note:
 * <p>
 * A word is defined as a character sequence consisting of non-space characters only.
 * Each word's length is guaranteed to be greater than 0 and not exceed maxWidth.
 * The input array words contains at least one word.
 * Example 1:
 * <p>
 * Input:
 * words = ["This", "is", "an", "example", "of", "text", "justification."]
 * maxWidth = 16
 * Output:
 * [
 * "This    is    an",
 * "example  of text",
 * "justification.  "
 * ]
 * Example 2:
 * <p>
 * Input:
 * words = ["What","must","be","acknowledgment","shall","be"]
 * maxWidth = 16
 * Output:
 * [
 * "What   must   be",
 * "acknowledgment  ",
 * "shall be        "
 * ]
 * Explanation: Note that the last line is "shall be    " instead of "shall     be",
 * because the last line must be left-justified instead of fully-justified.
 * Note that the second line is also left-justified becase it contains only one word.
 * Example 3:
 * <p>
 * Input:
 * words = ["Science","is","what","we","understand","well","enough","to","explain",
 * "to","a","computer.","Art","is","everything","else","we","do"]
 * maxWidth = 20
 * Output:
 * [
 * "Science  is  what we",
 * "understand      well",
 * "enough to explain to",
 * "a  computer.  Art is",
 * "everything  else  we",
 * "do                  "
 * ]
 */

public class TextJustification {
  public static void main(String[] args) {
    TextJustification t = new TextJustification();
    List<String> l = t.fullJustify(new String[]{"Science", "is", "what", "we", "understand", "well", "enough", "to", "explain", "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do"}, 20);
    System.out.println(l);
  }

  public List<String> fullJustify(String[] words, int maxWidth) {
    List<String> ans = new ArrayList<>();
    if (words == null || words.length == 0) {
      return ans;
    }

    List<String> temp = new ArrayList<>();
    int wordLength = 0;
    for (String word : words) {
      if (canOffer(word, temp, wordLength, maxWidth)) {
        temp.add(word);
        wordLength += word.length();
      } else {
        ans.add(justify(temp, wordLength, maxWidth));
        temp.clear();
        temp.add(word);
        wordLength = word.length();
      }
    }

    ans.add(left(temp, wordLength, maxWidth));

    return ans;
  }

  private String justify(List<String> temp, int wordLength, int maxWidth) {
    if (temp.size() == 1) {
      return left(temp, wordLength, maxWidth);
    }

    int blanks = temp.size() - 1;
    int[] blanksToFill = new int[blanks];

    int availableSpaces = maxWidth - wordLength;
    int remainingSpaces = availableSpaces % blanks;
    Arrays.fill(blanksToFill, availableSpaces / blanks);

    int j = 0;
    while (remainingSpaces > 0) {
      blanksToFill[j] += 1;
      remainingSpaces--;
      j = (j + 1) % blanks;
    }

    StringBuilder ans = new StringBuilder();
    for (int i = 0; i < temp.size(); i++) {
      ans.append(temp.get(i));
      if (i < temp.size() - 1) {
        ans.append(" ".repeat(blanksToFill[i]));
      }
    }

    return ans.toString();
  }

  private String left(List<String> temp, int wordLength, int maxWidth) {
    StringBuilder ans = new StringBuilder();
    int remainingLength = maxWidth - wordLength;
    boolean first = true;
    for (String word : temp) {
      if (!first) {
        ans.append(" ");
        remainingLength--;
      }
      first = false;
      ans.append(word);
    }

    ans.append(" ".repeat(Math.max(remainingLength, 0)));
    return ans.toString();
  }

  private boolean canOffer(String word, List<String> temp, int wordLength, int maxWidth) {
    int minSpaces = temp.size() - 1;
    int len = wordLength + minSpaces + 1 + word.length();
    return len <= maxWidth;
  }
}
