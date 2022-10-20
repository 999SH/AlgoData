package Benchmark;

import java.util.LinkedList;
import java.util.Random;

import java.util.Arrays;

public class Benchmark{
    public static void main(String args[]){
        Random generator = new Random();
        int[] nArray = new int[7];
        int ok = 1000;
        for (int l = 0; l < nArray.length; l++) {
        nArray[l] = ok;
        ok = ok * 2;
        }
        System.out.println(java.util.Arrays.toString(nArray));

        long t0;
        int k = 1000;
        for (int n : nArray) {
        int[] sortedArray = new int[n];
        for (int i = 0; i < n; i++) {
        sortedArray[i] = i;
        }
        long min = Long.MAX_VALUE;

        for (int j = 0; j < k; j++) {
            LinkedList list = new LinkedList();
            long begin = System.nanoTime();
            for (int i = 0; i < n; i++) {
                list.add(i);
            }
            for (int i = 0; i < n; i++) {
                list.remove();
            }
            long end = System.nanoTime();
            t0 = (end - begin);
            if (t0 < min) {
                min = t0;
            }
        }
        System.out.println("Benchmark " + (min));
        }
    }
}
