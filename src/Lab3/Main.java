package Lab3;

public class Main {
    public static void main(String[] args){

    }
    public static boolean binary_search(int[] array, int key) {
        int first = 0;
        int last = array.length-1;
        int index = (array.length)/2;
        while (true) {

        if (array[index] == key) {
                break;
            }
            if (array[index] < key && index < last) {
// The index position holds something that is less than
// what we're looking for, what is the first possible page? first = ...... ;
                first = index;
                continue;
            }
            if (array[index] > key && index > first) {
// The index position holds something that is larger than // what we're looking for, what is the last possible page? last = ...... ;
                last = index;
                continue;
            }
            // Why do we land here? What shoudl we do?
            }
        return false;
    }
}
