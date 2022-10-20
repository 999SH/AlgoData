package Lab10;

import java.util.Arrays;

public class Trainsmain {
    public static void main(String []args){
        Map mapa= new Map("resources/trains.csv");
        City[] localcities = mapa.getCities();
        int ip = 0;
            while (ip < 541){
                if (localcities[ip] != null){
                    System.out.println(localcities[ip].name);
                }
                ip++;
            }
    }
}
