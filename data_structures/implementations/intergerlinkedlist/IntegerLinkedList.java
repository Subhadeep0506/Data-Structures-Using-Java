package data_structures.implementations.intergerlinkedlist;

public class IntegerLinkedList {
    
    private IntegerNode head;
    private int size;

    public boolean isEmpty(){
        return (head == null);
    }

    public void insertSorted(Node newNode){
        
        IntegerNode node = new IntegerNode(newNode);

        if(isEmpty() || newNode.data >= head.getNode().data){
            node.setNext(head);
            head = node;
            size++;
            return;
        }

        IntegerNode current = head;
        while ( current.getNext() != null && current.getNext().getNode().data >= newNode.data ){
            current = current.getNext();
        }
        
        if(current.getNext() == null){
            current.setNext(node);
        }
        else{
            node.setNext(current.getNext());
            current.setNext(node);
        }
        size++;
    }

    public int size() {
        return size;
    }

    //  Removes the first node
    public IntegerNode remove(){

        if(head == null){
            return null;
        }

        IntegerNode removeNode = head;
        head = head.getNext();
        removeNode.setNext(null);
        return removeNode;
    }

    public void printList(){

        IntegerNode current = head;
        System.out.print("HEAD -> ");
        while(current != null) {
            System.out.print(current+ " -> ");
            current = current.getNext();
        }
        System.out.print("null");
    }
}
