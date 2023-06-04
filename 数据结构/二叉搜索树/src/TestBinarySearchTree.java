public class TestBinarySearchTree {
    public static void main(String[] args) {
        int[]array={9,8,7,5,4,2,1};
        BinarySearchTree binarySearchTree=new BinarySearchTree();
        for(int num:array){
            binarySearchTree.insertNode(num);
        }
        binarySearchTree.inorder();
        System.out.println();
        for(int num:array){
            binarySearchTree.remove(num);
            binarySearchTree.inorder();
            System.out.println();
        }
    }
}
