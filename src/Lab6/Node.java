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
    public int getValue() {
        return value;
    }
    public void setValue(int value){
        this.value = value;
    }

    public void updateValue(int value){
        this.value += value;
    }
    public int getIndex() {
        return index;
    }

    public void setIndex(int index){
        this.index = index;
    }
    public Node getLeftPointer(){
        return leftPointer;
    }
    public Node getRightPointer(){
        return rightPointer;
    }

    public void setLeftPointer(Node leftPointer) {
        this.leftPointer = leftPointer;
    }
    public void setRightPointer(Node rightPointer){
        this.rightPointer = rightPointer;
    }

    public void moveRightNode(Node input){
        input = input.rightPointer;
    }

}
