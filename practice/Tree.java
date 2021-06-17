package practice;

class Node {
    
    int data;
    Node leftChild, rightChild;

    Node(int data){
        this.data = data;
    }
}

public class Tree{

    Node root = null;
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

        intTree.traverseInOrder(intTree.root);
    }

    public void insert(int value){
        root = insertNode(root, value);
    }

    public Node insertNode(Node root, int value){
        if(root == null){
            root = new Node(value);
            return root;
        }

        if(value < root.data){
            root.leftChild = insertNode(root.leftChild, value);
        } 
        else if (value > root.data){
            root.rightChild = insertNode(root.rightChild, value);
        } 
        else{
            return null;
        }
        return root;
    }

    public void traverseInOrder(Node root){
        if(root == null){
            System.out.println("Tree is empty");
            return;
        }
        if(root.leftChild != null){
            traverseInOrder(root.leftChild);
        }
        System.out.print(root.data + " ");

        if(root.rightChild != null){
            traverseInOrder(root.rightChild);
        }       
    }
}
