package Lab9;
import java.io.BufferedReader;
import java.io.FileReader;

public class Zip {
    HashNode[] data;
    int max;
    public Zip(String file){
        data = new HashNode[10000];
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String line;
            int i = 0;
            while ((line = br.readLine()) != null) {
                String[] row = line.split(",");
                Integer code = Integer.valueOf(row[0].replaceAll("\\s",""));
                data[i++] = new HashNode(code, row[1], Integer.valueOf(row[2]));
            }
            max = i-1;
        } catch (Exception e) {
            System.out.println(" file " + file + " not found");
        }
    }

    public boolean lookup(Integer key){
        int index = 0;
        while(index <= max){
            int force = data[index].code;
            if (force == key){
                return true;
            }
            index++;
        }
        return false;
    }
}
