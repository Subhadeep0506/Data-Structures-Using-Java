package data_structures.examples.graph_adjacency_list;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

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

    public void addDirectedEdge(int i, int j) {
        GraphNode firstNode = nodeList.get(i);
        GraphNode secondNode = nodeList.get(j);
        firstNode.neighbors.add(secondNode);
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

    // BFS internal method
    private void bfsVisit(GraphNode node) {
        LinkedList<GraphNode> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            GraphNode currentNode = queue.remove();
            currentNode.isVisited = true;
            System.out.print(currentNode.name + " ");
            for (GraphNode neighbor : currentNode.neighbors) {
                if (!neighbor.isVisited) {
                    queue.add(neighbor);
                    neighbor.isVisited = true;
                }
            }
        }
    }

    // callable BFS method
    public void bfs() {
        for (GraphNode node : nodeList) {
            if (!node.isVisited) {
                bfsVisit(node);
            }
        }
        setAllNotVisited();
    }
    
    // DFS internal method
    private void dfsVisit(GraphNode node) {
        Stack<GraphNode> stack = new Stack<>();
        stack.push(node);
        while (!stack.isEmpty()) {
            GraphNode currentNode = stack.pop();
            currentNode.isVisited = true;
            System.out.print(currentNode.name + " ");
            for (GraphNode neighbor : currentNode.neighbors) {
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

    // after traversal, all nodes are set to visited.
    // this method makes them un visited
    private void setAllNotVisited() {
        for (GraphNode node : nodeList) {
            node.isVisited = false;
        }
    }

    // helper method for topological sort
    private void topologicalVisit(GraphNode node, Stack<GraphNode> stack) {
        for (GraphNode neighbor : node.neighbors) {
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
            if (!node.isVisited)
                topologicalVisit(node, stack);
        }

        while (!stack.isEmpty()) {
            System.out.print(stack.pop().name + " ");
        }
    }
}
