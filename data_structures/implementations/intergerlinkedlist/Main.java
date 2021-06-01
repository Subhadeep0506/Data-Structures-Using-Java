package data_structures.implementations.intergerlinkedlist;

public class Main{

    public static void main(String[] args) {
        Node one = new Node(14);
        Node two = new Node(12);
        Node three = new Node(-13);
        Node four = new Node(13);

        IntegerLinkedList list = new IntegerLinkedList();

        list.insertSorted(one);
        list.insertSorted(two);
        list.insertSorted(three);
        list.insertSorted(four);
        list.insertSorted(new Node(0));
        list.insertSorted(new Node(10));

        list.printList();
    }

}