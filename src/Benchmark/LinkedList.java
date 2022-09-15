package Benchmark;

public class LinkedList {
    Node head;

    public void addNode(int value){
        Node node = new Node();
        node.value = value;
        node.pointer = null;

        if (head == null){
            head = node;
        }
        else {
            Node travel = head;
            while (travel.pointer != null){
                travel = travel.pointer;
            }
            travel.pointer = node;
        }
    }
    public void printList(){
        Node node = head;
        while(node.pointer != null){
            System.out.println(node.value);
            node = node.pointer;
        }


    }

    public int getHead(){
        return head.value;
    }
    public int getValue(int index){
        Node node = head;
        int i = 0;
        while(node.pointer != null && i++ < index){
            node = node.pointer;
            if (node.pointer == null && i != index){
                System.out.println("Index is empty");
            }
        }
        return node.value;
    }
}