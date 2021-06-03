package data_structures.examples.linkedliststack;

import java.util.LinkedList;
import java.util.ListIterator;

public class LinkedStack {

    /* Making the LinkedList private doesn't allow others
    *  to call other linkedlist methods. Only those methods
    *  can be called which are specified in this class.
    */
    private LinkedList<Employee> stack;

    public LinkedStack() {
        stack = new LinkedList<Employee>();
    }

    public void push(Employee employee){
        stack.push(employee);
    }

    public Employee pop(){
        return stack.pop();
    }

    public Employee peek(){
        return stack.peek();
    }

    public boolean isEmpty(){
        return stack.isEmpty();
    }

    public void printStack(){

        ListIterator<Employee> iterator = stack.listIterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
    }
}
