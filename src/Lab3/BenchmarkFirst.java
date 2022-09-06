package Lab3;
import java.util.Random;

public class BenchmarkFirst {
    public static void main(String[] args) {
        long total = 0;
            for (int j = 0; j <= 120; j++) {
                int[]arr = sorted(1600000);
                long begin = System.nanoTime();
                System.out.println(search_unsorted(arr,0));
                long end = System.nanoTime();
                System.out.println((end - begin)/1000);

                if (j > 19){
                    total += (end-begin);
                }

            }
        System.out.println(((total)/100)/1000);


    }

    public static boolean search_unsorted(int[] array, int key) {
        for (int index = 0; index < array.length; index++) {
            if (array[index] == key) {
                return true;
            }
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