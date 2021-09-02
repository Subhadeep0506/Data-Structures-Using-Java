/**
 *  Route between nodes problem
 */

package data_structures.implementations.graph;

import java.util.ArrayList;

public class Main {
  public static void main(String[] args) {
    ArrayList<GraphNode> nodeList = new ArrayList<>();
    nodeList.add(new GraphNode("A", 0));
    nodeList.add(new GraphNode("B", 1));
    nodeList.add(new GraphNode("C", 2));
    nodeList.add(new GraphNode("D", 3));
    nodeList.add(new GraphNode("E", 4));
    nodeList.add(new GraphNode("F", 5));
    nodeList.add(new GraphNode("G", 6));
    nodeList.add(new GraphNode("H", 7));
    nodeList.add(new GraphNode("I", 8));
    nodeList.add(new GraphNode("J", 9));

    Graph graph = new Graph(nodeList);
    graph.addDirectedEdge(0, 1);
    graph.addDirectedEdge(0, 2);
    graph.addDirectedEdge(0, 3);
    graph.addDirectedEdge(1, 9);
    graph.addDirectedEdge(2, 6);
    graph.addDirectedEdge(4, 0);
    graph.addDirectedEdge(4, 5);
    graph.addDirectedEdge(5, 8);
    graph.addDirectedEdge(6, 7);
    graph.addDirectedEdge(6, 3);
    boolean result = Graph.search(nodeList.get(0), nodeList.get(4)); // search for A->E
    System.out.println(result);
    result = Graph.search(nodeList.get(4), nodeList.get(0));         // search for E->A
    System.out.println(result);
  }
}
