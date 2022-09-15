package Lab5;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] nArray = new int[6];
        int ok = 100;
        for (int l = 0; l < nArray.length; l++) {
            nArray[l] = ok;
            ok = ok * 2;
        }
        System.out.println(Arrays.toString(nArray));
        long t0;
        int k = 10000;
        LinkedList list1 = new LinkedList();
        LinkedList appended = new LinkedList();
        for (int n : nArray) {
            long min = Long.MAX_VALUE;
            for (int j = 0; j < k; j++) {
                LinkedList empty = new LinkedList();
                long begin = System.nanoTime();
                for (int i = 0; i < n; i++) {
                    empty.addNode(i);
                }
                long end = System.nanoTime();
                t0 = (end - begin);
                if (t0 < min) {
                    min = t0;
                }
            }
            System.out.println("Linked list append " + (min));
        }
    }
}
