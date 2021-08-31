package data_structures.examples.weighted_graph_algorithms;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class Prim {
  ArrayList<WeightedNode> nodeList = new ArrayList<>();

  public Prim(ArrayList<WeightedNode> nodeList) {
    this.nodeList = nodeList;
  }

  public void addWeightedUndirectedEdge(int i, int j, int d) {
    WeightedNode first = nodeList.get(i);
    WeightedNode second = nodeList.get(j);
    first.neighbors.add(second);
    second.neighbors.add(first);
    first.weightMap.put(second, d);
    second.weightMap.put(first, d);
  }

  // Prim's Algo
  public void primsAlgorithm(WeightedNode node) {
    // setting distance of all nodes to infinity
    for (int i = 0; i < nodeList.size(); i++) {
      nodeList.get(i).distance = Integer.MAX_VALUE;
    }

    node.distance = 0;
    PriorityQueue<WeightedNode> queue = new PriorityQueue<>();
    queue.addAll(nodeList);
    while (!queue.isEmpty()) {
      WeightedNode currentNode = queue.remove();
      for (WeightedNode neighbor : currentNode.neighbors) {
        if (queue.contains(neighbor)) {
          if (neighbor.distance > currentNode.weightMap.get(neighbor)) {
            neighbor.distance = currentNode.weightMap.get(neighbor);
            neighbor.parent = currentNode;
            queue.remove(neighbor);
            queue.add(neighbor);
          }
        }
      }
    }

    int cost = 0;
    for (WeightedNode nodeToCheck : nodeList) {
      System.out.println("Node: " + nodeToCheck + ", key: " + nodeToCheck.distance + ", Parent: " + nodeToCheck.parent);
      cost += nodeToCheck.distance;
    }
    System.out.println("Total cost of MST: " + cost);
  }
}
