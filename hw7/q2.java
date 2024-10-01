public class BSTree extends BTreePrinter{
    Node root;
      
    public void doubleRotateFromLeft(Node y) {
    // Check if the input node y is null. If it is, exit the method.
    if (y == null) return;

    // Give beRotated get the left child of y.
    Node beRotated = y.left;

    // Check if beRotated is not null.
    if (beRotated != null) {
        // Store the parent of y in a variable.
        Node parent = y.parent;

        // Get the right child of beRotated, which will be the new child after rotation.
        Node child = beRotated.right;

        // Store the left and right children of the child node.
        Node childLeft = child.left;
        Node childRight = child.right;

        // Perform the first rotation: make child the left child of y.
        child.left = beRotated;
        beRotated.parent = child;

        // Update the right child of beRotated to be its original left child.
        beRotated.right = childLeft;
        if (childLeft != null) {
            childLeft.parent = beRotated; // Update the parent of childLeft to be beRotated.
        }

        // Update y's left child to be the child node.
        y.left = child;
        child.parent = y; // Set the parent of child to y.

        // Now perform the second rotation: make child the new parent of y.
        child.right = y;
        y.left = childRight; // Set y's left child to childRight.

        y.parent = child; // Set the parent of y to child.
        if (childRight != null) {
            childRight.parent = y; // Update the parent of childRight to y.
        }

        // If y has a parent, determine the position of child relative to its parent.
        if (parent != null) {
            // If beRotated is greater than its parent, child becomes the right child of parent.
            if (beRotated.key > parent.key) {
                parent.right = child;
            } else { // Otherwise, it becomes the left child.
                parent.left = child;
            }
            child.parent = parent; // Set the parent of child to its new parent.
        } else { // Otherwise update the root to child.
            root = child;
            child.parent = null; // Set the parent of child to null.
        }
    }
}

    public void doubleRotateFromRight(Node y) {
    // Check if the input node y is null. If it is, exit the method.
    if (y == null) return;
    
    // Give beRotated get the right child of y.
    Node beRotated = y.right;
    
    // Check if beRotated is not null.
    if (beRotated != null) {
        // Store the parent of y in a variable.
        Node parent = y.parent;
        
        // Get the left child of beRotated, which will be the new child after rotation.
        Node child = beRotated.left;

        // Store the left and right children of the child node.
        Node childLeft = child.left;
        Node childRight = child.right;

        // Perform the first rotation: make child the right child of y.
        child.right = beRotated; // Set the right child of child to beRotated.
        beRotated.parent = child; // Update the parent of beRotated to child.

        // Update the left child of beRotated to be childRight.
        beRotated.left = childRight; 
        if (childRight != null) {
            childRight.parent = beRotated; // Update the parent of childRight to beRotated.
        }

        // Update y's right child to be the child node.
        y.right = child; 
        child.parent = y; // Set the parent of child to y.

        // Now perform the second rotation: make child the new parent of y.
        child.left = y; // Set the left child of child to y.
        y.right = childLeft; // Set y's right child to childLeft.

        y.parent = child; // Set the parent of y to child.
        if (childLeft != null) {
            childLeft.parent = y; // Update the parent of childLeft to y.
        }

        // If y has a parent, determine the position of child relative to its parent.
        if (parent != null) {
            // If beRotated is greater than its parent, child becomes the right child of parent.
            if (beRotated.key > parent.key) {
                parent.right = child;
            } else { // Otherwise, it becomes the left child.
                parent.left = child;
            }
            child.parent = parent; // Set the parent of child to its new parent.
        } else {  // Otherwise update the root to child.
            root = child;
            child.parent = null; // Set the parent of child to null.
        }
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
