package Lab4;

public class Merge {
    public static void main(String[]args){

    }

    private static void merge(int[] org, int[] aux, int lo, int mid, int hi) {
        // copy all items from lo to hi from org to aux
        for (int i: org) {
            aux[i] = org[i];
            
        }
// let's do the merging
        int i = lo; // the index in the first part
        int j = mid+1; // the index in the second part
        // for all indeces from lo to hi
        for ( int k = lo; k <= hi; k++) {
// if i is greater than mid, move the j item to the org array, update j
:
// else if j is greate than hi, move the i item to the org array, update i :
// else if the i item is smaller than the j item,
// move it to the org array, update i
:
// else you can move the j item to the org array, update j
:
        }
    }
    public static void sort(int[] org) {
        if (a.length == 0)
            return;
        int[] aux = new int[a.length];
        sort(org, aux, 0, a.length -1);
    }

    private static void sort(int[] org, int[] aux, int lo, int hi) {
        if (lo != hi) {
            int mid = lo + (hi-lo)/2;
// sort the items from lo to mid


// sort the items from mid+1 to hi


// merge the two sections using the additional array merge(org, aux, lo, mid, hi);
        }
    }

}
