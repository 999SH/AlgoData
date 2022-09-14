package Benchmark;

import java.util.Arrays;
import java.util.Random;

class Bench {
    public static void main(String[] arg) {

        i     Random generator = new Random();
        int[] nArray = new int[]{1000, 2000, 4000, 8000, 16000, 32000};
        long t0 = 0;
        int k = 1000;
        for (int n : nArray) {
            long min = Long.MAX_VALUE;
            int[] unsortedArray = new int[n];
            for (int i = 0; i < unsortedArray.length; i++) {
                unsortedArray[i] = generator.nextInt(n);
            }

            for (int j = 0; j < k; j++){
                long begin = System.nanoTime();
                Arrays.toString(unsortedArray);
                long end = System.nanoTime();
                t0 = (end - begin);
                if (t0 < min) {
                    min = t0;
                }
            }
            System.out.println((min)/1000);

        }
    }
    public static int[] benchtest(int[]a){
        return a;
    }
}
