package Lab10;


public class Paths {

    City[] path;
    int sp;

    public Paths(){
        path = new City[54];
        sp = 0;
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
                Integer dist  =shortest(connection.city,to,max-connection.distance);
                if ((dist != null) && ((shrt==null) || (shrt > dist + connection.distance))){
                    shrt = dist + connection.distance;
                }
                if ((shrt != null) && (max > shrt)){
                    max = shrt;
                }
                if ((max != null) && (max < 0)){
                    return null;
                }
            }
        }
        return shrt;
    }
}