package Benchmark;

import java.util.Arrays;

public class Testing {
    public static void main(String[] args) {
        int[] nArray = new int[6];
        int ok = 1000;
        for (int l = 0; l < nArray.length; l++) {
            nArray[l] = ok;
            ok = ok * 2;
        }
        System.out.println(Arrays.toString(nArray));
        long t0;
        int k = 10000;

        LinkedList list1 = new LinkedList();
        for (int n : nArray) {
            int c = 0;
            long min = Long.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                list1.addNode(c);
                c++;
            }
            for (int j = 0; j < k; j++) {
                long begin = System.nanoTime();
                list1.getValue(n-2);
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
