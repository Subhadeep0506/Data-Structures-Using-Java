package data_structures.implementations.graph;

import java.util.ArrayList;
import java.util.LinkedList;

public class Graph {
  static ArrayList<GraphNode> nodeList = new ArrayList<>();

  public enum State {
    Unvisited, Visited, Visiting;
  }

  public Graph(ArrayList<GraphNode> nodeList) {
    this.nodeList = nodeList;
  }

  public void addDirectedEdge(int i, int j) {
    GraphNode first = nodeList.get(i);
    GraphNode second = nodeList.get(j);
    first.neighbors.add(second);
  }

  public static boolean search(GraphNode start, GraphNode end) {

    LinkedList<GraphNode> queue = new LinkedList<>();
    // setting state of all nodes to unvisited
    for (GraphNode node : nodeList) {
      node.state = State.Unvisited;
    }

    start.state = State.Visiting;
    queue.add(start);
    GraphNode currentNode;
    while (!queue.isEmpty()) {
      currentNode = queue.removeFirst();
      if (currentNode != null) {
        for (GraphNode v : currentNode.neighbors) {
          if (v.state == State.Unvisited) {
            if (v == end) {
              return true;
            } else {
              v.state = State.Visiting;
              queue.add(v);
            }
          }
        }
        currentNode.state = State.Visited;
        
      }
    }

    return false;
  }
}
