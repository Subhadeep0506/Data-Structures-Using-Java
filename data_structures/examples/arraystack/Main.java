package data_structures.examples.arraystack;

public class Main {

    public static void main(String[] args) {
        
        ArrayStack stack = new ArrayStack(10);

        stack.push(new Employee("firstName1", "lastName1", 2341));
        stack.push(new Employee("firstName2", "lastName2", 2323));
        stack.push(new Employee("firstName3", "lastName3", 2345));
        stack.push(new Employee("firstName4", "lastName4", 2314));

        stack.printStack();

        System.out.println("Popped: " + stack.pop());
        stack.printStack();
        System.out.println("top: " + stack.peek());
    }

}
