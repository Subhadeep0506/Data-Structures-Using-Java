package data_structures.examples.weighted_graph_algorithms;

import java.util.ArrayList;
import java.util.PriorityQueue;

public class WeightedGraph {
    ArrayList<WeightedNode> nodeList = new ArrayList<>();

    public WeightedGraph(ArrayList<WeightedNode> nodeList) {
        this.nodeList = nodeList;
    }
    
    public void addWeightedEdge(int i, int j, int d) {
        WeightedNode first = nodeList.get(i);
        WeightedNode second = nodeList.get(j);
        first.neighbors.add(second);
        // directed edge from first node to second node
        // with a weight of 'd'
        first.weightMap.put(second, d);
    }

    // prints the path of each vertex from source
    public void pathPrint(WeightedNode node) {
        if (node.parent != null) {
            pathPrint(node.parent);
        }

        System.out.print(node.name + " ");
    }

    // Dijkstra's Algorithm
    void dijkstra(WeightedNode node) {
        PriorityQueue<WeightedNode> queue = new PriorityQueue<>();
        node.distance = 0;
        queue.addAll(nodeList);

        while (!queue.isEmpty()) {
            WeightedNode currentNode = queue.remove();
            for (WeightedNode neighbor : currentNode.neighbors) {
                if (queue.contains(neighbor)) {
                    if (neighbor.distance > currentNode.distance + currentNode.weightMap.get(neighbor)) {
                        neighbor.distance = currentNode.distance + currentNode.weightMap.get(neighbor);
                        neighbor.parent = currentNode;
                        queue.remove(neighbor);
                        queue.add(neighbor);
                    }
                }
            }
        }

        for (WeightedNode nodeToCheck : nodeList) {
            System.out.print("Node: " + nodeToCheck + ", distance: " + nodeToCheck.distance + ", path: ");
            pathPrint(nodeToCheck);
            System.out.println();
        }
    }

    // Bellman Ford algorithm
    public void useBellmanFord(WeightedNode sourceNode) {
        sourceNode.distance = 0; // all other nodes' distance is already set to infinity
        for (int i = 0; i < nodeList.size(); i++) {
            for (WeightedNode currentNode : nodeList) {
                for (WeightedNode neighbor : currentNode.neighbors) {
                    if (neighbor.distance > currentNode.distance + currentNode.weightMap.get(neighbor)) {
                        neighbor.distance = currentNode.distance + currentNode.weightMap.get(neighbor);
                        neighbor.parent = currentNode;
                    }
                }
            }
        }

        System.out.println("Checking for negetive cycle...");
        for (WeightedNode currentNode : nodeList) {
            for (WeightedNode neighbor : currentNode.neighbors) {
                if (neighbor.distance > currentNode.distance + currentNode.weightMap.get(neighbor)) {
                    System.out.println("Negetive cycle found.");
                    System.out.println("Vertex: " + neighbor.name);
                    System.out.println("Old cost: " + neighbor.distance);
                    int newDistance = currentNode.distance + currentNode.weightMap.get(neighbor);
                    System.out.println("New cost: " + newDistance);
                    return;
                }
            }
        }

        System.out.println("No negetive cycle found.");
        for (WeightedNode nodeToCheck : nodeList) {
            System.out.print("Node: " + nodeToCheck + ", distance: " + nodeToCheck.distance + ", path: ");
            pathPrint(nodeToCheck);
            System.out.println();
        }
    }

    // Floyd Warshall Algorithm
    public void floydWarshall() {
        int size = nodeList.size();
        int[][] v = new int[size][size];
        // saving the values to the weights of paths
        // 0 for same vertex, Infinity for edges that has no reach
        for (int i = 0; i < size; i++) {
            WeightedNode first = nodeList.get(i);
            for (int j = 0; j < size; j++) {
                WeightedNode second = nodeList.get(j);
                if (i == j) {
                    v[i][j] = 0;
                } else if (first.weightMap.containsKey(second)) {
                    v[i][j] = first.weightMap.get(second);
                } else {
                    v[i][j] = Integer.MAX_VALUE / 10;
                }
            }
        }
        // the floyd warshall algorithm
        for (int k = 0; k < nodeList.size(); k++) {
            for (int i = 0; i < nodeList.size(); i++) {
                for (int j = 0; j < nodeList.size(); j++) {
                    if (v[i][j] > v[i][k] + v[k][j]) {
                        v[i][j] = v[i][k] + v[k][j];
                    }
                }
            }
        }

        for (int i = 0; i < size; i++) {
            System.out.print("Printing distance list for node " + nodeList.get(i) + ": ");
            for (int j = 0; j < size; j++) {
                System.out.print(v[i][j] + " ");
            }
            System.out.println();
        }
    }
}
