public class BSTree extends BTreePrinter{
  Node root;
    
  public void singleRotateFromLeft(Node y) {
      // Check if the input node y is null. If it is, exit the method.
    if (y == null) return; 
    
    // Give beRotated get the left child of y.
    Node beRotated = y.left; 
    
    // Check if beRotated is not null.
    if (beRotated != null) {  
        // Store the parent of y in a parent.
        Node parent = y.parent; 
        
        // Get the right child of beRotated, which will become the left child of y after rotation.
        Node child = beRotated.right; 
        
        // Perform the rotation: make beRotated the new parent of y.
        beRotated.right = y; 
        y.parent = beRotated; 
        
        // Update the left child of y to be child.
        y.left = child; 
        
        // If child is not null, set its parent to y.
        if (child != null) {  
            child.parent = y; 
        }
        
        // If parent is not null, determine the position of beRotated relative to its parent.
        if (parent != null) { 
            // If beRotated is greater than its parent, it will become the right child of parent.
            if (beRotated.key > parent.key) { 
                parent.right = beRotated; 
            } else { // Otherwise, it becomes the left child.
                parent.left = beRotated; 
            }
            // Set the parent of beRotated to its new parent.
            beRotated.parent = parent; 
        } else { 
            // Otherwise update the root to beRotated.
            root = beRotated; 
            beRotated.parent = null; // Set the parent of beRotated to null.
        }
    }
  }

  public void singleRotateFromRight(Node y) {
      // Check if the input node y is null. If it is, exit the method.
    if (y == null) return; 
    
    // Give beRotated get the right child of y.
    Node beRotated = y.right; 
    
    // Check if beRotated is not null.
    if (beRotated != null) {  
        // Store the parent of y in a variable.
        Node parent = y.parent; 
        
        // Get the left child of beRotated, which will become the right child of y after rotation.
        Node child = beRotated.left; 
        
        // Perform the rotation: make beRotated the new parent of y.
        beRotated.left = y; 
        y.parent = beRotated; 
        
        // Update the right child of y to be child.
        y.right = child; 
        
        // If child is not null, set its parent to y.
        if (child != null) {  
            child.parent = y; 
        }
        
        // If parent is not null, determine the position of beRotated relative to its parent.
        if (parent != null) { 
            // If beRotated is greater than its parent, it will become the right child of parent.
            if (beRotated.key > parent.key) { 
                parent.right = beRotated; 
            } else { // Otherwise, it becomes the left child.
                parent.left = beRotated; 
            }
            // Set the parent of beRotated to its new parent.
            beRotated.parent = parent; 
        } else { 
            // Otherwise update the root to beRotated.
            root = beRotated; 
            beRotated.parent = null; // Set the parent of beRotated to null.
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
