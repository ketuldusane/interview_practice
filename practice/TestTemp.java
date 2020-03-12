import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class TestTemp {
  java.util.List<Integer> list;
  java.util.Map<Integer, java.util.Set<Integer>> map;
  java.util.Random rand;

  /**
   * Initialize your data structure here.
   */
  public TestTemp() {
    list = new ArrayList<>();
    map = new HashMap<>();
    rand = new Random();
  }

  public static void main(String[] args) {
    TestTemp t = new TestTemp();
    t.insert(0);
    t.insert(1);
    t.remove(0);
    t.insert(2);
    t.remove(1);
    int i = t.getRandom();
    System.out.println(i);
  }

  /**
   * Inserts a value to the collection. Returns true if the collection did not already contain the specified element.
   */
  public boolean insert(int val) {
    boolean contains = true;
    Set<Integer> idxList = map.getOrDefault(val, new HashSet<>());
    if (idxList.size() > 0) {
      contains = false;
    }
    list.add(val);
    idxList.add(list.size() - 1);
    map.put(val, idxList);
    return contains;
  }

  /**
   * Removes a value from the collection. Returns true if the collection contained the specified element.
   */
  public boolean remove(int val) {
    Set<Integer> idxList = map.getOrDefault(val, new HashSet<>());
    if (idxList.size() == 0) {
      return false;
    }
    int idx = idxList.iterator().next();
    if (idx == list.size() - 1) {
      list.remove(list.size() - 1);
    } else {
      int lastVal = list.get(list.size() - 1);
      map.get(lastVal).remove(lastVal);
      map.get(lastVal).add(idx);
      list.set(idx, lastVal);
      list.remove(list.size() - 1);
    }
    return true;
  }

  /**
   * Get a random element from the collection.
   */
  public int getRandom() {
    return list.get(rand.nextInt(list.size()));
  }
}
