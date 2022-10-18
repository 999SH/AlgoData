package Lab9;

public class Hashmain {
    public static void main (String args[]){
        Zip postCodes = new Zip("resources/postnummer.csv");
        for (int i = 5000; i < 160000; i = i+5000) {
            postCodes.collisions(i);
        }
    }
}
