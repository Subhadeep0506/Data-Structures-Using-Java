package data_structures.examples.doublylinkedlist;

public class EmployeeDoublyLinkedList {

    private EmployeeNode tail;
    private EmployeeNode head;
    private int size;

    public void addToFront(Employee employee){

        EmployeeNode node = new EmployeeNode(employee);

        if(head == null)
            tail = node;
        else{
            head.setPrevious(node);
            node.setNext(head);
        }

        head = node;
        size++;
    }

    public void addToEnd(Employee employee){
        EmployeeNode node = new EmployeeNode(employee);
        if(tail == null)
            head = node;
        else{
            tail.setNext(node);
            node.setPrevious(tail);
        }  
        tail = node;
        size++;
    }

    public EmployeeNode removeFromFront(){

        if (isEmpty())
            return null;

        EmployeeNode removeNode = head;

        if(head.getNext() == null){
            tail = null;
        }
        else{
            head.getNext().setPrevious(null);
        }

        head = head.getNext();
        size--;
        removeNode.setNext(null);
        return removeNode;
    }

    public EmployeeNode removeFromEnd(){
        if(isEmpty())
            return null;

        EmployeeNode removeNode = tail;

        if(tail.getPrevious() == null)
            head = null;
        else{
            tail.getPrevious().setNext(null);
        } 
        tail = tail.getPrevious();
        size--;
        removeNode.setPrevious(null);
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
            System.out.print(current+ " <=> ");
            current = current.getNext();
        }
        System.out.print("null");
    }

    public void addBefore(Employee newEmployee, Employee targetEmployee){

        EmployeeNode node = new EmployeeNode(newEmployee);

        if (isEmpty())
            return;
        else {
            EmployeeNode current = head;
            while (current != null) {
                //if element is found, stop
                if(current.getEmployee() == targetEmployee)
                    break;
                current = current.getNext();
            }
            //if reached end of list, exit
            if(current == null)
                return;
            else {
                node.setNext(current);
                node.setPrevious(current.getPrevious());
                current.setPrevious(node);

                if(current == head){
                    head = node;
                }
                else {
                    node.getPrevious().setNext(node);
                }
                size++;
            }
        }
    }
}
