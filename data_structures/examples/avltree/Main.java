package data_structures.examples.avltree;

public class Main {
    public static void main(String[] args) {
        AVLTree newTree = new AVLTree();

        newTree.insert(5);
        newTree.insert(10);
        newTree.insert(15);
        newTree.insert(20);
        
        newTree.levelOrderTraversal();
    }
}
