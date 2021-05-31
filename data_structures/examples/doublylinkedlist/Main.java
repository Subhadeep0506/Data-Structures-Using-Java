package data_structures.examples.doublylinkedlist;

public class Main {
    public static void main(String[] args) {

        Employee maryJane = new Employee("Mary", "Jane", 3452);
        Employee hartyPotter = new Employee("Harty", "Potter", 2413);
        Employee oliverHelden = new Employee("Oliver", "Helden", 4426);
        Employee mikeWilliams = new Employee("Mike", "Williams", 5234);

        EmployeeDoublyLinkedList list = new EmployeeDoublyLinkedList();

        list.addToFront(maryJane);
        list.addToFront(hartyPotter);
        list.addToFront(oliverHelden);
        list.addToFront(mikeWilliams);

        //System.out.println("Size of list: " + list.getSize());

        //list.printList();

        // System.out.println();

        // Employee billGates = new Employee("Bill", "Gates", 2351);

        // list.addToEnd(billGates);
        // list.printList();

        // System.out.println();
        // list.removeFromFront();
        // list.printList();

        System.out.println();
        list.removeFromEnd();
        list.printList();
    }
}
