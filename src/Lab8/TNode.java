package Lab8;

public class TNode {
    int value;
    int depth;
    TNode leftPointer;
    TNode rightPointer;

    public TNode(int value){
        this.value = value;

        leftPointer = null;
        rightPointer = null;
    }
}
