public class BSTree extends BTreePrinter{
  Node root;
    
  public void singleRotateFromLeft(Node y) {
      // Do something
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
      // Do something
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
