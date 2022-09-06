package Lab3;

import java.util.Random;

public class BenchmarkThird {
    public static void main(String[] args) {


        long total = 0;
        long total2 = 0;
        for (int j = 0; j <= 120; j++) {
            int[] arr1 = sorted(1000000);
            int[] arr2 = sorted(1000000);
            long begin = System.nanoTime();
            System.out.println(doublesort(arr1, arr2) + " Duplicates found");
            long end = System.nanoTime();
            System.out.println(((end - begin) / 1000) + " Time for doublesort");
            if (j > 19) {
                total += (end - begin);
            }
            long begin2 = System.nanoTime();
            System.out.println(uneffdoublesort(arr1, arr2) + " Duplicates found in uneff ");
            long end2 = System.nanoTime();
            System.out.println(((end2 - begin2) / 1000) + " Time for uneffdoublesort");
            if (j > 19) {
                total2 += (end2 - begin2);
            }
        }
        System.out.println((((total) / 100) / 1000) + " Avg For efficient doublesort");
        System.out.println((((total2) / 100) / 1000) + " Avg For uneff doublesort");


    }

    public static int doublesort(int[] a, int[] b) {
        int indexa = 0;
        int indexb = 0;
        int duplicates = 0;

        while (indexa < a.length-1 && indexb < b.length-1) {
            if (a[indexa] == b[indexb]) {
                duplicates++;
                indexa++;
                indexb++;
            }
            if (a[indexa] < b[indexb] && indexa < a.length-1) {
                indexa++;
            }
            if (a[indexa] > b[indexb]&& indexb < b.length-1) {
                indexb++;
            }
        }
        return duplicates;
    }

    public static boolean binary_search(int[] array, int key) {
        int first = 0;
        int last = array.length - 1;
        int index = (array.length) / 2;
        while (true) {

            index = first + (last - first) / 2;
            if (array[index] < key && index < last) {
// The index position holds something that is less than
// what we're looking for, what is the first possible page? first = ...... ;
                first = index + 1;
                continue;
            }
            if (array[index] > key && index > first) {
// The index position holds something that is larger than // what we're looking for, what is the last possible page? last = ...... ;
                last = index - 1;
                continue;
            }
            if (array[index] == key) {
                return true;
            }
            if (first == last) {
                break;
            } else break;
        }
        return false;
    }

    private static int[] sorted(int n) {
        Random rnd = new Random();
        int[] array = new int[n];
        int nxt = 0;
        for (int i = 0; i < n; i++) {
            nxt += rnd.nextInt(10) + 1;
            array[i] = nxt;
        }
        return array;
    }

    public static int uneffdoublesort(int[] a, int[] b) {
        int duplicates = 0;
        for (int i = 0; i < a.length; i++) {
            int key = a[i];
            if (binary_search(b, key)) {
                duplicates++;
            }
        }
        return duplicates;
    }

}
