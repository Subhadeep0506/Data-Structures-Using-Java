package data_structures.examples.graph_adjacency_matrix;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

public class Graph {
    ArrayList<GraphNode> nodeList = new ArrayList<>();
    int[][] adjacencyMatrix;

    public Graph(ArrayList<GraphNode> nodeList) {
        this.nodeList = nodeList;
        adjacencyMatrix = new int[nodeList.size()][nodeList.size()];
    }

    // calling this function creates a link between 1st node and 2nd node
    public void addUndirectedEdge(int i /*index of 1st node*/, int j /*index of 2nd node*/) {
        // since edges are undirected, if one node has connection with another node, 
        // then that node has return connection with the first node
        adjacencyMatrix[i][j] = 1;
        adjacencyMatrix[j][i] = 1;
    }
    
    public void addDirectedEdge(int i, int j) {
        adjacencyMatrix[i][j] = 1;
    }

    // prints the adjacency matrix
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("  ");
        for (int i = 0; i < nodeList.size(); i++) {
            sb.append(nodeList.get(i).name + " ");
        }
        sb.append("\n");
        for (int i = 0; i < nodeList.size(); i++) {
            sb.append(nodeList.get(i).name + " ");
            for (int j : adjacencyMatrix[i]) {
                sb.append(j + " ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }

    // get neighbors
    public ArrayList<GraphNode> getNeighbors(GraphNode node) {
        ArrayList<GraphNode> neighbors = new ArrayList<>();
        int nodeIndex = node.index;
        for (int i = 0; i < adjacencyMatrix.length; i++) {
            if (adjacencyMatrix[nodeIndex][i] == 1)
                neighbors.add(nodeList.get(i));
        }

        return neighbors;
    }

    // BFS internal
    private void bfsVisit(GraphNode node) {
        LinkedList<GraphNode> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            GraphNode currentNode = queue.remove(0);
            currentNode.isVisited = true;
            System.out.print(currentNode.name + " ");
            ArrayList<GraphNode> neighbors = getNeighbors(currentNode);
            for (GraphNode neighbor : neighbors) {
                if (!neighbor.isVisited) {
                    queue.add(neighbor);
                    neighbor.isVisited = true;
                }
            }
        }
    }

    // callable bfs method
    public void bfs() {
        for (GraphNode node : nodeList) {
            if (!node.isVisited)
                bfsVisit(node);
        }
        setAllNotVisited();
    }

    // dfs internal method
    private void dfsVisit(GraphNode node) {
        Stack<GraphNode> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            GraphNode currentNode = stack.pop();
            currentNode.isVisited = true;
            System.out.print(currentNode.name + " ");
            ArrayList<GraphNode> neighbors = getNeighbors(node);
            for (GraphNode neighbor : neighbors) {
                if (!neighbor.isVisited) {
                    stack.push(neighbor);
                    neighbor.isVisited = true;
                }
            }
        }
    }

    // callable dfs method
    public void dfs() {
        for (GraphNode node : nodeList) {
            if (!node.isVisited)
                dfsVisit(node);
        }
        setAllNotVisited();
    }

    // sets all node to unvisited
    private void setAllNotVisited() {
        for (GraphNode node : nodeList) {
            node.isVisited = false;
        }
    }

    // Topological Sort helper method
    private void topologicalVisit(GraphNode node, Stack<GraphNode> stack) {
        ArrayList<GraphNode> neighbors = getNeighbors(node);
        for (GraphNode neighbor : neighbors) {
            if (!neighbor.isVisited)
                topologicalVisit(neighbor, stack);
        }
        node.isVisited = true;
        stack.push(node);
    }

    // callable topological sort method
    public void topologicalSort() {
        Stack<GraphNode> stack = new Stack<>();
        for (GraphNode node : nodeList) {
            if (!node.isVisited) {
                topologicalVisit(node, stack);
            }
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop().name + " ");
        }
    }
}
