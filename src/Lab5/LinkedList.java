package Lab5;
public class LinkedList {
    int head;
    LinkedList tail;

    public LinkedList(int item, LinkedList list) {
        head = item;
        tail = list;
    }
    public int getHead() {
        return this.head;
    }
    public LinkedList getTail() {
        return this.tail;
    }

    public void append(LinkedList b) {
        LinkedList nextItem = this;
        while (nextItem.tail != null) {
            nextItem = nextItem.tail;
        }
        nextItem.tail = b;
    }
//add code
}

