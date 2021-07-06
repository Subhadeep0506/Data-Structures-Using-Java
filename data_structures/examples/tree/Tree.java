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
            // System.out.print("Preorder: ");
            // root.traversePreOrder();
            System.out.println();

            System.out.print("Inorder: ");
            root.traverseInOrder();
            
            System.out.println();
            // System.out.print("Postorder: ");
            // root.traversePostOrder();
        }
    }

    public TreeNode get(int value){
        if(root != null){
            return root.get(value);
        }
        return null;
    }

    public int min(){
        if(root == null){
            System.out.println("Tree is empty");
            return 0;
        }
        else{
            return root.min();
        }
    }

    public int max(){
        if(root == null){
            System.out.println("Tree is empty");
            return 0;
        }
        else{
            return root.max();
        }
    }

    public void delete(int value){
        root = delete(root, value);
    }

    private TreeNode delete(TreeNode subTreeRoot, int value) {
        
        if(subTreeRoot == null){
            return subTreeRoot;
        }

        if(value < subTreeRoot.getData()){
            subTreeRoot.setLeftChild(delete(subTreeRoot.getLeftChild(), value));
        }
        else if(value > subTreeRoot.getData()){
            subTreeRoot.setRightChild(delete(subTreeRoot.getRightChild(), value));
        }
        else{

            //  Case 1 and 2.
            if(subTreeRoot.getLeftChild() == null){
                return subTreeRoot.getRightChild();
            }
            else if(subTreeRoot.getRightChild() == null){
                return subTreeRoot.getLeftChild();
            }
            //  Case: 3, when Node has 2 children
            //  Replace RootNode with the min value in the right subtree ...
            subTreeRoot.setData(subTreeRoot.getRightChild().min());
            //  ...and delete the node in the right subtree
            subTreeRoot.setRightChild(delete(subTreeRoot.getRightChild(), subTreeRoot.getData()));
        }
        return subTreeRoot;
    }
}