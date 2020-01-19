package graphs;

import java.io.*;
import java.util.*;

public class TopologicalSort {
  public static void main(String args[] ) throws Exception {
    List<Integer> ans = new ArrayList<>();
    Map<Integer, Integer> inDegree = new HashMap<>();
    Map<Integer, List<Integer>> adj = new HashMap<>();
    Set<Integer> visited = new HashSet<>();

    try(BufferedReader s = new BufferedReader(new InputStreamReader(new FileInputStream(new File("test"))))) {
      String constraints = s.readLine();
      int N = Integer.parseInt(constraints.split(" ")[0]);
      int M = Integer.parseInt(constraints.split(" ")[1]);

      for (int i = 0; i < M; i++) {
        String[] temp = s.readLine().split(" ");
        int a = Integer.parseInt(temp[0]);
        int b = Integer.parseInt(temp[1]);
        if (!adj.containsKey(a)) {
          adj.put(a, new ArrayList<>());
        }
        adj.get(a).add(b);
        inDegree.put(b, inDegree.getOrDefault(b, 0) + 1);
        if (!inDegree.containsKey(a)) {
          inDegree.put(a, 0);
        }
      }
    }

    Deque<Integer> queue = new ArrayDeque<>();
    for (int vertex : inDegree.keySet()) {
      if (inDegree.get(vertex) == 0) {
        queue.add(vertex);
        visited.add(vertex);
      }
    }

    while (!queue.isEmpty()) {
      int vertex = queue.peek();
      queue.remove();
      ans.add(vertex);
      if (adj.containsKey(vertex)) {
        for (int n : adj.get(vertex)) {
          if (!visited.contains(n)) {
            inDegree.put(n, inDegree.get(n) - 1);
            if (inDegree.get(n) == 0) {
              queue.add(n);
              visited.add(n);
            }
          }
        }
      }
    }

    System.out.println(ans);
  }
}
