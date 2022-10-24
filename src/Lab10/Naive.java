package Lab10;

import java.util.Random;
import java.util.Stack;

public class Naive {
    public static void main(String[]args){
    int[] nArray = new int[7];
    int ok = 1000;
        for (int l = 0; l < nArray.length; l++) {
        nArray[l] = ok;
        ok = ok * 2;
    }
        System.out.println(java.util.Arrays.toString(nArray));

    long t0;
    int k = 1_000_000;
        int curdist = Integer.MAX_VALUE;
        long curtim = Long.MAX_VALUE;
        for (int n : nArray) {
            long min = Long.MAX_VALUE;
            Map map = new Map("resources/trains.csv");
            Integer max = 50_000;
            int dist = 0;
        for (int j = 0; j < k; j++) {
            long begin = System.nanoTime();
            dist = shortest(map.lookup("Göteborg"), map.lookup("Stockholm"), max);
            long end = System.nanoTime();
            t0 = (end - begin);
            if (t0 < min) {
                min = t0;
            }
        }

        if (dist < curdist){
            curdist = dist;
        }
        if (min < curtim){
            curtim = min;
        }
        System.out.println("shortest: " + dist + " min (" + min + " ns)");
    }
        System.out.println("Absolute smallest: "+curdist+" ("+curtim+")ns");
    }
    private static Integer shortest(City from, City to, Integer max) {
        if (max < 0)
            return null;
        if (from == to)
            return 0;

        Stack<City> stack = new Stack<>();
        Integer shrt = 0;
        stack.push(from);
        City city;
        while (!stack.isEmpty()){
            if (shrt > max){
                return Integer.MAX_VALUE;
            }
            city = stack.pop();
            if (city.equals(to)){
                return shrt;
            }
            int ap = random(city.ap);
            if (city.neighbors[ap] != null){
                shrt += city.neighbors[ap].distance;
                stack.push(city.neighbors[ap].city);
            }
        }
        return shrt;
    }

    public static int random (int upperbound){
        Random generator = new Random();
        if (upperbound > 0){
            return generator.nextInt(upperbound);
        }
        else return 0;
    }
}

