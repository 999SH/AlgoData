package Lab10;

public class City {
    String name;
    Connection[] neighbors;

    public int ap = 0;
    public City(String name){
        this.name = name;
        neighbors = new Connection[10];
    }

    public void addConnection(City city, int distance){
        while (neighbors[ap] != null){
            ap++;
        }
        neighbors[ap] = new Connection(city,distance);
    }

    public void sortConnections(){
        int n = neighbors.length;
        for (int j = 1; j < n; j++) {
            int key = neighbors[j].distance;
            int i = j-1;
            while ( (i > -1) && (neighbors[i].distance > key ) ) {
                neighbors[i+1].distance = neighbors[i].distance;
                i--;
            }
            neighbors[i+1].distance = key;
        }
    }


}
