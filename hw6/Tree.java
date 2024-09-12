// This Tree needs to inherit BTreePrinter
public class Tree extends BTreePrinter { // Fix this
    Node root;

    public Tree(Node root) {
        // fix this
        this.root = root;
    }

    public Tree() {
    } // Dummy constructor (No need to edit)

    public void printTree() {
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

    public Node findKey(int search_key) {
        return this.findKey(root, search_key); // Call the recursive version
    }

    public static Node findKey(Node node, int search_key) {
        // this function should be recursive
        // You should check null in this function
        if (node == null)
            return null;

        if (node.key == search_key) {
            return node;
        } else if (node.key > search_key) {
            return findKey(node.left, search_key);
        } else if (node.key < search_key) {
            return findKey(node.right, search_key);
        }
        return null;
    }

    public Node findMin() {
        return this.findMin(root); // Call the recursive version
    }

    public static Node findMin(Node node) {
        // this function should be recursive
        if (node == null)
            return null;
        if (node.left == null)
            return node;
        return findMin(node.left);
    }

    public Node findMax() {
        return this.findMax(root); // Call the recursive version
    }

    public static Node findMax(Node node) {
        // this function should be recursive
        if (node == null)
            return null;
        if (node.right == null)
            return node;
        return findMax(node.right);
    }

    public Node findClosestLeaf(int search_key) {
        this.findClosestLeaf(root, search_key); // Call the recursive version
    }

    public static Node findClosestLeaf(Node node, int search_key) {
        // this function should be recursive
        if (node == null)
            return null;

        if (node.key > search_key) {
            if (node.left == null)
                return node;
            return findClosestLeaf(node.left, search_key);
        } else if (node.key < search_key) {
            if (node.right == null)
                return node;
            return findClosestLeaf(node.right, search_key);
        }
        return null;
    }

    public Node findClosest(int search_key) {
        // Please use while loop to implement this function
        // Try not to use recursion

        Node current, closest;
        closest = current = root;
        int min_diff = Integer.MAX_VALUE;

        // Use while loop to traverse from root to the closest leaf
        while (current != null) {
            if (min_diff > Math.abs(search_key - current.key)) {
                min_diff = Math.abs(search_key - current.key);
                closest = current;
            }

            if (current.key > search_key) {
                current = current.left;
            } else if (current.key < search_key) {
                current = current.right;
            } else {
                return closest;
            }
        }

        return closest;
    }

    // Implement this function using the findClosestLeaf technique
    // Do not implement the recursive function
    public void insertKey(int key) {
        // Implement insertKey() using the non-recursive version
        // This function should call findClosestLeaf()
        Node node = this.findClosestLeaf(this.root, key);
        if (root == null) {
            root = new Node(key);
        } else if (node == null) {
            System.out.println("Duplicated key!!!");
        } else {
            if (node.key > key) {
                node.left = new Node(key);
            } else {
                node.right = new Node(key);
            }
        }
    }

    public void printPreOrderDFT() {
        System.out.print("PreOrder DFT node sequence [ ");
        // Call the recursive version
        this.printPreOrderDFT(this.root);
        System.out.println("]");
    }

    public static void printPreOrderDFT(Node node) {
        // this function should be recursive
        System.out.print(node.key + " ");
        if (node.left != null)
            printPreOrderDFT(node.left);
        if (node.right != null)
            printPreOrderDFT(node.right);
    }

    public void printInOrderDFT() {
        System.out.print("InOrder DFT node sequence [ ");
        // Call the recursive version
        this.printInOrderDFT();
        System.out.println("]");
    }

    public static void printInOrderDFT(Node node) {
        // this function should be recursive
        if (node.left != null)
            printInOrderDFT(node.left);
        System.out.print(node.key + " ");
        if (node.right != null)
            printInOrderDFT(node.right);
    }

    public void printPostOrderDFT() {
        System.out.print("PostOrder DFT node sequence [ ");
        // Call the recursive version
        this.printPostOrderDFT();
        System.out.println("]");
    }

    public static void printPostOrderDFT(Node node) {
        // this function should be recursive
        if (node.left != null)
            printPostOrderDFT(node.left);
        if (node.right != null)
            printPostOrderDFT(node.right);
        System.out.print(node.key + " ");
    }

    public static int height(Node node) {
        // Use recursion to implement this function
        // height = length(path{node->deepest child})
        if (node == null)
            return -1;
        return 1 + Math.max(height(node.left), height(node.right));
    }

    public static int size(Node node) {
        // Use recursion to implement this function
        // size = #children + 1(itself)
        if (node == null)
            return 0;
        return 1 + size(node.left) + size(node.right);
    }

    public static int depth(Node root, Node node) {
        // Use recursion to implement this function
        // Similar to height() but start from node, go up to root
        // depth = length(path{node->root})
        if (root == null || node == null)
            return -1;
        return 1 + depth(root, node.parent);
    }

    public int treeHeight() { // Tree height
        // Hint: call the static function
        return this.height(root);
    }

    public int treeSize() { // Tree size
        // Hint: call the static function
        return this.size(root);
    }

    public int treeDepth() { // Tree depth
        // Hint: call the static function
        return treeHeight();
    }

    public Node findKthSmallest(int k) {
        return this.findKthSmallest(this.root, k); // Call the recursive version
    }

    public static Node findKthSmallest(Node node, int k) {
        // this function should be recursive
        int tsize = size(node.left);

        if (k == tsize + 1) {
            return node;
        } else if (k < tsize + 1) {
            return findKthSmallest(node.left, k);
        } else {
            return findKthSmallest(node.right, k - tsize - 1);
        }
    }

    public static Node findNext(Node node) {
        // this function should call other functions
        if (node.right != null)
            return leftDescendant(node.right);
        return rightAncestor(node);
    }

    public static Node leftDescendant(Node node) {// Case 1 (findMin)
        // this function should be recursive
        if (node == null)
            return null;
        if (node.left == null)
            return node;
        return leftDescendant(node.left);
    }

    public static Node rightAncestor(Node node) {// Case 1 (first right parent)
        // this function should be recursive
        if (node == null || node.parent == null)
            return null;
        if (node.parent.key > node.key)
            return node.parent;
        return rightAncestor(node.parent);
    }

    public List rangeSearch(int x, int y) {
        // This function utilizes findCloest() and findNext()
        // Use List list append(node) to add node to the list
        // List is the static Array
        List l = new List(100);
        Node curr = findClosest(x);
        while (curr.key <= y) {
            if (curr.key >= x) {
                l.append(curr);
            }
            curr = findNext(curr);
            if (curr == null)
                return l;
        }
        return l;
    }

    // This function is for deleting the root node
    // If the node is not the root, please call the recursive version
    public void deleteKey(int key) {
        // There should be 6 cases here
        // Non-root nodes should be forwarded to the static function
        if (root == null) {
            System.out.println("Empty Tree!!!");
            return;
        }
        Node node = findKey(key);
        if (node != null) {
            if (node == root) {
                if (root.left == null && root.right == null) {
                    root = null;
                } else if (root.left == null) {
                    Node minr = findMin(root.right);
                    root = root.right;
                    minr.left = node;
                } else if (root.right == null) {
                    root = root.left;
                } else {
                    Node minr = findMin(root.right);
                    root.key = minr.key;
                    this.deleteKey(minr);
                }
            } else {
                this.deleteKey(node);
            }
        } else {
            System.out.println("Key not found!!!");
        }
    }

    // Use this function to delete non-root nodes
    public static void deleteKey(Node node) {
        // There should be 7 cases here
        if (node.left == null && node.right == null) {
            Node curr = node.parent;
            if (curr.left == node)
                curr.left = null;
            else
                curr.right = null;
        } else if (node.left == null) {
            Node curr = node.parent;
            if (curr.left == node)
                curr.left = node.right;
            else
                curr.right = node.right;
            node.right.parent = curr;
            node.right = null;
        } else if (node.right == null) {
            Node curr = node.parent;
            if (curr.left == node)
                curr.left = node.left;
            else
                curr.right = node.left;
            node.left.parent = curr;
            node.left = null;
        } else {
            Node minr = findMin(node.right);
            node.key = minr.key;
            deleteKey(minr);
        }
    }
}
