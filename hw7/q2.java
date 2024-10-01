public class BSTree extends BTreePrinter{
    Node root;
      
    public void doubleRotateFromLeft(Node y) {
        // Do something
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
        // Do something
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
    
    public void insertKey(int key) {
        if (root == null) {
            root = new Node(key);
        } else {
            Main.insertKey(root, key);
        }
    }
    
    public void printTree() {
        if (root == null) {
            System.out.println("Empty tree!!!");
        } else {
            super.printTree(root);
        }
    }

    public Node findKey(int search_key) {
        return Main.findKey(root, search_key);
    }
}
