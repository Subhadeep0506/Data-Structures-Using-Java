package data_structures.examples.linkedlist;

public class Main {

    public static void main(String[] args) {

        Employee maryJane = new Employee("Mary", "Jane", 3452);
        Employee hartyPotter = new Employee("Harty", "Potter", 2413);
        Employee oliverHelden = new Employee("Oliver", "Helden", 4426);
        Employee mikeWilliams = new Employee("Mike", "Williams", 5234);

        EmployeeLinkedList list = new EmployeeLinkedList();

        System.out.println("isEmpty(): " + list.isEmpty());

        list.addToFront(maryJane);
        list.addToFront(hartyPotter);
        list.addToFront(oliverHelden);
        list.addToFront(mikeWilliams);

        System.out.println("isEmpty(): " + list.isEmpty());
        list.addToEnd(new Employee("My", "Self", 3423));

        System.out.println("Size of list: " + list.getSize());

        list.printList();
        System.out.println();
        list.removeFromFront();
        System.out.println("Size of list: " + list.getSize());
        list.printList();

    }
}
