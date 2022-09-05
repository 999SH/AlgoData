package Lab3;
import java.util.Random;

public class BenchmarkFirst {
    public static void main(String[] args) {
        long total = 0;
            for (int j = 0; j <= 10; j++) {
                long begin = System.nanoTime();
                boolean boo = search_unsorted(sorted(1000), 0);
                long end = System.nanoTime();
                System.out.println((end - begin));
                System.out.println(boo);
                if (j > 5){
                    total += (end-begin);
                }

            }
        System.out.println(((total)/5)/1000000);


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