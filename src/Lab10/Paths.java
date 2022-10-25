package Lab10;


public class Paths {

    City[] path;
    int sp;

    public Paths(){
        path = new City[55];
        sp = 0;
    }

    public static void main(String[] args) {
        String[] nArray = new String[]{"Malmö", "Göteborg", "Malmö", "Stockholm", "Stockholm", "Göteborg", "Sundsvall", "Umeå", "Göteborg"};
        String[] kArray = new String[]{"Göteborg", "Stockholm", "Stockholm", "Sundsvall", "Umeå", "Sundsvall", "Umeå", "Göteborg", "Umeå"};

        System.out.println(java.util.Arrays.toString(nArray));
        for (int bruh = 0; bruh < 9; bruh++) {
            Integer dist = 0;
            long t0;
            long min = Long.MAX_VALUE;
            Map map = new Map("resources/trains.csv");
            Integer max = 706;
            Paths path = new Paths();
            long begin = System.nanoTime();
            dist = path.shortest(map.lookup(nArray[bruh]), map.lookup(kArray[bruh]), max);
            long end = System.nanoTime();
            t0 = (end - begin);
            if (t0 < min) {
                min = t0;
            }
            if (dist != null) {
                System.out.println("shortest: between " + nArray[bruh] + " and " + kArray[bruh] +" "+ dist + " min (" + (float)min/1_000 + " us)");
            } else {
                System.out.println("Beeger max needed");
            }

        }
    }
    private Integer shortest(City from, City to, Integer max) {
        if (max < 0)
            return null;
        if (from == to)
            return 0;

        Integer shrt = null;
        Connection connection;

        for (int j = 0; j < sp; j++) {
            if (path[j].equals(from)){
                return null;
            }
        }
        path[sp++] = from;

        for (int i = 0; i < from.neighbors.length; i++) {
            if (from.neighbors[i] != null) {
                connection = from.neighbors[i];
                Integer dist  =shortest(connection.city,to,max-connection.distance);
                if ((dist != null) && ((shrt==null) || (shrt > dist + connection.distance))){
                    shrt = dist + connection.distance;
                }
                if ((shrt != null) && (max > shrt)){
                    max = shrt;
                }
            }
        }
        path[sp--] = null;
        return shrt;
    }
}