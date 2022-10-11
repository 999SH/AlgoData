package Lab8;

public class Main {
    public static void main(String[] args){
        BinaryHeap heapTree = new BinaryHeap();
        heapTree.addLeaf(1);
        heapTree.addLeaf(2);
        heapTree.addLeaf(3);
        heapTree.addLeaf(4);
        heapTree.addLeaf(5);
        heapTree.addLeaf(6);
        heapTree.BFSPRint();
    }
}

