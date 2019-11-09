package queue_stack;

import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class OpenTheLock {
  public static void main(String[] args) {
    OpenTheLock openTheLock = new OpenTheLock();
    String[] deadEnds = {"0201", "0101", "0102", "1212", "2002"};
    String target = "0202";
    System.out.println(openTheLock.openLock(deadEnds, target));
  }

  public int openLock(String[] deadEnds, String target) {
    Set<String> dead = new HashSet<>();
    Collections.addAll(dead, deadEnds);

    Queue<String> queue = new LinkedList<>();
    queue.offer("0000");
    queue.offer(null);

    Set<String> seen = new HashSet<>();
    seen.add("0000");

    int depth = 0;
    while (!queue.isEmpty()) {
      String node = queue.poll();
      if (node == null) {
        depth++;
        if (queue.peek() != null)
          queue.offer(null);
      } else if (node.equals(target)) {
        return depth;
      } else if (!dead.contains(node)) {
        for (int i = 0; i < 4; ++i) {
          for (int d = -1; d <= 1; d += 2) {
            int y = ((node.charAt(i) - '0') + d + 10) % 10;
            String nei = node.substring(0, i) + ("" + y) + node.substring(i + 1);
            if (!seen.contains(nei)) {
              seen.add(nei);
              queue.offer(nei);
            }
          }
        }
      }
    }
    return -1;
  }
}
