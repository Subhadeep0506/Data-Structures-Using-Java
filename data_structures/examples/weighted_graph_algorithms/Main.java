package data_structures.examples.weighted_graph_algorithms;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<WeightedNode> nodeList = new ArrayList<>();

        // nodeList.add(new WeightedNode("A", 0));
        // nodeList.add(new WeightedNode("B", 1));
        // nodeList.add(new WeightedNode("C", 2));
        // nodeList.add(new WeightedNode("D", 3));
        // nodeList.add(new WeightedNode("E", 4));
        // nodeList.add(new WeightedNode("F", 5));
        // nodeList.add(new WeightedNode("G", 6));

        // WeightedGraph graph = new WeightedGraph(nodeList);
        // graph.addWeightedEdge(0, 1, 2);
        // graph.addWeightedEdge(0, 2, 5);
        // graph.addWeightedEdge(1, 2, 6);
        // graph.addWeightedEdge(1, 3, 1);
        // graph.addWeightedEdge(1, 4, 3);
        // graph.addWeightedEdge(2, 5, 8);
        // graph.addWeightedEdge(3, 4, -4);
        // graph.addWeightedEdge(4, 6, 9);
        // graph.addWeightedEdge(5, 6, 7);
        // // System.out.println("Printing dijkstra for source A: ");
        // // graph.dijkstra(nodeList.get(0));
        // System.out.println("Printing Bellman ford for source A: ");
        // graph.useBellmanFord(nodeList.get(0));

        // for floyd warshall 
        // nodeList.add(new WeightedNode("A", 0));
        // nodeList.add(new WeightedNode("B", 1));
        // nodeList.add(new WeightedNode("C", 2));
        // nodeList.add(new WeightedNode("D", 3));

        // WeightedGraph graph = new WeightedGraph(nodeList);
        // graph.addWeightedEdge(0, 3, 1);
        // graph.addWeightedEdge(0, 1, 8);
        // graph.addWeightedEdge(1, 2, 1);
        // graph.addWeightedEdge(2, 0, 4);
        // graph.addWeightedEdge(3, 1, 2);
        // graph.addWeightedEdge(3, 2, 9);

        // System.out.println("Printing floyd warshall from source A: ");
        // graph.floydWarshall();

        // for Minimum spanning tree
        nodeList.add(new WeightedNode("A"));
        nodeList.add(new WeightedNode("B"));
        nodeList.add(new WeightedNode("C"));
        nodeList.add(new WeightedNode("D"));

        DisjointSet.makeSet(nodeList);
        WeightedNode firsNode = nodeList.get(0);
        WeightedNode secondNode = nodeList.get(1);
        DisjointSet output = DisjointSet.findSet(secondNode);
        output.printAllNodesOfSet();

        DisjointSet.union(firsNode, secondNode);
        output = DisjointSet.findSet(secondNode);
        output.printAllNodesOfSet();
    }
}
