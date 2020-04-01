package string;

import java.util.ArrayList;
import java.util.List;

/**
 * ZigZag Conversion
 * <p>
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to
 * display this pattern in a fixed font for better legibility)
 * <p>
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 * <p>
 * Write the code that will take a string and make this conversion given a number of rows:
 * <p>
 * string convert(string s, int numRows);
 * Example 1:
 * <p>
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 * Example 2:
 * <p>
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * Explanation:
 * <p>
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 */

public class ZIgZagConversion {
  public String convert(String s, int numRows) {
    if (s == null || s.length() == 0) {
      return "";
    }

    if (numRows == 1) {
      return s;
    }

    List<StringBuilder> list = new ArrayList<>(numRows);
    for (int i = 0; i < numRows; i++) {
      list.add(new StringBuilder());
    }

    int row = 0;
    boolean down = false;

    for (char c : s.toCharArray()) {
      list.get(row).append(c);
      if (row == 0 || row == numRows - 1) {
        down = !down;
      }
      row += down ? 1 : -1;
    }

    StringBuilder sb = new StringBuilder();
    for (StringBuilder r : list) {
      sb.append(r);
    }

    return sb.toString();
  }
}
