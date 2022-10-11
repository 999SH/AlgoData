package Lab8;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryHeap {

    TNode root;
    public Queue<TNode> q = new LinkedList<>();
    public void swapValue(TNode a, TNode b){
        int temp = a.value;
        a.value = b.value;
        b.value = temp;
    }

    public void checkHeap(TNode leaf, TNode compare){
        if (compare.value > leaf.value){
            swapValue(leaf, compare);
        }
    }
    public void addLeaf(int value) {
        TNode leaf = new TNode(value);
        if (this.root == null) {
            this.root = leaf;
        }
        else {
            TNode tnode = this.root;
            while (tnode.rightPointer != null && tnode.leftPointer != null){
                tnode.heapSize++;
                checkHeap(leaf,tnode);
                if (tnode.rightPointer.heapSize < tnode.leftPointer.heapSize){
                    tnode = tnode.rightPointer;
                }
                else {
                    tnode = tnode.leftPointer;
                }
                tnode.heapSize++;
            }
            checkHeap(leaf,tnode);
            if (tnode.leftPointer == null){
                tnode.leftPointer = leaf;
            }
            else {
                tnode.rightPointer = leaf;
            }
            if (root.rightPointer != null && root.leftPointer != null){
                root.heapSize = root.leftPointer.heapSize + root.rightPointer.heapSize;
            }
        }
    }

    public boolean hasTwoChildren(TNode node){
        return node.rightPointer != null && node.leftPointer != null;
    }

    public boolean hasLeftChild(TNode node){
        return node.leftPointer != null;
    }
    public boolean hasRightChild(TNode node){
        return node.rightPointer != null;
    }

    public boolean hasNoChildren(TNode node){
        return node.rightPointer == null && node.leftPointer == null;
    }

    public TNode smallestPointer(TNode node){

        if (hasLeftChild(node) && !hasTwoChildren(node)) {
            return node.leftPointer;
        }
        if (hasRightChild(node) && !hasTwoChildren(node)){
            return node.rightPointer;
        }
        if (hasTwoChildren(node)){
            if (node.leftPointer.value <= node.rightPointer.value){
                return node.leftPointer;
            }
            else return node.rightPointer;
        }
        else return null;
    }

    public void verifyHeap() {
        TNode tnode = this.root;
        while (hasTwoChildren(tnode)) {
            tnode.heapSize--;
            if (tnode.rightPointer.value < tnode.leftPointer.value) {
                checkHeap(tnode.rightPointer, tnode);
                tnode = tnode.rightPointer;
            } else {
                checkHeap(tnode.leftPointer, tnode);
                tnode = tnode.leftPointer;
            }
        }
        tnode.heapSize--;
        while ((smallestPointer(smallestPointer(tnode)) != null)){
            checkHeap(smallestPointer(tnode),tnode);
            tnode = smallestPointer(tnode);
            tnode.heapSize--;
        }
        checkHeap(smallestPointer(tnode),tnode);
        tnode.rightPointer = null;
        tnode.leftPointer = null;
    }
    public int remove(){
        int temp = this.root.value;
        TNode node = this.root;
        node.value = Integer.MAX_VALUE;
        verifyHeap();

        return temp;
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
