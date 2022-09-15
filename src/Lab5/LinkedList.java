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
        } else {
            Node travel = head;
            while (travel.pointer != null) {
                travel = travel.pointer;
            }
            travel.pointer = node;
        }
    }

    public void addNodeTest(int value){
        Node node = new Node();
        node.value = value;
        node.pointer = null;
        if (head == null) {
            head = node;
        } else {
            getTail().pointer = node;
        }

    }

    public void removeNode(LinkedList list){
        Node n;
        getTail() = n.
    }

    public void printList() {
        Node node = head;
        while (node.pointer != null) {
            System.out.println(node.value);
            node = node.pointer;
        }


    }

    public Node getHead() {
        return head;
    }

    public Node getTail() {
        Node travel = head;
        while (travel.pointer != null) {
            travel = travel.pointer;
        }
        return travel;
    }

    public Node setTail(LinkedList list, Node node) {
        Node travel = head;
        while (travel.pointer != null) {
            travel = travel.pointer;
        }
        return travel;
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

    public int getValueNode(Node n){
        return n.value;
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

    public void addNodeWithPointer(Node input){
            if (head == null) {
                head = input;
            }
            else {
                Node travel = head;
                while (travel.pointer != null) {
                    travel = travel.pointer;
                }
                travel.pointer = input;
            }
    }
}
