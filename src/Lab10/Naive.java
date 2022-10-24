package Lab10;

import java.util.Random;
import java.util.Stack;

public class Naive {
    public static void main(String[] args) {
        int[] nArray = new int[7];
        int ok = 1000;
        for (int l = 0; l < nArray.length; l++) {
            nArray[l] = ok;
            ok = ok * 2;
        }
        System.out.println(java.util.Arrays.toString(nArray));

        long t0;
        int k = 20_000_000;
        int curdist = Integer.MAX_VALUE;
        long curtim = Long.MAX_VALUE;
        for (int n : nArray) {
            long min = Long.MAX_VALUE;
            Map map = new Map("resources/trains.csv");
            Integer max = 82;
            int dist = 0;
            for (int j = 0; j < k; j++) {
                long begin = System.nanoTime();
                dist = shortest(map.lookup("Malmö"), map.lookup("Alvesta"), max);
                long end = System.nanoTime();
                t0 = (end - begin);
                if (t0 < min) {
                    min = t0;
                }
            }
            System.out.println("shortest: " + dist + " min (" + min + " ns)");
        }
    }

    private static Integer shortest(City from, City to, Integer max) {
        if (max < 0)
            return null;
        if (from == to)
            return 0;

        Integer shrt = null;
        Connection connection;
        for (int i = 0; i < from.neighbors.length; i++) {
            if (from.neighbors[i] != null) {
                connection = from.neighbors[i];
                

            }
        }
        return shrt;
    }
}

