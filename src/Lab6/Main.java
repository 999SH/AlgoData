package Lab6;

public class Main {
    public static void main (String [] args){
        BinaryTree Tree = new BinaryTree();
        Tree.addLeaf(1,10);
        Tree.addLeaf(2,9);
        Tree.addLeaf(3,8);
        Tree.addLeaf(4,7);
        Tree.addLeaf(2,9);
        Tree.printTree();
    }
}
