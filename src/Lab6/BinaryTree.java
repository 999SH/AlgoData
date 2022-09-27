package Lab6;


public class BinaryTree {
    Node root;
    int length = 0;
    public void addLeaf(int index, int value){
        Node leaf = new Node(index,value);

        if (root == null){
            root = leaf;
        }
        else {
            Node node = root;
            while (node.getRightPointer() != null || node.getLeftPointer() != null){
                if (index < node.getIndex() && node.leftPointer != null ){
                    node = node.leftPointer;
                }
                if (index == node.index){
                    node.value += leaf.value;
                    break;
                }
                if (index > node.getIndex() && node.rightPointer != null) {
                    node = node.rightPointer;
                }
                else {
                    break;
                }
            }
            if (index < node.index){
                node.leftPointer = leaf;
            }
            if (index == node.index){
            }
            if (index > node.index) {
                node.rightPointer = leaf;
            }
        }
    }
    public void moveLeft(Node input){
        input = input.getLeftPointer();
    }

    public void moveRight(Node input){
        input = input.getRightPointer();
    }

    public static void search(int key){

    }

    public void printTree(){
        int curlength = 0;
        Node node = root;
        while (length > curlength++)
            System.out.println(node.getValue());
            moveLeft(node);
    }
}
