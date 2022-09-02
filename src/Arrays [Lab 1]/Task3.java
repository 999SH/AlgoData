import java.util.Random;
public class Task3 {
    public static void main(String[] args) {
        System.out.println(t_total(600000,10)+" nanoseconds");
    }
    public static double t_total(int n, int k){
        Random rnd = new Random();
        int sum = 0;
        long t_total = 0;
        int[] keys = new int[n];
        int[] array = new int[n];

        for (int j = 0; j < n; j++) {
            array[j] = rnd.nextInt(10 * n); // fill the  array with random number from 0 to 10*n
            keys[j] = rnd.nextInt(10 * n);
        }
        for (int j = 0; j < k; j++) {
            long  t0 = System.nanoTime();
            for (int i = 0; i < n; i++) {
                for (int s = 0; s < n ; s++) {
                    if (array[i] == keys[s]) { //if it finds a match for array [i] then it moves on to i+1
                        sum++;
                        break;
                    }
                }
            }
            t_total += (System.nanoTime() - t0);
        }
        return ((t_total)/1000); //in order to get the time in microseconds instead of nano
    }
}


