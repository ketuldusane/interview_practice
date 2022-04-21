package udemy;

import java.util.*;

public class MininumPathValue {

    public static void main(String[] args) {
        List<Integer> from = Arrays.asList(1, 2, 1, 4, 1,5);
        List<Integer> to = Arrays.asList(2,3,4,3,5,3);
        List<Integer> weights = Arrays.asList(10,5,3,2,4,5);
        System.out.println(getMinimumStress(3, from, to, weights, 1, 3));
    }

    public static int getMinimumStress(int graphNodes, List<Integer> graphFrom, List<Integer> graphTo, List<Integer> graphWeight, int source, int destination) {
        if (graphFrom == null || graphTo== null || graphWeight == null) {
            return -1;
        }
        if (graphFrom.size() != graphTo.size() || graphFrom.size() != graphWeight.size()) {
            return -1;
        }

        Map<Integer, Map<Integer, Integer>> graph = new HashMap<>();
        for (int i = 0; i < graphFrom.size(); i++) {
            Integer start = graphFrom.get(i);
            Integer end = graphTo.get(i);

            if (!graph.containsKey(start)) {
                graph.put(start, new HashMap<>());
            }
            if (!graph.containsKey(end)) {
                graph.put(end, new HashMap<>());
            }
            graph.get(start).put(end, graphWeight.get(i));
            graph.get(end).put(start, graphWeight.get(i));
        }

        int stress = dfs(source, destination, graph, new HashSet<>());
        if (stress <= 0 || stress == Integer.MAX_VALUE) {
            return -1;
        }
        return stress;
    }

    private static int dfs(int start, int end, Map<Integer, Map<Integer, Integer>> graph, Set<Integer> visited) {
        if (start == end) {
            return 0;
        }

        if (visited.contains(start)) {
            return 0;
        }

        visited.add(start);

        int weight = Integer.MAX_VALUE;
        Map<Integer, Integer> edges = graph.get(start);
        for (int edge : edges.keySet()) {
            if (!visited.contains(edge)) {
                int nextWeight = dfs(edge, end, graph, visited);
                weight = Math.min(weight, nextWeight + edges.get(edge));
                visited.remove(edge);
            }
        }
        return weight;
    }
}
