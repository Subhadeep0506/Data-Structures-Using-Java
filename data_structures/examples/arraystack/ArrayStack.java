package data_structures.examples.arraystack;

import java.util.EmptyStackException;

public class ArrayStack {
    
    private Employee[] employeeStack;
    private int top;

    public ArrayStack(int capacity){
        employeeStack = new Employee[capacity];
    }

    //  checks if the stack is empty
    public boolean isEmpty(){
        return (top == 0);
    }

    //  checks if the stack is full
    public boolean isFull(){
        return (top == employeeStack.length);
    }
    
    public void push(Employee employee){
        /**
         *  If the stack is full, resize the backing array to double the size
         */
        if(isFull()){
            Employee[] newArray = new Employee[2 * employeeStack.length];
            // System.arraycopy(srcArray, srcPos, destisnationArray, destPos, length);
            System.arraycopy(employeeStack, 0, newArray, 0, employeeStack.length);
            employeeStack = newArray;
        }
        employeeStack[top++] = employee;
    }

    public Employee pop(){
        if (isEmpty()){
            System.out.println("Stack is empty");
            throw new EmptyStackException();
            // return null;
        }
        Employee employee = employeeStack[--top];
        employeeStack[top] = null;
        return employee;
    }

    public Employee peek(){
        if (isEmpty()){
            System.out.println("Stack is empty");
            throw new EmptyStackException();
        }

        return employeeStack[top - 1];
    }

    public int size(){
        return top;
    }

    public void printStack(){

        for (int i = top - 1; i >= 0; i--){
            System.out.println(employeeStack[i]);
        }
    }

}
