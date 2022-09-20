package Lab5;

public class LinkedList {
    Node head;
    Node tail;

    public void addNode(int value) {
        Node node = new Node();
        node.value = value;
        node.pointer = null;

        if (head == null) {
            head = node;
        }
        else {
            Node travel = head;
            while (travel.pointer != null) {
                travel = travel.pointer;
            }
            travel.pointer = node;
        }
        tail = node;
    }

    public Node removeNode(int index){
        Node node = head;
        int i = 0;
        Node saveNode = null;
        while (node.pointer != null && i++ < index) {
            node = node.pointer;

            if (node.pointer == null && i != index) {
                System.out.println("Index is empty");
            }
            if (i == index-1){
                saveNode = node.pointer;
                node.pointer = node.pointer.pointer;
            }
        }
        return saveNode;
    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        return tail;
    }

    public int getValue(int index) {
        Node node = head;
        int i = 0;
        while (node.pointer != null && i++ < index) {
            node = node.pointer;
            if (node.pointer == null && i != index) {
                System.out.println("Index is empty");
            }
        }
        return node.value;
    }

    public void addList(LinkedList list, LinkedList append) {
        Node travel = null;
        Node appendednode = null;
        travel = list.getTail();
        appendednode = append.getHead();

        travel.pointer = appendednode;
        while (appendednode.pointer != null) {
            appendednode = appendednode.pointer;
        }
    }
}
