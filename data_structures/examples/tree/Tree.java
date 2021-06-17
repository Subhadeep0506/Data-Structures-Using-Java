package data_structures.examples.tree;

public class Tree {
    
    private TreeNode root;

    public void insert(int value){

        //  If root of the tree is empty (i.e. while inserting the first element into the tree)
        if(root == null)
            root = new TreeNode(value);

        //  If root is not empty...
        else{
            //  ...then insert the value into the tree.
            root.insert(value);
        }
    }

    public void traverse(){
        if(root != null){
            System.out.print("Preorder: ");
            root.traversePreOrder();
            System.out.println();
            System.out.print("Inorder: ");
            root.traverseInOrder();
            System.out.println();
            System.out.print("Postorder: ");
            root.traversePostOrder();
        }
    }
}
