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
        int balanceFactor = height(node.left) - height(node.right);              // Calculate balanceFactor
        if (Math.abs(balanceFactor) > 1){                          // Use balanceFactor to check if unbalanced?
            if (balanceFactor > 0){                      // Use balanceFactor to check if left heavy?
                if (height(node.left.left) > height(node.left.right)){                  // Use the grandchild to check if Outer or Inner?
                    System.out.println("Perform SingleRotationFromLeft(Node " + node.key +")");   // Fix ??? and call a function
                    tree.singleRotateFromLeft(node);
                }else{
                    System.out.println("Perform DoubleRotationFromLeft(Node " + node.key +")");   // Fix ??? and call a function
                    tree.doubleRotateFromLeft(node);
                }
            }else{
                if (height(node.right.left) > height(node.right.right)){                  // Use the grandchild to check if Outer or Inner?
                    System.out.println("Perform DoubleRotationFromRight(Node " + node.key +")");   // Fix this and call a function
                    tree.doubleRotateFromRight(node);
                }else{
                    System.out.println("Perform SingleRotationFromRight(Node " + node.key +")");   // Fix this and call a function
                    tree.singleRotateFromRight(node);
                }
            }
        }
    }
    
    // Fix this function to have the rebalancing feature
    // There should be rebalance() function calling somewhere in the code
    public static void insertKey(AVLTree tree, Node node, int key) {
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
    
    // This function is complete, no need to edit
    public void insertKey(int key) {
        if (root == null) {
            root = new Node(key);
        } else {
            insertKey(this, root, key);
        }
    }
    
    // This function is complete, no need to edit
    public Node findKey(int search_key) {
        return Main.findKey(root, search_key);
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
