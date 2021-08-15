package data_structures.examples.graph_adjacency_list;

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

        Graph graph = new Graph(nodeList);
        // graph.addUndirectedEdge(0, 1);
        // graph.addUndirectedEdge(0, 2);
        // graph.addUndirectedEdge(0, 3);
        // graph.addUndirectedEdge(1, 4);
        // graph.addUndirectedEdge(2, 3);
        // graph.addUndirectedEdge(3, 4);
        // System.out.println(graph.toString());

        // System.out.print("BFS: ");
        // graph.bfs();
        // System.out.println();
        // System.out.print("DFS: ");
        // graph.dfs();

        graph.addDirectedEdge(0, 2);
        graph.addDirectedEdge(2, 4);
        graph.addDirectedEdge(4, 7);
        graph.addDirectedEdge(4, 5);
        graph.addDirectedEdge(5, 6);
        graph.addDirectedEdge(1, 2);
        graph.addDirectedEdge(1, 3);
        graph.addDirectedEdge(3, 5);

        System.out.print(graph.toString());
        graph.topologicalSort();
    }
}
