package data_structures.implementations.jdklinkedlist;

import java.util.Iterator;
import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        
        Employee maryJane = new Employee("Mary", "Jane", 3452);
        Employee hartyPotter = new Employee("Harty", "Potter", 2413);
        Employee oliverHelden = new Employee("Oliver", "Helden", 4426);
        Employee mikeWilliams = new Employee("Mike", "Williams", 5234);

        //-----------------------------Adding Items------------------------------
        LinkedList<Employee> list = new LinkedList<>();
        list.addFirst(maryJane);
        list.addFirst(hartyPotter);
        list.addFirst(oliverHelden);
        list.addFirst(mikeWilliams);

        //LinkedList doesn't have a print list method...but using Iterator we can print them
        printList(list);

        //As an workaround, we could also use forEach loop to iterate through the list
        // for(Employee employee : list){
        //     System.out.println(employee);
        // }

        //The add() method adds items to the end of the list
        list.add(new Employee("Bill", "Matters", 3452));
        printList(list);

        //The addLast() method does the same thing as add() method
        // list.addLast(new Employee("firstName", "lastName", 2341));
        //-----------------------------------------------------------------------

        //-----------------------------Removing Items----------------------------

        //Removing from first
        list.removeFirst();
        printList(list);

        //Removing from last
        list.removeLast();
        printList(list);
        //remove() method removes item from front of the list
        
    }
    
    /*
    *------------Function to print list using Iterator---------------------
    */
    public static void printList(LinkedList<Employee> list){
        Iterator<Employee> itor = list.iterator();
        System.out.println("HEAD ->");
        while(itor.hasNext()){
            System.out.print(itor.next() + " <=> ");
        }
        System.out.println("null");
    }
}
