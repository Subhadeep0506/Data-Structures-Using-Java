package data_structures.examples.tree;

public class Main {
    public static void main(String[] args) {
        
        Tree intTree = new Tree();

        intTree.insert(25);
        intTree.insert(20);
        intTree.insert(15);
        intTree.insert(27);
        intTree.insert(30);
        intTree.insert(29);
        intTree.insert(26);
        intTree.insert(22);
        intTree.insert(32);

        intTree.traverse();
        // if (intTree.get(30) != null){
        //     System.out.println("Element exists");
        // }

        // System.out.println(intTree.get(27));
        
        // System.out.println("Min: " + intTree.min());
        // System.out.println("Max: " + intTree.max());

        intTree.delete(17);
        intTree.traverse();
    }
}