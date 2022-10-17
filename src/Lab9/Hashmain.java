package Lab9;

public class Hashmain {
    public static void main (String args[]){
        Zip postCodes = new Zip("resources/postnummer.csv");
        System.out.println(postCodes.lookup(11115));
    }
}
