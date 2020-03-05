package design;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * All O(1) Data Structure
 * <p>
 * Implement a data structure supporting the following operations:
 * <p>
 * Inc(Key) - Inserts a new key with value 1. Or increments an existing key by 1. Key is guaranteed to be a non-empty string.
 * Dec(Key) - If Key's value is 1, remove it from the data structure. Otherwise decrements an existing key by 1. If the key does not exist, this function does nothing. Key is guaranteed to be a non-empty string.
 * GetMaxKey() - Returns one of the keys with maximal value. If no element exists, return an empty string "".
 * GetMinKey() - Returns one of the keys with minimal value. If no element exists, return an empty string "".
 * Challenge: Perform all these in O(1) time complexity.
 */

public class AllO1DataStructure {
  private Map<String, Integer> map;
  private Map<Integer, Bucket> freqMap;
  private Bucket head;
  private Bucket tail;

  /**
   * Initialize your data structure here.
   */
  public AllO1DataStructure() {
    map = new HashMap<>();
    freqMap = new HashMap<>();
    head = new Bucket(Integer.MIN_VALUE);
    tail = new Bucket(Integer.MAX_VALUE);
    head.next = tail;
    tail.prev = head;
  }

  public static void main(String[] args) {
    AllO1DataStructure a = new AllO1DataStructure();
    String[] cmds = {"AllOne", "inc", "inc", "inc", "dec", "inc", "inc", "getMaxKey"};
    String[][] vals = {{}, {"a"}, {"b"}, {"a"}, {"b"}, {"a"}, {"c"}, {}};
    for (int i = 0; i < cmds.length; i++) {
      String c = cmds[i];
      switch (c) {
        case "inc":
          a.inc(vals[i][0]);
          break;
        case "dec":
          a.dec(vals[i][0]);
          break;
        case "getMaxKey":
          System.out.println(a.getMaxKey());
          break;
        case "getMinKey":
          System.out.println(a.getMinKey());
      }
    }
  }

  /**
   * Inserts a new key <Key> with value 1. Or increments an existing key by 1.
   */
  public void inc(String key) {
    int val = map.containsKey(key) ? map.get(key) : 0;
    update(key, val, val + 1);
    map.put(key, val + 1);
  }

  /**
   * Decrements an existing key by 1. If Key's value is 1, remove it from the data structure.
   */
  public void dec(String key) {
    if (!map.containsKey(key)) {
      return;
    }
    int val = map.get(key);
    update(key, val, val - 1);
    if (val - 1 == 0) {
      map.remove(key);
    } else {
      map.put(key, val - 1);
    }
  }

  /**
   * Returns one of the keys with maximal value.
   */
  public String getMaxKey() {
    if (tail.prev == head) {
      return "";
    }
    return tail.prev.keys.iterator().next();
  }

  /**
   * Returns one of the keys with Minimal value.
   */
  public String getMinKey() {
    if (head.next == tail) {
      return "";
    }
    return head.next.keys.iterator().next();
  }

  private void update(String key, int oldVal, int newVal) {
    // If oldVal is not 0 than get old bucket and update
    if (oldVal != 0) {
      Bucket oldBucket = freqMap.get(oldVal);
      oldBucket.keys.remove(key);

      // Do we need to remove oldBucket?
      if (oldBucket.keys.size() == 0) {
        removeBucket(oldVal);
      }
    }
    if (newVal != 0) {
      if (freqMap.containsKey(newVal)) {
        freqMap.get(newVal).keys.add(key);
      } else {
        Bucket newBucket = insertBucket(newVal);
        newBucket.keys.add(key);
      }
    }
  }

  private Bucket insertBucket(int val) {
    Bucket bucket = new Bucket(val);
    if (val < head.next.val) {
      bucket.next = head.next;
      bucket.prev = head;
      head.next.prev = bucket;
      head.next = bucket;
    } else if (val > tail.prev.val) {
      tail.prev.next = bucket;
      bucket.prev = tail.prev;
      bucket.next = tail;
      tail.prev = bucket;
    } else {
      Bucket prev = head;
      Bucket curr = head.next;
      while (curr.val < val) {
        prev = curr;
        curr = curr.next;
      }
      prev.next = bucket;
      bucket.prev = prev;
      bucket.next = curr;
      curr.prev = bucket;
    }
    freqMap.put(val, bucket);
    return bucket;
  }

  private void removeBucket(int val) {
    Bucket bucket = freqMap.get(val);
    if (bucket == head.next) {
      head.next = head.next.next;
      head.next.prev = null;
    } else if (bucket == tail.prev) {
      tail.prev = tail.prev.prev;
      tail.prev.next = null;
    } else {
      bucket.prev.next = bucket.next;
      bucket.next.prev = bucket.prev;
    }
    freqMap.remove(val);
  }

  private static class Bucket {
    int val;
    Bucket prev;
    Bucket next;
    Set<String> keys;

    Bucket(int val) {
      this.val = val;
      keys = new HashSet<>();
      prev = null;
      next = null;
    }
  }
}
