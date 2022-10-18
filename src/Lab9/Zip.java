package Lab9;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;

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

    public void collisions(int mod) {
        int biggestbucket = 0;
        int extendedbuckets = 0;
        int emptybuckets = 0;
        int buckets = 0;
        int[] keys = new int[max];

        for (int i = 0; i < max; i++) {
            keys[i] = data[i].code;
        }


        int[] data = new int[mod];
        int[] cols = new int[100000];
        for (int i = 0; i < max; i++) {
            Integer index = keys[i] % mod;
            cols[data[index]]++;
            data[index]++;
        }
        for (int i = 0; i < mod; i++) {
            if (data[i] > biggestbucket){
                biggestbucket = data[i];
            }
            if (data[i] == 1){
                buckets++;
            }
            if (data[i] > 1){
                extendedbuckets++;
            }
            if (data[i] == 0){
                emptybuckets++;
            }
        }

        float average= (float)max/(float)buckets;
        float ratio = (float)average*(float)emptybuckets*(float)biggestbucket;

        System.out.print("Mod "+mod);
        System.out.println("Avg per bucket "+(average));
        System.out.println("Extended buckets "+extendedbuckets);
        System.out.println("Total buckets "+buckets);
        System.out.println("Empty buckets "+emptybuckets);

        System.out.println("Ratiod "+ ratio);
        System.out.println("   Biggest bucket "+biggestbucket);
    }

    public void collisionsImproved(int mod) {
        int biggestbucket = 0;
        int extendedbuckets = 0;
        int emptybuckets = 0;
        int buckets = 0;
        int jumpcounter = 0;
        int[] keys = new int[max];

        for (int i = 0; i < max; i++) {
            keys[i] = data[i].code;
        }


        int[] data = new int[mod];
        int[] cols = new int[100000];
        for (int i = 0; i < max; i++) {
            Integer index = keys[i] % mod;
            while (data[index] > 0){
                jumpcounter++;
                index++;
            }
                data[index]++;
        }
        for (int i = 0; i < mod; i++) {
            if (data[i] > biggestbucket){
                biggestbucket = data[i];
            }
            if (data[i] == 1){
                buckets++;
            }
            if (data[i] > 1){
                extendedbuckets++;
            }
            if (data[i] == 0){
                emptybuckets++;
            }
        }

        float average= (float)max/(float)buckets;
        float ratio = (float)average*(float)emptybuckets*(float)biggestbucket;

        System.out.print("Mod "+mod);
        System.out.println(" Avg jump per element "+(float)jumpcounter/(float)max);
        System.out.println("Biggest bucket "+biggestbucket);
        System.out.println("Extended buckets "+extendedbuckets);
        System.out.println("Total buckets "+buckets);
        System.out.println("Jumpcounter "+ jumpcounter);
        System.out.println("   Empty buckets "+emptybuckets);
        System.out.println("Avg per bucket "+(average));

    }

    public Zip (Zip zipper){
        data = new HashNode[100000];
        int index;
        for (int i = 0; i < ((zipper.max)+1); i++) {
            index = zipper.data[i].code;
            this.data[index] = zipper.data[i];
        }
        max = 99999;
    }
    public boolean lookup(Integer key){
        int index = 0;
        while(index <= max){
            if (data[index] != null){
                int force = data[index].code;
                if (force == key){
                    return true;
                }
            }
            index++;
        }
        return false;
    }



    public boolean binarySearch(Integer key){
        int mid;
        int force;
        int low = 0;
        int high = max;
        while (low != high){
            mid = ((high+low)/2);
            force = data[mid].code;
            if (force == key){
                return true;
            }
            if (force < mid){
                high = mid-1;
            }
            else {
                low = mid+1;
            }
        }
        return false;
    }

    public boolean bigBinarySearch (Integer key){
    int mid;
    int force;
    int low = 0;
    int high = max;
        while (low != high){
        mid = ((high+low)/2);
        if (mid == key){
            if (data[mid] != null){
                return true;
            }
            else {
                return false;
            }
        }
        if (key < mid){
            high = mid-1;
        }
        else {
            low = mid+1;
        }
    }
        return false;
}

}
