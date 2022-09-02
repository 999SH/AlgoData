import java.util.Random;
public class Task2 {
    public static void main(String[] args) {
        System.out.println(t_total(100,10,10)+" microseconds");
    }
    public static double t_total(int n, int k, int m){
        Random rnd = new Random();
        int sum = 0;
        long t_total = 0;
        int[] keys = new int[m];
        int[] array = new int[n];
        for (int j = 0; j < n; j++) {
            array[j] = rnd.nextInt(10 * n);

        }
        for (int j = 0; j < m; j++) {
            keys[j] = rnd.nextInt(10 * n);
        }
        for (int j = 0; j < k; j++) {
            // fill the keys array with random number from 0 to 10*n
            // fill the array with with random number from 0 to 10*n
            long  t0 = System.nanoTime();
            for (int ki = 0; ki < m; ki++) {
                int key = keys[ki];
                for (int i = 0; i < n ; i++) {
                    if (array[i] == key) {
                        sum++;
                        break; }
                } }
            t_total += (System.nanoTime() - t0);
        }
        return ((t_total)/1000);
    }
}


