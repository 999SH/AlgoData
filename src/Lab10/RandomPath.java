package Lab10;

import java.util.Random;
import java.util.Stack;
import java.util.Arrays;

public class RandomPath {
    public static void main(String[] args) {
        int[] nArray = new int[7];
        int ok = 1000;
        for (int l = 0; l < nArray.length; l++) {
            nArray[l] = ok;
            ok = ok * 2;
        }
        System.out.println(java.util.Arrays.toString(nArray));

        long t0;
        int k = 1;
        int curdist = Integer.MAX_VALUE;
        long curtim = Long.MAX_VALUE;
        for (int n : nArray) {
            long min = Long.MAX_VALUE;
            Map map = new Map("resources/trains.csv");
            Integer max = 1000000;
            int dist = 0;
            for (int j = 0; j < k; j++) {
                long begin = System.nanoTime();
                dist = shortest(map.lookup("Göteborg"), map.lookup("Malmö"), max);
                long end = System.nanoTime();
                t0 = (end - begin);
                if (t0 < min) {
                    min = t0;
                }
                if (dist < 2_000_000_000) {
                    System.out.println(dist);
                }
            }
            if (dist < curdist) {
                curdist = dist;
            }
            if (min < curtim) {
                curtim = min;
            }
            System.out.println("shortest: " + dist + " min (" + min + " ns)");
        }
        System.out.println("Absolute smallest: " + curdist + " (" + curtim + ")ns");
    }

    public static int random(int upperbound) {
        Random generator = new Random();
        if (upperbound > 0) {
            return generator.nextInt(upperbound);
        } else return 0;
    }

    private static Integer shortest(City from, City to, Integer max) {
        int sp = 0;
        City[] path = new City[55];
        if (max < 0)
            return null;
        if (from == to)
            return 0;
        restart:
        for (int i = 0; i < 2; i++) {
            Stack<City> stack = new Stack<>();
            Stack<Connection> constack = new Stack<>();

            Integer shrt = 0;
            stack.push(from);
            City city = from;
            Connection connect;
            outerloop:
            while (!stack.isEmpty() && !city.equals(to)) {
                if (shrt > max) {
                    return Integer.MAX_VALUE;
                }
                city = stack.pop();
                if (!constack.isEmpty()) {
                    connect = constack.pop();
                    shrt += connect.distance;
                }
                int j = 0;
                while (j < sp) {
                    if (path[j++].equals(city)) { //if path contains random
                        i = 0;
                        continue restart;
                    }
                }
                path[sp++] = city;
                int ap = random(city.ap);
                if (city.neighbors[ap] != null) {
                    stack.push(city.neighbors[ap].city);
                    constack.push(city.neighbors[ap]);
                }
            }
            if (city.equals(to)) {
                return shrt;
            }
        }
        return Integer.MAX_VALUE;
    }
}
