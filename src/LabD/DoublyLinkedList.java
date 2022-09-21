package LabD;

import Lab5.Node;

public class DoublyLinkedList {
    DLLNode head;
    DLLNode tail;
    int DLLlength = 0;

    public void addDLLNode(int value) {
        DLLNode node = new DLLNode();
        node.value = value;
        node.pointer = null;
        node.previousPointer = null;

        if (head == null) {
            head = node;
        } else {
            DLLNode travel = head;
            while (travel.pointer != null) {
                travel = travel.pointer;
            }
            travel.pointer = node;
            node.previousPointer = travel;
        }
        tail = node;
        DLLlength++;
    }

    public DLLNode getHead() {
        return head;
    }

    public DLLNode getTail() {
        return tail;
    }

    public void removeDLLNode(int index) {
        if (index < DLLlength / 2) {
            DLLNode node = head;
            int i = 0;
            DLLNode saveDLLNode = null;
            DLLNode prevDLLNode = null;
            while (node.pointer != null && i++ < index) {
                node = node.pointer;
                if (node.pointer == null && i != index) {
                    System.out.println("Index is empty");
                }
                if (i == index) {
                    saveDLLNode = node.pointer;
                    prevDLLNode = node.previousPointer;
                    node = node.pointer;
                    node.previousPointer = prevDLLNode;
                }
            }
            DLLlength--;
        }
        else {
            DLLNode node = tail;
            int i = DLLlength;
            DLLNode saveDLLNode = null;
            DLLNode prevDLLNode = null;
            while (node.pointer != null && i-- > index) {
                node = node.previousPointer;
                if (i == index) {
                    saveDLLNode = node.pointer;
                    prevDLLNode = node.previousPointer;
                    node = node.pointer;
                    node.previousPointer = prevDLLNode;
                }
            }
            DLLlength--;
        }
    }

    public void addDLLend(int value) {
        DLLNode node = new DLLNode();
        node.value = value;
        node.pointer = null;
        node.previousPointer = tail;
        tail.pointer = node;
        tail = node;
    }

    public int getValue(int index) {
        DLLNode node = head;
        int i = 0;
        while (node.pointer != null && i++ < index) {
            node = node.pointer;
            if (node.pointer == null && i != index) {
                System.out.println("Index is empty");
            }
        }
        return node.value;
    }

    public void addList(DoublyLinkedList list, DoublyLinkedList append) {
        DLLNode travel = null;
        DLLNode appendednode = null;
        travel = list.getTail();
        appendednode = append.getHead();

        travel.pointer = appendednode;
        while (appendednode.pointer != null) {
            appendednode = appendednode.pointer;
        }

    }
}
