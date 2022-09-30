package Lab7;


public class Main {
    public static void main(String[]args){
        BinaryTree tree = new BinaryTree();
        tree.addLeaf(10,1);
        tree.addLeaf(3,1);
        tree.addLeaf(2,1);
        tree.addLeaf(4,1);
        tree.addLeaf(11,1);
        tree.addLeaf(14,1);
        tree.addLeaf(12,1);
        tree.BFSPRint();
    }
}

