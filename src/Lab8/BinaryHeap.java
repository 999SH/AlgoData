package Lab8;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryHeap {

    TNode root;

    public Queue<TNode> q = new LinkedList<>();

    public void addLeaf(int value) {
        TNode leaf = new TNode(value);
        leaf.heapSize = 1;
        if (this.root == null) {
            this.root = leaf;
        }
        else {
            TNode tnode = this.root;
            //tnode.heapSize > 1
            while (tnode.rightPointer != null || tnode.leftPointer != null){
                if (leaf.value < tnode.value){
                    swapValue(leaf, tnode);
                }
                if ( (tnode.rightPointer.heapSize < tnode.leftPointer.heapSize) ){
                    checkHeap(tnode);
                    tnode = tnode.rightPointer;
                }
                else if (tnode.leftPointer != null){
                    checkHeap(tnode);
                    tnode = tnode.leftPointer;
                }
                tnode.heapSize++;
            }
            if (tnode.leftPointer == null){
                tnode.leftPointer = leaf;
            }
            else {
                tnode.rightPointer = leaf;
            }

        }
    }
    public void swapValue(TNode a, TNode b){
        int temp = a.value;
        a.value = b.value;
        b.value = temp;
    }

    public void checkHeap(TNode node){
        if (node.leftPointer.value < node.value){
            swapValue(node, node.leftPointer);
        }
        else if (node.rightPointer.value < node.value){
            swapValue(node, node.rightPointer);
        }
    }

    public void BFSPRint(){
        q.add(root);
        while (!q.isEmpty()){
            TNode node = q.poll();
            System.out.println(node.value);
            if (node.leftPointer != null){
                q.add(node.leftPointer);
            }
            if (node.rightPointer != null){
                q.add(node.rightPointer);
            }
        }
    }
}
