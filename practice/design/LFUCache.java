package design;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * LFU Cache
 *
 * Company: Amazon
 *
 * Design and implement a data structure for Least Frequently Used (LFU) cache. It should support the following
 * operations: get and put.
 *
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present. When the cache reaches its capacity,
 * it should invalidate the least frequently used item before inserting a new item. For the purpose of this problem,
 * when there is a tie (i.e., two or more keys that have the same frequency), the least recently used key would be
 * evicted.
 *
 * Note that the number of times an item is used is the number of calls to the get and put functions for that item since
 * it was inserted. This number is set to zero when the item is removed.
 *
 * Follow up:
 * Could you do both operations in O(1) time complexity?
 *
 * Example:
 *
 * LFUCache cache = new LFUCache( 2 );
    *
    *cache.put(1,1);
    *cache.put(2,2);
    *cache.get(1);       // returns 1
    *cache.put(3,3);    // evicts key 2
    *cache.get(2);       // returns -1 (not found)
    *cache.get(3);       // returns 3.
    *cache.put(4,4);    // evicts key 1.
    *cache.get(1);       // returns -1 (not found)
    *cache.get(3);       // returns 3
    *cache.get(4);       // returns 4
 */

public class LFUCache {
  private int time;
  private int capacity;
  private Map<Integer, Item> map;

  public LFUCache(int capacity) {
    time = 0;
    this.capacity = capacity;
    map = new HashMap<>();
  }

  public int get(int key) {
    time++;
    if (map.containsKey(key)) {
      Item item = map.get(key);
      item.frequency += 1;
      item.lastUsed = time;
      map.put(key, item);
      return item.value;
    }
    return -1;
  }

  public void put(int key, int value) {
    time++;
    if (map.size() <= capacity) {
      Item item;
      if (map.containsKey(key)) {
        item = map.get(key);
        item.lastUsed = time;
        item.value = value;
        item.frequency += 1;
      } else {
        item = new Item(key, value, time, 1);
        if (map.size() == capacity) {
          adjust();
        }
      }
      if (map.size() < capacity) {
        map.put(key, item);
      }
    }
  }

  private void adjust() {
    PriorityQueue<Item> queue = new PriorityQueue<>(new ItemComparator());
    for (int key : map.keySet()) {
      queue.offer(map.get(key));
    }
    if (!queue.isEmpty()) {
      Item item = queue.poll();
      map.remove(item.key);
    }
  }

  private static class ItemComparator implements Comparator<Item> {
    public int compare(Item a, Item b) {
      int c = a.frequency - b.frequency;
      if (c == 0) {
        return a.lastUsed - b.lastUsed;
      }
      return c;
    }
  }

  private static class Item {
    int key;
    int value;
    int lastUsed;
    int frequency;
    Item(int k, int v, int l, int f) {
      key = k;
      value = v;
      lastUsed = l;
      frequency = f;
    }
  }
}
