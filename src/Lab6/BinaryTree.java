package Lab6;


import java.util.Iterator;
import java.util.Stack;


public class BinaryTree implements Iterable<Integer> {

    public Iterator<Integer> iterator() {
        return new TreeIterator();
    }

    Stack<Node> stack = new Stack<Node>();
    Node root;
    int length = 0;

    public void addLeaf(int index, int value) {
        Node leaf = new Node(index, value);

        if (root == null) {
            root = leaf;
        } else {
            Node node = root;
            while (node.rightPointer != null || node.leftPointer != null) {
                if (index < node.index && node.leftPointer != null) {
                    node = node.leftPointer;
                }
                if (index == node.index) {
                    node.value += leaf.value;
                    break;
                }
                if (index > node.index && node.rightPointer != null) {
                    node = node.rightPointer;
                } else {
                    break;
                }
            }
            if (index < node.index) {
                node.leftPointer = leaf;
            }
            if (index == node.index) {
            }
            if (index > node.index) {
                node.rightPointer = leaf;
            }
        }
    }

    public void print() {
        stack.push(root);
        while (!stack.isEmpty()) {
            Node node = stack.pop();
            System.out.println(node.index);
            if (node.leftPointer != null) {
                stack.push(node.leftPointer);
            }
            if (node.rightPointer != null) {
                stack.push(node.rightPointer);
            }
        }
    }
    public Integer lookup(Integer key) {
        Node node = root;
        while (key != node.index) {
            if (key > node.index) {
                node = node.rightPointer;
            }
            if (key < node.index) {
                node = node.leftPointer;
            }
            else {
                return null;
            }
        }
        return node.value;
    }
}


