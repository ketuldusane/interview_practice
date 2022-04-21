package udemy;

import java.util.*;

public class MininumPathValue {

    public static int getMinimumStress(int graphNodes, List<Integer> graphFrom, List<Integer> graphTo, List<Integer> graphWeight, int source, int destination) {
        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        for (int i = 0; i < graphFrom.size(); i++) {
            Integer start = graphFrom.get(i);
            Integer end = graphTo.get(i);

            if (!graph.containsKey(start)) {
                graph.put(start, new HashMap<>());
            }

            graph.get(start).put(end, graphWeight.get(i));
        }

        int stress = getMinimum(source, destination, new HashSet<Integer>(), graph);
        if (stress == Integer.MAX_VALUE) {
            return -1;
        }
        return stress;
    }

    private static int getMinimum(int node, int destination, Set<Integer> visited, Map<Integer, Map<Integer, Integer>> graph) {
        if (visited.contains(node)) {
            return 0;
        }

        visited.add(node);

        int stress = Integer.MAX_VALUE;

        Map<Integer, Integer> edges = graph.get(node);

        for (int edge : edges.keySet()) {
            if (!visited.contains(edge)) {
                int curr = getMinimum(edge, destination, visited, graph);
                stress = Math.min(stress, curr + edges.get(edge));
            }
        }

        visited.remove(node);

        return stress;
    }
}
