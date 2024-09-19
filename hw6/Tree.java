// This Tree needs to inherit BTreePrinter
public class Tree extends BTreePrinter { // inherit BTreePrinter for printing purposes
    Node root;

    public Tree(Node root) { // Constructor that initializes the tree with a root node
        this.root = root;
    }

    public Tree() {
    } // Dummy constructor (No need to edit)

    public void printTree() { // Print the tree structure using the inherited printTree method from BTreePrinter
        if (root != null) {
            super.printTree(root);
            return;
        }
        System.out.println("Empty tree!!!");
    }

    public static void printNode(Node node) {
        if (node == null) {
            System.out.println("Node not found!!!");
            return;
        }
        System.out.println(node.key);
    }

    public Node findKey(int search_key) { // Wrapper method to find a node by key using recursion
        return this.findKey(root, search_key); // Call the recursive version, starting from the root
    }

    public static Node findKey(Node node, int search_key) { // Recursive method to search for a node by its key
        // this function should be recursive
        // You should check null in this function
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

    public Node findMin() { // Wrapper method to find the minimum key in the tree
        return this.findMin(root); // Call the recursive version, starting from the root
    }

    public static Node findMin(Node node) { // Recursive method to find the node with the minimum key
        // this function should be recursive
        if (node == null) // If the node is null, return null
            return null;
        if (node.left == null) // The minimum is the leftmost node, so return when the left child is null
            return node;
        return findMin(node.left); // move to the left subtree
    }

    public Node findMax() { // Wrapper method to find the maximum key in the tree
        return this.findMax(root); // Call the recursive version
    }

    public static Node findMax(Node node) { // Recursive method to find the node with the maximum key
        // this function should be recursive
        if (node == null) // If the node is null, return null
            return null;
        if (node.right == null) // The maximum is the rightmost node, so return when the right child is null
            return node;
        return findMax(node.right); // move to the right subtree
    }

    public Node findClosestLeaf(int search_key) { // Wrapper method to find the closest leaf node to a given search key
        return this.findClosestLeaf(root, search_key); // Call the recursive version
    }

    public static Node findClosestLeaf(Node node, int search_key) { // Recursive method to find the leaf node closest to a given search key
        // this function should be recursive
        if (node == null) // If the node is null, return null
            return null;

        if (node.key > search_key) { // If the search key is smaller, go to the left subtree
            if (node.left == null) // If there's no left child, this node is the closest leaf
                return node;
            return findClosestLeaf(node.left, search_key); // Recursively search the left subtree
        } else if (node.key < search_key) { // If the search key is larger, go to the right subtree
            if (node.right == null) // If there's no right child, this node is the closest leaf
                return node;
            return findClosestLeaf(node.right, search_key); // Recursively search the right subtree
        }
        return null; // Return null if no valid leaf is found
    }

    public Node findClosest(int search_key) { 
        // Please use while loop to implement this function
        // Try not to use recursion

        Node current, closest;
        closest = current = root; // Start at the root
        int min_diff = Integer.MAX_VALUE; // Initialize the minimum difference to a large number

        // Use while loop to traverse from root to the closest leaf
        while (current != null) { 
            if (min_diff > Math.abs(search_key - current.key)) { // Update closest node if a smaller difference is found
                min_diff = Math.abs(search_key - current.key);
                closest = current;
            }

            if (current.key > search_key) { // Move left or right depending on whether the search key is smaller or larger than the current key
                current = current.left;
            } else if (current.key < search_key) {
                current = current.right;
            } else {
                return closest;
            }
        }

        return closest; // Return the closest node found
    }

    // Implement this function using the findClosestLeaf technique
    // Do not implement the recursive function
    public void insertKey(int key) { // Insert a new key into the tree using the findClosestLeaf() method
        // Implement insertKey() using the non-recursive version
        // This function should call findClosestLeaf()
        Node node = this.findClosestLeaf(this.root, key); 
        if (root == null) { // If the tree is empty, create a new root
            root = new Node(key); // Find the closest leaf where the new key should be inserted
        } else if (node == null) { // If the key already exists, print an error
            System.out.println("Duplicated key!!!");
        } else { // Otherwise, insert the key as the left or right child of the closest leaf
            if (node.key > key) {
                node.left = new Node(key);
            } else {
                node.right = new Node(key);
            }
        }
    }

    public void printPreOrderDFT() { // Method to print the nodes of the tree in PreOrder traversal
        System.out.print("PreOrder DFT node sequence [ ");
        // Call the recursive version
        this.printPreOrderDFT(this.root);
        System.out.println("]");
    }

    public static void printPreOrderDFT(Node node) { // Recursive method to perform PreOrder traversal 
        // this function should be recursive
        System.out.print(node.key + " ");
        if (node.left != null) // Visit the left subtree
            printPreOrderDFT(node.left);
        if (node.right != null) // Visit the right subtree
            printPreOrderDFT(node.right); 
    }

    public void printInOrderDFT() { // Method to print the nodes of the tree in InOrder traversal
        System.out.print("InOrder DFT node sequence [ ");
        // Call the recursive version
        this.printInOrderDFT(this.root);
        System.out.println("]");
    }

    public static void printInOrderDFT(Node node) { // Recursive method to perform InOrder traversal
        // this function should be recursive 
        if (node.left != null) // Visit the left subtree
            printInOrderDFT(node.left);
        System.out.print(node.key + " ");
        if (node.right != null) // Visit the right subtree
            printInOrderDFT(node.right);
    }

    public void printPostOrderDFT() { // Method to print the nodes of the tree in PostOrder traversal
        System.out.print("PostOrder DFT node sequence [ ");
        // Call the recursive version
        this.printPostOrderDFT(this.root);
        System.out.println("]");
    }

    public static void printPostOrderDFT(Node node) { // Recursive method to perform PostOrder traversal
        // this function should be recursive
        if (node.left != null) // Visit the left subtree
            printPostOrderDFT(node.left);
        if (node.right != null) // Visit the right subtree
            printPostOrderDFT(node.right);
        System.out.print(node.key + " ");
    }

    public static int height(Node node) { // Method to calculate the height of the tree recursively
        // Use recursion to implement this function
        // height = length(path{node->deepest child})
        if (node == null)
            return -1; // Base case: the height of an empty subtree is -1
        return 1 + Math.max(height(node.left), height(node.right)); // Recursively compute the height of the left and right subtrees
    }

    public static int size(Node node) {  // Method to calculate the size of the tree
        // Use recursion to implement this function
        // size = #children + 1(itself)
        if (node == null)
            return 0; // Base case: the size of an empty subtree is 0
        return 1 + size(node.left) + size(node.right); // Count the current node plus the size of the left and right subtrees
    }

    public static int depth(Node root, Node node) { // Method to calculate the depth of a node in the tree
        // Use recursion to implement this function
        // Similar to height() but start from node, go up to root
        // depth = length(path{node->root})
        if (root == null || node == null)
            return -1; // Base case: if the node is not in the tree, return -1
        return 1 + depth(root, node.parent); // Recursively calculate the depth by moving up to the parent
    }

    public int treeHeight() { // Tree height
        // Hint: call the static function
        return this.height(root); // Call the static height() method
    }

    public int treeSize() { // Tree size
        // Hint: call the static function
        return this.size(root); // Call the static size() method
    }

    public int treeDepth() { // Tree depth
        // Hint: call the static function
        return treeHeight(); // Since depth is the height from the root to the node, the depth of the root is the height of the tree
    }

    public Node findKthSmallest(int k) { // Recursive method to find the k-th smallest node in the tree
        return this.findKthSmallest(this.root, k); // Call the recursive version
    }

    public static Node findKthSmallest(Node node, int k) {
        // this function should be recursive
        int tsize = size(node.left); // The size of the left subtree determines the rank of the current node

        if (k == tsize + 1) {
            return node; // If the current node is the k-th smallest, return it
        } else if (k < tsize + 1) { // If k is less than the current node's rank, search in the left subtree
            return findKthSmallest(node.left, k);
        } else { // Otherwise, search in the right subtree
            return findKthSmallest(node.right, k - tsize - 1);
        }
    }

    public static Node findNext(Node node) { // Method to find the next node
        // this function should call other functions
        if (node.right != null)
            return leftDescendant(node.right); // The next node is the minimum node in the right subtree
        return rightAncestor(node); // Otherwise, it's the first right parent
    }

    public static Node leftDescendant(Node node) { // Recursive method to find the leftmost descendant (minimum node in a subtree)
        // this function should be recursive
        if (node == null) // Return null if the node is null
            return null;
        if (node.left == null) // Return the node if it has no left child 
            return node;
        return leftDescendant(node.left); // Recursively move to the left child
    }

    public static Node rightAncestor(Node node) { // Recursive method to find the first right ancestor
        // this function should be recursive
        if (node == null || node.parent == null)
            return null; // Return null if the node has no parent or is null
        if (node.parent.key > node.key) // If the parent is larger, it's the right ancestor
            return node.parent;
        return rightAncestor(node.parent); // Otherwise, move up to the next ancestor
    }

    public List rangeSearch(int x, int y) { // Method to perform a range search between two values x and y
        // This function utilizes findCloest() and findNext()
        // Use List list append(node) to add node to the list
        // List is the static Array
        List l = new List(100); // Create a new list to store the nodes in the range
        Node curr = findClosest(x); // Start at the closest node to x
        while (curr.key <= y) { // Traverse the tree, adding nodes within the range
            if (curr.key >= x) {
                l.append(curr);
            }
            curr = findNext(curr);
            if (curr == null)
                return l;
        }
        return l; // Return the list of nodes
    }

    // This function is for deleting the root node
    // If the node is not the root, please call the recursive version
    public void deleteKey(int key) { // Method to delete a node by its key
        // There should be 6 cases here
        // Non-root nodes should be forwarded to the static function
        if (root == null) {
            System.out.println("Empty Tree!!!");
            return;
        }
        Node node = findKey(key); // Find the node to delete
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

    // Use this function to delete non-root nodes
    public static void deleteKey(Node node) { // Static method to delete a non-root node
        // There should be 7 cases here
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
}
