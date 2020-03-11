package arrays;

/**
 * String Compression
 * <p>
 * Given an array of characters, compress it in-place.\
 * The length after compression must always be smaller than or equal to the original array.
 * Every element of the array should be a character (not int) of length 1.
 * After you are done modifying the input array in-place, return the new length of the array.
 * <p>
 * Follow up:
 * Could you solve it using only O(1) extra space?
 * <p>
 * Example 1:
 * Input:
 * ["a","a","b","b","c","c","c"]
 * Output:
 * Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]
 * Explanation:
 * "aa" is replaced by "a2". "bb" is replaced by "b2". "ccc" is replaced by "c3".
 * <p>
 * Example 2:
 * Input:
 * ["a"]
 * Output:
 * Return 1, and the first 1 characters of the input array should be: ["a"]
 * Explanation:
 * Nothing is replaced.
 */

public class StringCompression {
  public int compress(char[] chars) {
    int anchor = 0;
    int index = 0;

    while (index < chars.length) {
      char curr = chars[index];
      int count = 0;

      while (index < chars.length && chars[index] == curr) {
        index++;
        count++;
      }

      chars[anchor] = curr;
      anchor++;

      if (count != 1) {
        for (char c : Integer.toString(count).toCharArray()) {
          chars[anchor] = c;
          anchor++;
        }
      }
    }

    return anchor;
  }
}
