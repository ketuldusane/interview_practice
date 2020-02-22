package string.substring_search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Repeated DNA Sequences
 *
 * All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When
 * studying DNA, it is sometimes useful to identify repeated sequences within the DNA.
 *
 * Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.
 *
 * Example:
 * Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
 * Output: ["AAAAACCCCC", "CCCCCAAAAA"]
 */

public class RepeatedDNASequences {
  public List<String> findRepeatedDnaSequences(String s) {
    // Use Rabin Karp Substring search
    int n = s.length();
    int L = 10;
    if (n <= L) {
      return new ArrayList<>();
    }
    Map<Character, Integer> map = new HashMap<>();
    map.put('A', 0);
    map.put('C', 1);
    map.put('G', 2);
    map.put('T', 3);
    // Rolling hash parameters
    int a = 4;
    int aL = (int) Math.pow(a, L);
    int[] nums = new int[n];
    for (int i = 0; i < n; i++) {
      nums[i] = map.get(s.charAt(i));
    }
    // Calculate initial hash
    int hash = 0;
    for (int i = 0; i < L; i++) {
      hash = hash * a + nums[i];
    }
    Set<Integer> seen = new HashSet<>();
    Set<String> output = new HashSet<>();
    seen.add(hash);
    for (int i = 1; i < n - L + 1; i++) {
      hash = getHash(nums, hash, i, L, a, aL);
      if (seen.contains(hash)) {
        output.add(s.substring(i, i + L));
      } else {
        seen.add(hash);
      }
    }
    return new ArrayList<>(output);
  }

  private int getHash(int[] nums, int hash, int i, int L, int a, int aL) {
    return hash * a - nums[i - 1] * aL + nums[i + L - 1];
  }
}
