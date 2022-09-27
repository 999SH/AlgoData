package Lab6;

public class Main {
    public static void main (String [] args){
        BinaryTree Tree = new BinaryTree();
        Tree.addLeaf(5,10);
        Tree.addLeaf(2,9);
        Tree.addLeaf(3,8);
        Tree.addLeaf(8,7);
        Tree.addLeaf(9,9);
        Tree.printTree();
    }
}
