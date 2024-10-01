public class AVLTree extends BTreePrinter{
    Node root;

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
    
    // This function is for deleting the root node
    // If the node is not the root, please call the recursive version
    public void deleteKey(int key) {
        // Pls copy the code from the previous homework
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
                    this.deleteKey(this, minr); // Delete the minimum node
                }
            } else {
                this.deleteKey(this, node); // If the node is not the root, call the static deleteKey method
            }
        } else {
            System.out.println("Key not found!!!"); // Error message if the key doesn't exist
        }
    }
    
    // Use this function to delete non-root nodes
    // Also, fix the code to have the rebalancing feature
    public static void deleteKey(AVLTree tree, Node node){
        // Pls copy the code from the previous homework
        // Add code segments to enable the rebalancing feature
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
    

    // This function is complete, no need to edit
    public Node findKey(int search_key) {
        return Main.findKey(root, search_key);
    }

    // This function is complete, no need to edit
    public static Node findMin(Node node){
        if (node.left == null)
            return node;
        else
            return findMin(node.left);
    }

    // Use this function to check the node height
    // This function is complete, no need to edit
    public static int height(Node node){
        if (node == null)
            return -1;
        else
            return 1 + Math.max(height(node.left), height(node.right));
    }
}
