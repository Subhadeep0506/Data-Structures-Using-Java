package data_structures.implementations.graph;

import java.util.ArrayList;

public class GraphNode {
  public String name;
  public int index;
  public boolean isVisited;
  public GraphNode parent;
  public Graph.State state;

  public ArrayList<GraphNode> neighbors = new ArrayList<>();

  public GraphNode(String name, int index) {
    this.name = name;
    this.index = index;
  }
}
