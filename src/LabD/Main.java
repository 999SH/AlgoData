package LabD;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random generator = new Random();
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
            long minSL = Long.MAX_VALUE;

            int j = 100;
            int[] indies = new int[j];
            for (int i = 0; i < j; i++) {
                indies[i] = generator.nextInt(n-1);
            }

            for (int b = 0; b < k; b++) {
                DoublyLinkedList dll = new DoublyLinkedList();
                Lab5.LinkedList LinkedList = new Lab5.LinkedList();
                for (int i = 0; i < n; i++) {
                    dll.addDLLNode(i);
                    LinkedList.addNode(i);
                }

                long begin = System.nanoTime();
                for (int indx: indies) {
                    dll.removeDLLNode(indx);
                    dll.addDLLend(1);
                }

                long end = System.nanoTime();
                t0 = (end - begin);
                if (t0 < min) {
                    min = t0;
                }

                long t0SL;
                long beginSL = System.nanoTime();
                for (int indx: indies) {
                    LinkedList.removeNode(indx);
                    LinkedList.addNodeEnd(1);
                }
                long endSL = System.nanoTime();
                t0SL = (endSL - beginSL);
                if (t0SL < minSL) {
                    minSL = t0SL;
                }


            }
            System.out.println("DLL append " + (min));
            System.out.println("SLL append "+(minSL));
        }
    }
}
