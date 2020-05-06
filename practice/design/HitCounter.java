package design;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class HitCounter {
  private Map<Integer, Node> map;
  private PriorityQueue<Node> queue;
  private int hits;
  private int latest;

  /**
   * Initialize your data structure here.
   */
  public HitCounter() {
    map = new HashMap<>();
    queue = new PriorityQueue<>((n1, n2) -> n1.timestamp - n2.timestamp);
    hits = 0;
    latest = 0;
  }

  public static void main(String[] args) {
    HitCounter h = new HitCounter();
    // hit at timestamp 1.
    h.hit(1);

// hit at timestamp 2.
    h.hit(2);

// hit at timestamp 3.
    h.hit(3);

// get hits at timestamp 4, should return 3.
    h.getHits(4);
    h.getHits(301);
  }

  /**
   * Record a hit.
   *
   * @param timestamp - The current timestamp (in seconds granularity).
   */
  public void hit(int timestamp) {
    Node n;
    if (map.containsKey(timestamp)) {
      n = map.get(timestamp);
      queue.remove(n);
    } else {
      n = new Node(timestamp, 0);
    }
    n.hits++;
    map.put(timestamp, n);
    queue.offer(n);
    hits++;
    latest = timestamp;
  }

  /**
   * Return the number of hits in the past 5 minutes.
   *
   * @param timestamp - The current timestamp (in seconds granularity).
   */
  public int getHits(int timestamp) {
    int evict = timestamp - 300;
    while (!queue.isEmpty() && queue.peek().timestamp <= evict) {
      Node n = queue.poll();
      map.remove(n.timestamp);
      hits -= n.hits;
    }

    if (queue.isEmpty()) {
      hits = 0;
    }

    return hits;
  }

  private class Node {
    int timestamp;
    int hits;

    Node(int t, int h) {
      timestamp = t;
      hits = h;
    }
  }
}
