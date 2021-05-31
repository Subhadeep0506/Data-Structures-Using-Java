package data_structures.examples.linkedlist;

public class EmployeeLinkedList {

    private EmployeeNode head;
    private  int size;

    public void addToFront(Employee employee){

        EmployeeNode node = new EmployeeNode(employee);
        node.setNext(head);
        head = node;
        size++;
    }

    public void addToEnd(Employee employee){
        EmployeeNode node = new EmployeeNode(employee);
        EmployeeNode current;
        current = head;
        while (current.getNext() != null) {
            current = current.getNext();
        }
        current.setNext(node);
    }

    public EmployeeNode removeFromFront(){

        if (isEmpty())
            return null;

        EmployeeNode removeNode = head;
        head = head.getNext();
        size--;
        removeNode.setNext(null);
        return removeNode;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return (head == null);
    }

    public void printList(){

        EmployeeNode current = head;
        System.out.print("HEAD -> ");
        while (current != null){
            System.out.print(current+ " -> ");
            current = current.getNext();
        }
        System.out.print("null");
    }

}
