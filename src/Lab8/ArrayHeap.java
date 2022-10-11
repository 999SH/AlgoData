package Lab8;

public class ArrayHeap {
    int[] arrayHeap;
    int n = 2;
    private int arraypointer;

    public ArrayHeap() {
        this.arrayHeap = new int[n];
        arraypointer = 0;
    }
    public int getParentIndex(int index){
        return (index - 1) / 2;
    }
    public int getLeftPointer(int index){
        return ((2*index)+1);
    }
    public int getRightPointer(int index){
        return ((2*index)+2);
    }

    public void add(int node){
        arrayHeap[arraypointer] = node;
        bubble(arraypointer++);
    }

    public void remove(int node){
        int temp = arrayHeap[0];
        arrayHeap[0] = arrayHeap[arraypointer];
        //sink(0);
    }

    public void bubble(int index){
        while (index > 0 && arrayHeap[getParentIndex(index)] < arrayHeap[index]) {
            swap(getParentIndex(index),index);
        }
        index = getParentIndex(index);
    }

    public void swap(int a, int b){
        int temp = arrayHeap[a];
        arrayHeap[a] = arrayHeap[b];
        arrayHeap[b] = temp;
    }

    public void sink(int index){
        while (index > arraypointer){
            if (arrayHeap[index] > arrayHeap[getLeftPointer(index)]){
                swap(index,getLeftPointer(index));
            } else if (arrayHeap[index] > arrayHeap[getRightPointer(index)]) {
                swap(index,getRightPointer(index));
            }
            else {
                break;
            }
        }
    }

}
