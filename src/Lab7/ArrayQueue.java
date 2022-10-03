package Lab7;
public class ArrayQueue<Item> {

    Item[] queue;
    private int queuepointer;
    private int headpointer;

    public ArrayQueue() {
        this.queue = (Item[]) new Object[2];
        queuepointer = 0;
        headpointer = 0;
    }

    public void loopCheck(){
        if (queuepointer == this.queue.length){
            queuepointer = 0;
        }
        if (headpointer == this.queue.length){
            headpointer = 0;
        }
    }

    public boolean isFull(){
        if (queuepointer == headpointer && queue[queuepointer] != null){
            return true;
        }
        else return false;
    }

    public boolean isEmpty(){
        if (queuepointer == headpointer && queue[queuepointer] == null){
            return true;
        }
        else return false;
    }

    public void add(Item item) {
        loopCheck();
        if (!isFull()){
            queue[queuepointer] = item;
        }
    }
    public Item poll() {
        loopCheck();
        if (isEmpty()){
            return null;
        }
        else {
            Item removedItem = this.queue[this.headpointer];
            this.queue[headpointer] = null;
            headpointer++;
            return removedItem;
        }
    }

}