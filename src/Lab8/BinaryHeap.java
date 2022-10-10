package Lab8;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryHeap {

    TNode root;

    int depth;

    public Queue<TNode> q = new LinkedList<>();

    public void addLeaf(int value) {
        TNode leaf = new TNode(value);
        int curdepth = 0;
        if (this.root == null) {
            this.root = leaf;
            depth = 0;
        }
        else {
            TNode tnode = this.root;
            //Move to bottom left, level above lowest
            //If left and right pointer are null, move to the next node
            while (tnode.rightPointer != null || tnode.leftPointer != null) {
                    if (value > tnode.value && tnode.leftPointer != null) {
                    tnode = tnode.leftPointer;
                }
                else if (value >= tnode.value && tnode.rightPointer != null) {
                    tnode = tnode.rightPointer;
                } else {
                    break;
                }
            }
            if (value < tnode.value) {
                tnode.leftPointer = leaf;
            }
            else if (value == tnode.value) {
            }
            else if (value > tnode.value) {
                tnode.rightPointer = leaf;
            }
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
