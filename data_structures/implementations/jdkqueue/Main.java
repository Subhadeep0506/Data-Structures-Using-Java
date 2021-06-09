package data_structures.implementations.jdkqueue;

import java.util.ArrayDeque;
import java.util.Queue;

public class Main {
    public static void main(String[] args) {
        
        Queue<String> queue = new ArrayDeque<String>();

        queue.add("name1");
        queue.add("name2");
        queue.add("name3");
        queue.add("name4");
        queue.add("name5");
        queue.add("name6");

        queue.remove();

        for (String string : queue) {
            System.out.println(string);
        }

        System.out.println("Peek: " + queue.peek());
    }
}
