package Lab6;

import java.util.Random;

public class Main {
    public static void main (String [] args){
        /*
        Random generator = new Random();
        int[] nArray = new int[7];
        int ok = 1000;
        for (int l = 0; l < nArray.length; l++) {
            nArray[l] = ok;
            ok = ok * 2;
        }
        System.out.println(java.util.Arrays.toString(nArray));

        long t0;
        int k = 10000;
        for (int n : nArray) {
            int[] sortedArray = new int[n];
            for (int i = 0; i < n; i++) {
                sortedArray[i] = i;
            }
            long min = Long.MAX_VALUE;
            for (int j = 0; j < k; j++) {
                long begin = System.nanoTime();
                // code
                long end = System.nanoTime();
                t0 = (end - begin);
                if (t0 < min) {
                    min = t0;
                }
            }
            System.out.println("Tree building " + (min));
            */
         BinaryTree tree = new BinaryTree();
         tree.addLeaf(10,1);
        tree.addLeaf(3,1);
        tree.addLeaf(2,1);
        tree.addLeaf(4,1);
        tree.addLeaf(11,1);
        tree.addLeaf(14,1);
        tree.addLeaf(12,1);
         tree.print();
        }
    }

