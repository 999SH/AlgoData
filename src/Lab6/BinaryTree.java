package Lab6;


public class BinaryTree {
    Node root;
    int length = 0;
    public void addLeaf(int index, int value){
        Node leaf = new Node(value,index);
        int curlength = 0;

        if (root == null){
            root = leaf;
        }
        else {
            Node node = root;
            while (length > curlength++){
                if (index < node.getIndex() && root.getLeftPointer() != null){
                    moveLeft(node);
                }
                if (index == node.getIndex()){
                    root.updateValue(leaf.getValue());
                }
                else if (root.getRightPointer() != null) {
                    moveRight(node);
                }
            }
            if (index < node.getIndex()){
                node.setLeftPointer(leaf);
            }
            if (index == node.getIndex()){
                root.updateValue(leaf.getValue());
            }
            else {
                node.setRightPointer(leaf);
            }
        }
        length++;
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
            moveRight(node);
    }
}
