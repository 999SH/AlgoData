package Lab8;

public class TNode {
    int value;
    int heapSize;
    TNode leftPointer;
    TNode rightPointer;


    public TNode(int value){
        this.value = value;

        leftPointer = null;
        rightPointer = null;
    }
}
