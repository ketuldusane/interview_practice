package hashmap;

import java.util.*;

public class TopKFrequenctElements {
  public static void main(String[] args) {
    System.out.println(new TopKFrequenctElements().topKFrequent(new int[]{1,1,1,2,2,3}, 2).toString());
  }

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

  class Frequency {
    int num;
    int numFrequency;
    Frequency(int n, int f) {
      num = n;
      numFrequency = f;
    }
  }

  class FrequencyComparator implements Comparator<Frequency> {
    public int compare(Frequency a, Frequency b) {
      if (a.numFrequency < b.numFrequency)
        return 1;
      else if (a.numFrequency > b.numFrequency)
        return -1;
      return 0;
    }
  }
}
