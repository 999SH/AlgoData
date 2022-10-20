package Lab10;

import java.util.Stack;

public class Naive {
    public static void main(String[] args) {
        Map map = new Map("resources/trains.csv");
        //String from = args[0];
        //String to = args[1];
        Integer max = 2000000000;
        long t0 = System.nanoTime();
        Integer dist = shortest(map.lookup("Hallsberg"), map.lookup("Herrljunga"), max);
        long time = (System.nanoTime() - t0)/1_000_000;
        System.out.println("shorest: " + dist + " min (" + time + " ms)");
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
        int ip = 0;
        while (!stack.isEmpty()){
            if (shrt > max){
                throw new RuntimeException("Error");
            }
            city = stack.pop();
            if (city.equals(to)){
                return shrt;
            }
            ip = 0;
            while (city.neighbors[ip] != null){
                shrt += city.neighbors[ip].distance;
                if (!city.neighbors[ip].city.equals(city)){
                    stack.push(city.neighbors[ip].city);
                }
                ip++;
            }
        }
        return shrt;
    }
}

