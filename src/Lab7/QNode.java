package Lab7;

public class QNode {
    TNode tNode;
    QNode pointer;
    public QNode(TNode tnode) {
        this.tNode = tnode;
        this.pointer = null;
    }
}
