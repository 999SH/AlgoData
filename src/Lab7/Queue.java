package Lab7;
public class Queue {
    QNode head;
    QNode tail;

    public Queue() {
        this.head = this.tail = null;
    }

    public void add(TNode tNode) {
        QNode q = new QNode(tNode);
        if (this.tail == null) {
            this.head = this.tail = q;
        }
        this.tail.pointer = q;
        this.tail = q;
    }

    public boolean isEmpty() {
        return (tail == null);
    }

    public QNode remove() {
        if (this.isEmpty()) {
            return null;
        }
        this.head = this.head.pointer;
        if (head == null){
            tail = null;
        }
        return head;
    }
}