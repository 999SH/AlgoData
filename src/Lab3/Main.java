package Lab3;

import java.util.Arrays;
import java.util.Random;

public class Main {
    public static void main(String[] args){


        long total = 0;
        for (int j = 0; j <= 120; j++) {
            int[]arr = sorted(64000000);
            long begin = System.nanoTime();
            System.out.println(binary_search(arr,0));
            long end = System.nanoTime();
            System.out.println((end - begin)/1000);
            if (j > 19){
                total += (end-begin);
            }
        }
        System.out.println((total/100)/1000);
        }
    public static boolean binary_search(int[] array, int key) {
        int first = 0;
        int last = array.length-1;
        int index = (array.length)/2;
        while (true) {

        index = first + (last-first) /2;
        if (array[index] < key && index < last) {
// The index position holds something that is less than
// what we're looking for, what is the first possible page? first = ...... ;
                first = index+1;
                continue;
        }
        if (array[index] > key && index > first) {
// The index position holds something that is larger than // what we're looking for, what is the last possible page? last = ...... ;
                last = index-1;
                continue;
        }
        if (array[index] == key) {
                return true;
            }
        if (first == last) {
                 break;
        }
        else break;
        }
        return false;
    }
    private static int[] sorted(int n) {
        Random rnd = new Random();
        int[] array = new int[n];
        int nxt = 0;
        for (int i = 0; i < n ; i++) {
            nxt += rnd.nextInt(10) + 1;
            array[i] = nxt;
        }
        return array;
    }

}
