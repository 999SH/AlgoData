package Lab6;

import java.util.Iterator;
import java.util.Stack;

public class TreeIterator implements Iterator<Integer> {
    private Node next;
    private Stack<Node> stack;
    public TreeIterator() {
        this.stack = new Stack<Node>();
        this.stack.push(root);
        this.next = root.left;
    }
    @Override
    public boolean hasNext() {
        return this.next != null;
    }
    @Override
    public Integer next() {
        if(hasNext()) {
            this.stack.push(next);
            this.next = next.leftPointer;
        }

        if(next.rightPointer != null) System.out.println(next.rightPointer.value);
    }
    @Override
    public void remove() {
        throw new UnsupportedOperationException();
    }

}
