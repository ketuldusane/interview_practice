package hashmap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Top K Frequent Elements
 * <p>
 * Given a non-empty array of integers, return the k most frequent elements.
 * <p>
 * Example 1:
 * <p>
 * Input: nums = [1,1,1,2,2,3], k = 2
 * Output: [1,2]
 * Example 2:
 * <p>
 * Input: nums = [1], k = 1
 * Output: [1]
 * Note:
 * <p>
 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
 * Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 * <p>
 * <p>
 * <p>
 * One clever approach to solve this in production is:
 * - Maintain a binary search tree of elements and the sort order would be set by their frequency
 * - The HashMap, instead of storing <Value, Frequency> stores <Value, Node>
 * - This would help in easily updating the tree
 * - When we need the top k elements, start gathering nodes from the right most leaf in the tree and gather recursively
 */

public class TopKFrequenctElements {
  public List<Integer> topKFrequent(int[] nums, int k) {
    PriorityQueue<Frequency> pq = new PriorityQueue<>(nums.length, new FrequencyComparator());
    HashMap<Integer, Integer> map = new HashMap<>();
    for (int i : nums) {
      map.put(i, map.getOrDefault(i, 0) + 1);
    }
    for (Integer j : map.keySet()) {
      pq.add(new Frequency(j, map.get(j)));
    }

    List<Integer> ans = new ArrayList<>();
    for (int i = 0; i < k; i++) {
      ans.add(pq.poll().num);
    }
    return ans;
  }

  private static class Frequency {
    int num;
    int numFrequency;

    Frequency(int n, int f) {
      num = n;
      numFrequency = f;
    }
  }

  private static class FrequencyComparator implements Comparator<Frequency> {
    public int compare(Frequency a, Frequency b) {
      if (a.numFrequency < b.numFrequency)
        return 1;
      else if (a.numFrequency > b.numFrequency)
        return -1;
      return 0;
    }
  }
}
