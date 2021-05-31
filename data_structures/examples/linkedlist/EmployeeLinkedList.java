package data_structures.examples.linkedlist;

public class EmployeeLinkedList {

    private EmployeeNode head;

    public void addToFront(Employee employee){

        EmployeeNode node = new EmployeeNode(employee);
        node.setNext(head);
        head = node;
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
