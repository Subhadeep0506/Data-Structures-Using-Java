package data_structures.implementations.priorityqueue;

import java.util.PriorityQueue;

public class Main {
    
    public static void main(String[] args) {
        
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        priorityQueue.add(25);
        priorityQueue.add(-22);
        priorityQueue.add(1343);
        priorityQueue.add(54);
        priorityQueue.add(0);
        priorityQueue.add(-3492);
        priorityQueue.add(429);

        //System.out.println("Peeking: " + priorityQueue.peek());
        //  remove() method removes the smallest number in the priority queue
        //  and returns it.
        //System.out.println("Removed: " + priorityQueue.remove());
        //System.out.println("Peeking: " + priorityQueue.peek());
        //  poll() does same task as remove. the only difference it makes from
        //  remove() is that it returns null if the PriorityQueue is empty
        //  whereas remove() throws an exception if queue is empty.
        //System.out.println("Polled: " + priorityQueue.poll());
        //System.out.println("Peeking: " + priorityQueue.peek());
        //System.out.println("Remove 54: " + priorityQueue.remove(54));

        Object[] ints = priorityQueue.toArray();
        for (Object object : ints) {
            System.out.print(object + " ");
        }
    }
}
