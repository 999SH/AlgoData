package Lab4;

import java.util.Arrays;
import java.util.Random;

public class Sort {
    public static void main(String[] args) {
        Random generator = new Random();
        int[] nArray = new int[7];
        int ok = 1000;
        for (int l = 0; l < nArray.length; l++){
            nArray[l] = ok;
            ok = ok*2;
        }
        System.out.println(Arrays.toString(nArray));
        long t0 = 0;
        long total = 0;
        int counter = 0;
        int k = 10000;
        for (int n : nArray) {
            int c = n;
            long min = Long.MAX_VALUE;
            int[] reversedArray = new int[n];
            for (int i = 0; i < reversedArray.length; i++) {
                reversedArray[i] = c;
                c--;
            }

            for (int j = 0; j < k; j++){
                long begin = System.nanoTime();
                insertionSort(reversedArray);
                long end = System.nanoTime();
                t0 = (end - begin);
                if (t0 < min) {
                    min = t0;
                }
            }
            System.out.println("Insertionsort "+(min/n));
        }
        /*for (int n : nArray) {
            long min = Long.MAX_VALUE;
            int c = n;
            int[] reversedArray = new int[n];
            for (int i = 0; i < reversedArray.length; i++) {
                reversedArray[i] = c;
                c--;
            }

            for (int j = 0; j < k; j++){
                long begin = System.nanoTime();
                selectionSort(reversedArray);
                long end = System.nanoTime();
                t0 = (end - begin);
                if (t0 < min) {
                    min = t0;
                }
            }
            System.out.println("Selectionsort "+(min));
        } */

        for (int n : nArray) {
            long min = Long.MAX_VALUE;
            int c = n;
            int[] reversedArray = new int[n];
            for (int i = 0; i < reversedArray.length; i++) {
                reversedArray[i] = c;
                c--;
            }

            for (int j = 0; j < k; j++){
                long begin = System.nanoTime();
                mergeSort(reversedArray);
                long end = System.nanoTime();
                t0 = (end - begin);
                if (t0 < min) {
                    min = t0;
                }
            }
            System.out.println("Mergesort "+(min/n));
        }
    }

    public static void selectionSort(int[] input) {
        {
            int n = input.length;

            // One by one move boundary of unsorted subarray
            for (int i = 0; i < n-1; i++)
            {
                // Find the minimum element in unsorted array
                int min_idx = i;
                for (int j = i+1; j < n; j++)
                    if (input[j] < input[min_idx])
                        min_idx = j;

                // Swap the found minimum element with the first
                // element
                int temp = input[min_idx];
                input[min_idx] = input[i];
                input[i] = temp;
            }
        }
    }
    public static void insertionSort(int array[]) {
        int n = array.length;
        for (int j = 1; j < n; j++) {
            int key = array[j];
            int i = j-1;
            while ( (i > -1) && ( array [i] > key ) ) {
                array [i+1] = array [i];
                i--;
            }
            array[i+1] = key;
        }
    }
    /*
    public static void insertionSort(int[] arr){
        int n = arr.length;
        for (int i = 1; i < n; ++i) {
            int key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j = j - 1;
            }
            arr[j + 1] = key;
        }
    }
*/
    public static void mergeSort(int[] input) {
        int length = input.length;
        if (length < 2) {
            return;
        }
        int mid = length / 2;
        int[] left = new int[mid];
        int[] right = new int[length - mid];

        System.arraycopy(input, 0, left, 0, mid);
        if (length - mid >= 0) System.arraycopy(input, mid, right, 0, length - mid);
        mergeSort(left);
        mergeSort(right);

        merge(input, left, right);
    }

    public static void merge(int[] input, int[] left, int[] right) {
        int i = 0;
        int j = 0;
        int k = 0;

        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                input[k++] = left[i++];
            } else {
                input[k++] = right[j++];
            }
        }
        while (i < left.length) {
            input[k++] = left[i++];
        }
        while (j < right.length) {
            input[k++] = right[j++];
        }
    }
}
