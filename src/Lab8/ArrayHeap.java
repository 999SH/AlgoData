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

    public void bubble(int nodeIndex){
        while (nodeIndex > 0 && arrayHeap[getParentIndex(nodeIndex)] < arrayHeap[nodeIndex]) {
            swap(getParentIndex(nodeIndex),nodeIndex);
        }
        nodeIndex = getParentIndex(nodeIndex);
    }

    public void swap(int a, int b){
        int temp = arrayHeap[a];
        arrayHeap[a] = arrayHeap[b];
        arrayHeap[b] = temp;
    }

}
