package Lab5;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] nArray = new int[6];
        int ok = 500;
        for (int l = 0; l < nArray.length; l++) {
            nArray[l] = ok;
            ok = ok * 2;
        }
        System.out.println(Arrays.toString(nArray));
        long t0;
        int k = 1000;


        for (int n : nArray) {
            long min = Long.MAX_VALUE;

            for (int j = 0; j < k; j++) {
                LinkedList list1 = new LinkedList();
                LinkedList appended = new LinkedList();
                LinkedList empty = new LinkedList();
                for (int i = 0; i < n; i++) {
                    list1.addNode(i);
                }
                for (int i = 0; i < 1000; i++) {
                    appended.addNode(i);
                }
                long begin = System.nanoTime();
                empty.addList(list1,appended);
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
