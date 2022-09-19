package LabD;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] nArray = new int[6];
        int ok = 100;
        for (int l = 0; l < nArray.length; l++) {
            nArray[l] = ok;
            ok = ok * 2;
        }
        System.out.println(Arrays.toString(nArray));
        long t0;
        int k = 10000;
        DoublyLinkedList list1 = new DoublyLinkedList();
        DoublyLinkedList appended = new DoublyLinkedList();
        for (int n : nArray) {
            long min = Long.MAX_VALUE;
            for (int j = 0; j < k; j++) {
                DoublyLinkedList empty = new DoublyLinkedList();
                long begin = System.nanoTime();
                for (int i = 0; i < n; i++) {
                    empty.addNode(i);
                }
                long end = System.nanoTime();
                t0 = (end - begin);
                if (t0 < min) {
                    min = t0;
                }
            }
            System.out.println("Linked list append " + (min));
        }
    }
}
