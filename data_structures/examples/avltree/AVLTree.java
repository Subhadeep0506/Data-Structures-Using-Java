package data_structures.examples.avltree;

import java.util.LinkedList;
import java.util.Queue;

public class AVLTree {
    BinaryNode root;

    public AVLTree() {
        root = null;
    }

    //  prints the entire tree by Preorder Traversal 
    public void preOrderTraversal(BinaryNode root) {
        if (root == null)
            return;

        System.out.print(root.data + " ");
        preOrderTraversal(root.leftChild);
        preOrderTraversal(root.rightChild);
    }

    //  Inorder Traversal
    public void inOrderTraversal(BinaryNode root) {
        if (root == null)
            return;

        preOrderTraversal(root.leftChild);
        System.out.print(root.data + " ");
        preOrderTraversal(root.rightChild);
    }

    //  Postorder Traversal
    public void postOrderTraversal(BinaryNode root) {
        if (root == null)
            return;

        preOrderTraversal(root.leftChild);
        preOrderTraversal(root.rightChild);
        System.out.print(root.data + " ");
    }

    // Level-order Traversal
    public void levelOrderTraversal() {
        Queue<BinaryNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            BinaryNode presentNode = queue.remove();
            System.out.print(presentNode.data + " ");
            if (presentNode.leftChild != null)
                queue.add(presentNode.leftChild);
            if (presentNode.rightChild != null)
                queue.add(presentNode.rightChild);
        }
    }
    
    //  searching for data in AVL Tree
    public BinaryNode search(BinaryNode root, int data) {
        if (root == null) {
            System.out.println("Could not find data");
            return null;
        } else if (data == root.data) {
            System.out.println("Found data");
            return root;
        } else if (data < root.data) {
            return search(root.leftChild, data);
        } else {
            return search(root.rightChild, data);
        }
    }
    
    //  returns the height of Binary Node
    public int getHeight(BinaryNode node) {

        // return node == null ? 0 : node.height;
        if (node == null)
            return 0;
        else    
            return node.height;
    }

    //  right rotation
    private BinaryNode rotateRight(BinaryNode disbalancedRoot) {
        BinaryNode newRoot = disbalancedRoot.leftChild;
        disbalancedRoot.leftChild = disbalancedRoot.leftChild.rightChild;
        newRoot.rightChild = disbalancedRoot;
        //  update height of newRoot and disbalancedRoot
        //  we increment the height of maximum height among left and right child
        disbalancedRoot.height = 1
                + Math.max(getHeight(disbalancedRoot.leftChild), getHeight(disbalancedRoot.rightChild));
        newRoot.height = 1 + Math.max(getHeight(newRoot.leftChild), getHeight(newRoot.rightChild));
        return newRoot;
    }

    //  left rotation
    private BinaryNode rotateLeft(BinaryNode disbalancedRoot) {
        BinaryNode newRoot = disbalancedRoot.rightChild;
        disbalancedRoot.rightChild = disbalancedRoot.rightChild.leftChild;
        newRoot.leftChild = disbalancedRoot;
        disbalancedRoot.height = 1
                + Math.max(getHeight(disbalancedRoot.leftChild), getHeight(disbalancedRoot.rightChild));
        newRoot.height = 1 + Math.max(getHeight(newRoot.leftChild), getHeight(newRoot.rightChild));
        return newRoot;
    }

    //  get balance from the node
    public int getBalance(BinaryNode node) {
        if (node == null)
            return 0;
        return getHeight(node.leftChild) - getHeight(node.rightChild);
    }
    
    //  insert node function
    private BinaryNode insertNode(BinaryNode node, int data) {
        if (node == null) {
            BinaryNode newNode = new BinaryNode();
            newNode.data = data;
            newNode.height = 1;
            return newNode;
        } else if (data < node.data) {
            node.leftChild = insertNode(node.leftChild, data);
        } else if (data > node.data) {
            node.rightChild = insertNode(node.rightChild, data);
        }
        node.height = 1 + Math.max(getHeight(node.leftChild), getHeight(node.rightChild));
        int balance = getBalance(node);

        // left-left condition(right rotation)
        if (balance > 1 && data < node.leftChild.data) {
            return rotateRight(node);
        }
        // left-right condition
        if (balance > 1 && data > node.leftChild.data) {
            node.leftChild = rotateLeft(node.leftChild);
            return rotateRight(node);
        }
        // right-right condition
        if (balance < -1 && data > node.rightChild.data) {
            return rotateLeft(node);
        }
        // right-left condition
        if (balance < -1 &&  data < node.rightChild.data) {
            node.rightChild = rotateRight(node.rightChild);
            return rotateLeft(node);
        }
        return node;
    }
    
    //  public method to implement insertion
    public void insert(int data) {
        root = insertNode(root, data);
    }
}