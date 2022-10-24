package Lab10;

import java.io.BufferedReader;
import java.io.FileReader;

public class Map {
    private City[] cities;
    private final int mod = 542;

    public City[] getCities() {
        return cities;
    }

    private Integer hash(String name) {
        int hash = 7;
        for (int i = 0; i < name.length(); i++) {
            hash = (hash*31 % mod) + name.charAt(i);
        }
        return hash % mod;
    }

    public City lookup (String name){
        int sp = hash(name);
        while (cities[sp] != null) {
            if (this.cities[sp].name.equals(name)){
                return cities[sp];
            }
            sp++;
        }
        cities[sp] = new City(name);
        return cities[sp];
    }

    public Map(String file) {
        cities = new City[mod];
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                Integer distance = Integer.valueOf(row[2]);

                City city = lookup(row[0]);
                City citx = lookup(row[1]);
                city.addConnection(citx, distance);
                citx.addConnection(city, distance);
            }
        } catch (Exception e) {
            System.out.println(" file " + file + " not found or corrupt");
        }
    }

}
