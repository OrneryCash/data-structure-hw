public class BSTree extends BTreePrinter{
    Node root;

    public static Node findKey(Node node, int search_key) {
        // Pls copy the code from the previous homework
        if (node == null) // Base case: if the current node is null, the key was not found
            return null;

        if (node.key == search_key) { // If the current node's key matches the search key, return the node
            return node;
        } else if (node.key > search_key) { // If the search key is smaller, move to the left subtree
            return findKey(node.left, search_key);
        } else if (node.key < search_key) { // If the search key is larger, move to the right subtree
            return findKey(node.right, search_key);
        }
        return null;
    }

    public static Node findMin(Node node){
        // Pls copy the code from the previous homework
        if (node == null) // If the node is null, return null
            return null;
        if (node.left == null) // The minimum is the leftmost node, so return when the left child is null
            return node;
        return findMin(node.left); // move to the left subtree
    }

    public static Node findMax(Node node){
        // Pls copy the code from the previous homework
        if (node == null) // If the node is null, return null
            return null;
        if (node.right == null) // The maximum is the rightmost node, so return when the right child is null
            return node;
        return findMax(node.right); // move to the right subtree
    }

    public void insertKey(int key) {
        // Pls implement this insertKey() using the recursive technique
        // This is similiar to findKey() but can insert node to the null node
        if (root == null) {
            root = new Node(key);
        } else {
            insertKey(root, key);
        }
    }

    public static void insertKey(Node node, int key) {
        // Pls copy the code from the previous homework
        if (key == node.key) {
            System.out.println("Duplicated key:" + key);
        }else if (key < node.key) {//Go left
            if (node.left == null) {
                node.left = new Node(key);
                node.left.parent = node;
            }else {
                insertKey(node.left, key);
            }
        }else{  // Go right
            if (node.right == null) {
                node.right = new Node(key);
                node.right.parent = node;
            }else {
                insertKey(node.right, key);
            }
        }
    }
    
    public void deleteKey(int key) {
        // Pls copy the code from the previous homework
        if (root == null) {
            System.out.println("Empty Tree!!!");
            return;
        }
        Node node = findKey(root, key); // Find the node to delete
        if (node != null) {
            if (node == root) {
                if (root.left == null && root.right == null) { // Case 1: Root has no children
                    root = null;
                } else if (root.left == null) { // Case 2: Root has only right child
                    Node minr = findMin(root.right); 
                    root = root.right;
                    minr.left = node;
                } else if (root.right == null) { // Case 3: Root has only left child
                    root = root.left;
                } else { // Case 4: Root has two children
                    Node minr = findMin(root.right); // Find the minimum node in the right subtree
                    root.key = minr.key; // Replace root's key with the minimum key
                    this.deleteKey(minr); // Delete the minimum node
                }
            } else {
                this.deleteKey(node); // If the node is not the root, call the static deleteKey method
            }
        } else {
            System.out.println("Key not found!!!"); // Error message if the key doesn't exist
        }
    }
    
    public static void deleteKey(Node node){
        // Pls copy the code from the previous homework
        if (node.left == null && node.right == null) { // Case 1: Node has no children
            Node curr = node.parent;
            if (curr.left == node)
                curr.left = null; // Remove the node
            else
                curr.right = null; // Remove the node
        } else if (node.left == null) { // Case 2: Node has only right child
            Node curr = node.parent;
            if (curr.left == node)
                curr.left = node.right; // Replace the node with its right child
            else
                curr.right = node.right; // Replace the node with its right child
            node.right.parent = curr;// Update the right child's parent
            node.right = null;
        } else if (node.right == null) { //Case 3: Node has only left child
            Node curr = node.parent;
            if (curr.left == node)
                curr.left = node.left; // Replace the node with its left child
            else
                curr.right = node.left; // Replace the node with its left child
            node.left.parent = curr; // Update the left child's parent
            node.left = null; 
        } else { //Case 4: Node has two children
            Node minr = findMin(node.right); // Find the minimum node in the right subtree
            node.key = minr.key; // Replace the node's key with the minimum key
            deleteKey(minr); // Recursively delete the minimum node
        }
    }
    
    public static boolean isMergeable(Node r1, Node r2){
        Node max = findMax(r1);
        Node min = findMin(r2);
        
        if (max == null || min == null) return true;
        if (max.key < min.key) return true;
        return false;
    }

    public static Node mergeWithRoot(Node r1, Node r2, Node t){
        if (isMergeable(r1, r2)) {
            // Fix this
            t.left = r1;
            t.right = r2;
            
            r1.parent = t;
            r2.parent = t;
            
            return t;
            
        } else {
            System.out.println("All nodes in T1 must be smaller than all nodes from T2");
            return null;
        }
    }
    
    public void merge(BSTree tree2){
        if (isMergeable(this.root, tree2.root)){
            Node t = findMax(this.root);
            deleteKey(t.key);
            root = mergeWithRoot(this.root, tree2.root, t);
        }else{
            System.out.println("All nodes in T1 must be smaller than all nodes from T2");
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
