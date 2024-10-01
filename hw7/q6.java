public class AVLTree extends BTreePrinter{
    Node root;

    public AVLTree(Node root){
        this.root = root;
    }
    
    public void singleRotateFromLeft(Node y) {
        // Pls copy the code from the previous problem
        if (y == null) return;
        Node beRotated = y.left;
        if (beRotated != null) {
          Node parent = y.parent;
          Node child = beRotated.right;
          
          beRotated.right = y;
          y.parent = beRotated;
          
          y.left = child;
          if (child != null) {
              child.parent = y;
          }
          
          if (parent != null) {
              if (beRotated.key > parent.key) {
                  parent.right = beRotated;
              } else {
                  parent.left = beRotated;
              }
              beRotated.parent = parent;
          } else {
              root = beRotated;
              beRotated.parent = null;
          }
        }
    }
    
    public void singleRotateFromRight(Node y) {
        // Pls copy the code from the previous problem
        if (y == null) return;
        Node beRotated = y.right;
        if (beRotated != null) {
          Node parent = y.parent;
          Node child = beRotated.left;
          
          beRotated.left = y;
          y.parent = beRotated;
          
          y.right = child;
          if (child != null) {
              child.parent = y;
          }
          
          if (parent != null) {
              if (beRotated.key > parent.key) {
                  parent.right = beRotated;
              } else {
                  parent.left = beRotated;
              }
              beRotated.parent = parent;
          } else {
              root = beRotated;
              beRotated.parent = null;
          }
        }
    }
    
    public void doubleRotateFromLeft(Node y) {
        // Pls copy the code from the previous problem
        if (y == null) return;
        Node beRotated = y.left;
        if (beRotated != null) {
          Node parent = y.parent;
          Node child = beRotated.right;
          
          Node childLeft = child.left;
          Node childRight = child.right;
          
          child.left = beRotated;
          beRotated.parent = child;
          
          beRotated.right = childLeft;
          if (childLeft != null) {
              childLeft.parent = beRotated;
          }
          
          y.left = child;
          child.parent = y;
          
          
          child.right = y;
          y.left = childRight;
          
          y.parent = child;
          if (childRight != null) {
              childRight.parent = y;
          }
          
          if (parent != null) {
              if (beRotated.key > parent.key) {
                  parent.right = child;
              } else {
                  parent.left = child;
              }
              child.parent = parent;
          } else {
              root = child;
              child.parent = null;
          }
        }
    }
    
    public void doubleRotateFromRight(Node y) {
        // Pls copy the code from the previous problem
        if (y == null) return;
        Node beRotated = y.right;
        if (beRotated != null) {
          Node parent = y.parent;
          Node child = beRotated.left;
          
          Node childLeft = child.left;
          Node childRight = child.right;
          
          child.right = beRotated;
          beRotated.parent = child;
          
          beRotated.left = childRight;
          if (childRight != null) {
              childRight.parent = beRotated;
          }
          
          y.right = child;
          child.parent = y;
          
          
          child.left = y;
          y.right = childLeft;
          
          y.parent = child;
          if (childLeft != null) {
              childLeft.parent = y;
          }
          
          if (parent != null) {
              if (beRotated.key > parent.key) {
                  parent.right = child;
              } else {
                  parent.left = child;
              }
              child.parent = parent;
          } else {
              root = child;
              child.parent = null;
          }
        }
    }
    
    public static void rebalance(AVLTree tree, Node node){
        // Pls copy the code from the previous problem
        int balanceFactor = height(node.left) - height(node.right);
        if (Math.abs(balanceFactor) > 1){
            if (balanceFactor > 0){
                if (height(node.left.left) > height(node.left.right)){
                    System.out.println("Perform SingleRotationFromLeft(Node " + node.key +")");
                    tree.singleRotateFromLeft(node);
                }else{
                    System.out.println("Perform DoubleRotationFromLeft(Node " + node.key +")");
                    tree.doubleRotateFromLeft(node);
                }
            }else{
                if (height(node.right.left) > height(node.right.right)){
                    System.out.println("Perform DoubleRotationFromRight(Node " + node.key +")");
                    tree.doubleRotateFromRight(node);
                }else{
                    System.out.println("Perform SingleRotationFromRight(Node " + node.key +")");
                    tree.singleRotateFromRight(node);
                }
            }
        }
    }
    
    
    public static Node findKey(Node node, int search_key) {
        // Pls copy the code from the previous problem
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
        // Pls copy the code from the previous problem
        if (node == null) // If the node is null, return null
            return null;
        if (node.left == null) // The minimum is the leftmost node, so return when the left child is null
            return node;
        return findMin(node.left); // move to the left subtree
    }

    public static Node findMax(Node node){
        // Pls copy the code from the previous problem
        if (node == null) // If the node is null, return null
            return null;
        if (node.right == null) // The maximum is the rightmost node, so return when the right child is null
            return node;
        return findMax(node.right); // move to the right subtree
    }

    public void insertKey(int key) {
        // Pls copy the code from the previous problem
        if (root == null) {
            root = new Node(key);
        } else {
            insertKey(this, root, key);
        }
    }

    public static void insertKey(AVLTree tree, Node node, int key) {
        // Pls copy the code from the previous problem (with the rebalancing feature)
        if (key == node.key) {
            System.out.println("Duplicated key:" + key);
        }else if (key < node.key) {//Go left
            if (node.left == null) {
                node.left = new Node(key);
                node.left.parent = node;
            }else {
                insertKey(tree, node.left, key);
            }
            rebalance(tree, node);
        }else{  // Go right
            if (node.right == null) {
                node.right = new Node(key);
                node.right.parent = node;
            }else {
                insertKey(tree, node.right, key);
            }
            rebalance(tree, node);
        }
    }
    
    public void deleteKey(int key) {
        // Pls copy the code from the previous problem
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
                    this.deleteKey(this, minr); // Delete the minimum node
                }
            } else {
                this.deleteKey(this, node); // If the node is not the root, call the static deleteKey method
            }
        } else {
            System.out.println("Key not found!!!"); // Error message if the key doesn't exist
        }
    }
    
    public static void deleteKey(AVLTree tree, Node node){
        // Pls copy the code from the previous problem (with the rebalacing feature)
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
            deleteKey(tree, minr); // Recursively delete the minimum node
        }
        
        Node parent = node.parent;
        while (parent != null) {
            rebalance(tree, parent);
            parent = parent.parent;
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
        if (isMergeable(r1, r2)) { // Check if the two trees r1 and r2 can be merged
            // Calculate the heights of both trees
            int h1 = height(r1);
            int h2 = height(r2);
            
            if (Math.abs(h1-h2) <= 1) { // If the heights differ by at most 1, merge directly with t as the root
                t.left = r1;  // Assign r1 as the left subtree of t
                r1.parent = t; // Set the parent of r1 to t
                
                t.right = r2; // Assign r2 as the right subtree of t
                r2.parent = t; // Set the parent of r2 to t
                
                return t; // Return t as the new root of the merged tree
            } else if (h1 > h2) { // If the height of r1 is greater than r2, merge r2 into the right subtree of r1
                Node tmp = mergeWithRoot(r1.right, r2, t); // Recursively merge r1.right with r2 and t
                r1.right = tmp; // Set the merged result as the right child of r1
                tmp.parent = r1; // Update the parent reference of the merged subtree
                return r1; // Return r1 as the new root after merging
            } else { // If the height of r2 is greater than r1, merge r1 into the left subtree of r2
                Node tmp = mergeWithRoot(r1, r2.left, t); // Recursively merge r1 with r2.left and t
                r2.left = tmp; // Set the merged result as the left child of r2
                tmp.parent = r2; // Update the parent reference of the merged subtree
                return r2; // Return r2 as the new root after merging
            }
        } else {
            System.out.println("All nodes in T1 must be smaller than all nodes from T2");  // Print an error message if the two trees are not mergeable
            return null; // Return null to indicate that the merge is not possible
        }
    }
    
    public void merge(AVLTree tree2){
        if (isMergeable(this.root, tree2.root)){ // Check if the two trees are mergeable
            Node t = findMax(this.root); // Find the maximum node in the current tree
            deleteKey(t.key); // Delete the maximum node from the current tree
            this.root = mergeWithRoot(this.root, tree2.root, t); // Merge the two trees with t as the new root and update this tree's root
            rebalance(this, root); // After merging, rebalance the entire tree to maintain AVL tree properties
        }else{
            System.out.println("All nodes in T1 must be smaller than all nodes from T2"); // Print an error message if the trees are not mergeable
        }
    }

    // This function is complete, no need to edit
    public static int height(Node node){
        if (node == null) //If the node is null, return -1
            return -1;
        else // Recursively calculate the height of the left and right subtrees
            return 1 + Math.max(height(node.left), height(node.right)); // The height of the current node is 1 plus the maximum of the heights of the left and right children
    }

    // This function is complete, no need to edit
    public void printTree() {
        if (root == null) {
            System.out.println("Empty tree!!!");
        } else {
            super.printTree(root);
        }
    }
    
    public AVLTree() {} // Dummy Constructor, no need to edit
}
