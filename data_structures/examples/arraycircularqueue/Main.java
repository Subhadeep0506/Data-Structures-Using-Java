package data_structures.examples.arraycircularqueue;

public class Main {
    
    public static void main(String[] args) {
        
        ArrayQueue queue = new ArrayQueue(10);

        queue.add(new Employee("firstName1", "lastName1", 2341));
        queue.add(new Employee("firstName2", "lastName2", 2323));
        queue.remove();
        queue.add(new Employee("firstName3", "lastName3", 2345));
        queue.remove();
        queue.add(new Employee("firstName4", "lastName4", 2314));
        queue.remove();
        queue.add(new Employee("firstName5", "lastName5", 2315));

        queue.printQueue();

        // queue.remove();

        // queue.printQueue();
    }

}
