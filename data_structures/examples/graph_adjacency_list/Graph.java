package data_structures.examples.graph_adjacency_list;

import java.util.ArrayList;

public class Graph {
    
    ArrayList<GraphNode> nodeList = new ArrayList<>();

    public Graph(ArrayList<GraphNode> nodeList) {
        this.nodeList = nodeList;
    }

    public void addUndirectedEdge(int i/*index of 1st node*/, int j/*index of 2nd node*/) {
        GraphNode firstNode = nodeList.get(i);
        GraphNode secondNode = nodeList.get(j);
        // making 1st node the neighbor of 2nd node
        // and 2nd node the neighbor of 1st node
        firstNode.neighbors.add(secondNode);
        secondNode.neighbors.add(firstNode);
    }
    
    // To print the graph
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < nodeList.size(); i++) {
            sb.append(nodeList.get(i).name + ": ");
            for (int j = 0; j < nodeList.get(i).neighbors.size(); j++) {
                if (j == nodeList.get(i).neighbors.size() - 1)
                    sb.append(nodeList.get(i).neighbors.get(j).name);
                else
                    sb.append(nodeList.get(i).neighbors.get(j).name + " -> ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}
