package data_structures.examples.graph;

public class GraphNode {
    public String name;
    public int index;
    public boolean isVisited = false;

    public GraphNode(String name, int index) {
        this.name = name;
        this.index = index;
    }
}