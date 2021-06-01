package data_structures.implementations.intergerlinkedlist;

public class IntegerNode {
    
    Node node;
    IntegerNode next;

    public IntegerNode(Node node){
        this.node = node;
    }

    public Node getNode(){
        return this.node;
    }

    public void setNode(Node node){
        this.node = node;
    }

    public IntegerNode getNext(){
        return next;
    }

    public void setNext(IntegerNode next){
        this.next = next;
    }

    public String toString(){
        return node.toString();
    }
}
