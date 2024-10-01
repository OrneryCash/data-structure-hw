public class BSTree2 extends BTreePrinter{
    Node root;
    
    // Implement this function using iterative method
    // Do not use recursion
    public Node findKey(int search_key){
        Node curr = root;
        while (curr != null) {
            if (curr.key == search_key) return curr;
            else if (curr.key > search_key) curr = curr.left;
            else curr = curr.right;
        }
        return null;
    }

    // Implement this function using iterative method
    // Do not use recursion
    public Node findMin(){
        if (root == null) return null;
        Node curr = root;
        while (curr.left != null) {
            curr = curr.left;
        }
        return curr;
    }

    // Implement this function using iterative method
    // Do not use recursion
    public Node findMax(){
        if (root == null) return null;
        Node curr = root;
        while (curr.right != null) {
            curr = curr.right;
        }
        return curr;
    }
    
    // Implement this function using iterative method
    // Do not use recursion
    public void insertKey(int key) {
        if (root == null) {
            root = new Node(key);
        } else {
            Node curr = root;
            while (curr != null) {
                if (key == curr.key) {
                    return;
                }
    
                if (key < curr.key) {
                    if (curr.left == null) {
                        curr.left = new Node(key);
                        return;
                    }
                    curr = curr.left;
                } else {
                    if (curr.right == null) {
                        curr.right = new Node(key);
                        return;
                    }
                    curr = curr.right;
                }
            }
        }
    }
    
    // This function is complete, no need to edit
    public void printTree() {
        if (root == null) {
            System.out.println("Empty tree!!!");
        } else {
            super.printTree(root);
        }
    }
}
