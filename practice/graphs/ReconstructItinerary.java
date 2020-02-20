package graphs;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Reconstruct Itinerary
 *
 * Given a list of airline tickets represented by pairs of departure and arrival airports [from, to], reconstruct the
 * itinerary in order. All of the tickets belong to a man who departs from JFK. Thus, the itinerary must begin with JFK.
 *
 * Note:
 *
 * If there are multiple valid itineraries, you should return the itinerary that has the smallest lexical order when
 * read as a single string. For example, the itinerary ["JFK", "LGA"] has a smaller lexical order than ["JFK", "LGB"].
 * All airports are represented by three capital letters (IATA code).
 * You may assume all tickets form at least one valid itinerary.
 * Example 1:
 *
 * Input: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
 * Output: ["JFK", "MUC", "LHR", "SFO", "SJC"]
 * Example 2:
 *
 * Input: [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
 * Output: ["JFK","ATL","JFK","SFO","ATL","SFO"]
 * Explanation: Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"].
 *              But it is larger in lexical order.
 */

public class ReconstructItinerary {
  public List<String> findItinerary(List<List<String>> tickets) {
    LinkedList<String> itinerary = new LinkedList<>();
    if (tickets == null || tickets.size() == 0) {
      return itinerary;
    }
    Map<String, PriorityQueue<String>> connections = new HashMap<>();
    for (List<String> connection : tickets) {
      PriorityQueue<String> queue = connections.getOrDefault(connection.get(0), new PriorityQueue<>());
      queue.offer(connection.get(1));
      connections.put(connection.get(0), queue);
    }
    Deque<String> stack = new ArrayDeque<>();
    stack.push("JFK");
    while (!stack.isEmpty()) {
      String next = stack.peek();
      if (connections.containsKey(next) && connections.get(next).size() > 0) {
        stack.push(connections.get(next).poll());
      } else {
        itinerary.addFirst(stack.pop());
      }
    }
    return itinerary;
  }
}
