package algorithmns.binary_search;

/**
 * Find Smallest Letter Greater Than Target
 * <p>
 * Given a list of sorted characters letters containing only lowercase letters, and given a target letter target,
 * find the smallest element in the list that is larger than the given target.
 * <p>
 * Letters also wrap around. For example, if the target is target = 'z' and letters = ['a', 'b'], the answer is 'a'.
 * <p>
 * Examples:
 * Input:
 * letters = ["c", "f", "j"]
 * target = "a"
 * Output: "c"
 * <p>
 * Input:
 * letters = ["c", "f", "j"]
 * target = "c"
 * Output: "f"
 * <p>
 * Input:
 * letters = ["c", "f", "j"]
 * target = "d"
 * Output: "f"
 * <p>
 * Input:
 * letters = ["c", "f", "j"]
 * target = "g"
 * Output: "j"
 * <p>
 * Input:
 * letters = ["c", "f", "j"]
 * target = "j"
 * Output: "c"
 * <p>
 * Input:
 * letters = ["c", "f", "j"]
 * target = "k"
 * Output: "c"
 * Note:
 * letters has a length in range [2, 10000].
 * letters consists of lowercase letters, and contains at least 2 unique letters.
 * target is a lowercase letter.
 */

public class SmallestLetterGreaterThanTarget {
  public char nextGreatestLetter(char[] letters, char target) {
    int low = 0, high = letters.length - 1;
    int res = Integer.MAX_VALUE;

    while (low <= high) {
      int mid = (high + low) / 2;
      if (letters[mid] > target && letters[mid] < res) {
        res = letters[mid];
        high = mid - 1;
      } else {
        low = mid + 1;
      }
    }

    if (res != Integer.MAX_VALUE) {
      return (char) res;
    } else if (high == (letters.length - 1)) {
      return letters[0];
    } else {
      return letters[letters.length - 1];
    }
  }
}
