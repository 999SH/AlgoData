package Lab6;


public class BinaryTree {
    Node root;
    public void addLeaf(int index, int value){
        Node leaf = new Node(value,index);

        if (root == null){
            root = leaf;
        }
        else {
            Node node = root;
            while (root.getLeftPointer() != null && root.getRightPointer() != null){
                if (index < node.getIndex()){
                    moveLeft(node);
                }
                if (index == node.getIndex()){
                    root.updateValue(leaf.getValue());
                }
                else {
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


    }
    public void moveLeft(Node input){
        input = input.getLeftPointer();
    }

    public void moveRight(Node input){
        input = input.getRightPointer();
    }

    public static void search(int key){

    }
}
