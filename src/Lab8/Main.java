package Lab8;

public class Main {
    public static void main(String[] args){
        BinaryHeap heapTree = new BinaryHeap();
        heapTree.addLeaf(2);
        heapTree.addLeaf(1);
        heapTree.addLeaf(3);
        heapTree.addLeaf(0);
        heapTree.addLeaf(4);
        heapTree.addLeaf(5);
        heapTree.addLeaf(6);
        heapTree.addLeaf(8);
        heapTree.BFSPRint();


        ArrayHeap heapArray = new ArrayHeap();
        heapArray.add(2);
        heapArray.add(1);
        heapArray.add(3);
        heapArray.add(0);
        heapArray.add(4);
        heapArray.add(5);
        heapArray.add(6);
        heapArray.add(8);
        heapArray.arrayprint();
    }
}

