package Lab6;

public class Node {
    int index;
    int value;

    Node leftPointer;
    Node rightPointer;

    public Node(int index, int value){
        this.index = index;
        this.value = value;

        leftPointer = null;
        rightPointer = null;
    }
    public int getValue(Node node) {
        return node.value;
    }
}
