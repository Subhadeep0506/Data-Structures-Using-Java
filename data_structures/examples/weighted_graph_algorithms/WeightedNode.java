package data_structures.examples.weighted_graph_algorithms;

import java.util.ArrayList;
import java.util.HashMap;

public class WeightedNode implements Comparable<WeightedNode> {
    public String name;
    public ArrayList<WeightedNode> neighbors = new ArrayList<>();

    public HashMap<WeightedNode, Integer> weightMap = new HashMap<>();

    public boolean isVisited = false;
    public WeightedNode parent;
    public int distance;
    public int index;
    public DisjointSet set;

    public WeightedNode(String name, int index) {
        this.name = name;
        distance = Integer.MAX_VALUE;
        this.index = index;
    }

    public WeightedNode(String name) {
        this.name = name;
        distance = Integer.MAX_VALUE;
    }

    @Override
    public String toString() {
        return name;
    }

    // comparable interface is used because priority queue will be used
    @Override
    public int compareTo(WeightedNode o) {  
        return this.distance - o.distance;
    }
}
