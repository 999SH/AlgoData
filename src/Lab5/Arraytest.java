package Lab5;

import java.util.Arrays;

public class Arraytest {
    public static void main(String[] args) {
        int[] nArray = new int[7];
        int ok = 1000;
        for (int l = 0; l < nArray.length; l++) {
            nArray[l] = ok;
            ok = ok * 2;
        }
        System.out.println(java.util.Arrays.toString(nArray));
        long t0 = 0;
        long total = 0;
        int k = 100000;
        for (int n : nArray) {
            int c = n;
            long min = Long.MAX_VALUE;
            int[] array1 = new int[n];

            for (int i = 0; i < array1.length; i++) {
                array1[i] = c;
                c--;
            }
            int[] append = new int[2*n];
            for (int i = n; i < 2*n ; i++) {
                append[i] = i;
            }
            for (int j = 0; j < k; j++) {
                long begin = System.nanoTime();

                int[] holder = new int[2*n];
                for (int i = 0; i < n/2; i++) {
                    holder[i] = array1[i];
                }
                for (int i = n/2; i < n; i++) {
                    holder[i] = append[i-(n/2)];
                }
                long end = System.nanoTime();
                t0 = (end - begin);
                if (t0 < min) {
                    min = t0;
                }
            }
            System.out.println("Arrays " + (min));

        }

    }
}
