package Benchmark;

import Lab9.Zip;

import java.util.Random;

import java.util.Arrays;

public class Benchmark{
    public static void main(String args[]){
        Random generator = new Random();
        int[] nArray = new int[7];
        int ok = 1;
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
            Zip postCodes = new Zip("resources/postnummer.csv");
            Zip arrayzip = new Zip(postCodes);
            long begin = System.nanoTime();
            arrayzip.lookup(99499);
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
