import java.util.HashMap;

public class Driver {
  public static void main(String[] args) {
    Graph graph = new Graph();
    graph.addEddge("a", "b");
    graph.addEddge("a", "c");
    graph.addEddge("b", "d");
    graph.addEddge("d", "e");

    System.out.println(graph.isTherePath("b", "c"));
  }
}
