package data_structures.implementations.intergerlinkedlist;

public class Node {

    int data;

    Node(int data){
        this.data = data;
    }

    public int getData(){
        return this.data;
    }

    public void setData(int data){
        this.data = data;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                '}';
    }
}
