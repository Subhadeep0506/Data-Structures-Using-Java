package data_structures.examples.tree;

public class TreeNode {
    
    int data;
    TreeNode leftChild, rightChild;

    public void insert(int value){

        // If value is equal to the data at present node, discard that value
        // As we are not accepting duplicates
        if(data == value)
            return;

        // if value is less than data in present node.
        if(value < data){

            // if left node is empty, then this is the insertion point
            if(leftChild == null){
                leftChild = new TreeNode(value);
            }
            // If left node is not empty, then we check the 
            // value with data in leftchild and insert it.
            else{
                leftChild.insert(value);
            }
        }

        // If value is greater than data at present node.
        else{
            
            if(rightChild == null){
                rightChild = new TreeNode(value);
            }
            else{
                rightChild.insert(value);
            }
        }    
    }

    //  Left->Root->Right
    public void traverseInOrder(){
        if(leftChild != null)
            leftChild.traverseInOrder();
        
        System.out.print(data + " ");

        if(rightChild != null)
            rightChild.traverseInOrder();       
    }

    //  Root->left->Right
    public void traversePreOrder(){
        System.out.print(data + " ");

        if(leftChild != null)
            leftChild.traversePreOrder();

        if(rightChild != null)
            rightChild.traversePreOrder();
    }

    //  Left->Right->Root
    public void traversePostOrder(){
        if(leftChild != null)
            leftChild.traversePostOrder();

        if(rightChild != null)
            rightChild.traversePostOrder();

        System.out.print(data + " ");        
    }

    public TreeNode get(int value){

        if(value == data){
            return this;
        }
        if(value < data){
            if(leftChild != null){
                return leftChild.get(value);
            }
        }
        else{
            if(rightChild != null){
                return rightChild.get(value);
            }
        }

        return null;
    }

    public int min(){
        if(leftChild == null){
            return data;
        }
        else{
            return leftChild.min();
        }
    }

    public int max(){
        if(rightChild == null){
            return data;
        }
        else{
            return rightChild.max();
        }
    }

    //  Getters and Setters
    public TreeNode(int data) {
        this.data = data;
    }

    public int getData() {
        return this.data;
    }

    public void setData(int data) {
        this.data = data;
    }

    public TreeNode getLeftChild() {
        return this.leftChild;
    }

    public void setLeftChild(TreeNode leftChild) {
        this.leftChild = leftChild;
    }

    public TreeNode getRightChild() {
        return this.rightChild;
    }

    public void setRightChild(TreeNode rightChild) {
        this.rightChild = rightChild;
    }
}