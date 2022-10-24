package Lab10;

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
        int k = 10;

        for (int n : nArray) {
            Integer dist = 0;
            long min = Long.MAX_VALUE;
            Map map = new Map("resources/trains.csv");
            Integer max = 10_000;
            for (int j = 0; j < k; j++) {
                long begin = System.nanoTime();
                dist = shortest(map.lookup("Kiruna"), map.lookup("Malmö"), max);
                long end = System.nanoTime();
                t0 = (end - begin);
                if (t0 < min) {
                    min = t0;
                }
            }
            if (dist != null){
                System.out.println("shortest: " + dist + " min (" + min/1_000_000 + " ns)");
            }
            else {
                System.out.println("Beeger max needed");
            }

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
                Integer dist  = shortest(connection.city,to,max-connection.distance);
                if ((dist != null) && ((shrt==null) || (shrt > dist + connection.distance))){
                    shrt = dist + connection.distance;
                }
                if ((shrt != null) && (max > shrt)){
                    max = shrt;
                }
            }
        }
        return shrt;
    }
}

