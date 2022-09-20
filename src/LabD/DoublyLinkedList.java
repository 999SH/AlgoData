package LabD;

import Lab5.Node;

public class DoublyLinkedList {
    DLLNode head;
    DLLNode tail;

    public void addDLLNode(int value) {
        DLLNode node = new DLLNode();
        node.value = value;
        node.pointer = null;
        node.previousPointer = null;

        if (head == null) {
            head = node;
        }
        else {
            DLLNode travel = head;
            while (travel.pointer != null) {
                travel = travel.pointer;
            }
            travel.pointer = node;
            node.previousPointer = travel;
        }
        tail = node;
    }
    public DLLNode getHead() {
        return head;
    }

    public DLLNode getTail() {
        return tail;
    }

    public DLLNode removeDLLNode(int index){
        DLLNode node = head;
        int i = 0;
        DLLNode saveDLLNode = null;
        DLLNode prevDLLNode = null;
        while (node.pointer != null && i++ < index) {
            node = node.pointer;
            if (node.pointer == null && i != index) {
                System.out.println("Index is empty");
            }
            if (i == index){
                saveDLLNode = node.pointer;
                prevDLLNode = node.previousPointer;
                node = node.pointer;
                node.previousPointer = prevDLLNode;
            }
        }
        return saveDLLNode;
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
