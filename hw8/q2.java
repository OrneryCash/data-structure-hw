public class Heap {
  private Node[] heap;
  private int size;
  private int capacity;
  private boolean isMinHeap;
  private String name;
  private long timer;

  public Heap(boolean isMinHeap, int capacity, String name) {
      // Initialize the heap here
      // Don't forget that we will build the binary heap using...
      // ... the concept of "Complete binary tree based on the heapay implementation"
      // ... The 0 index will not be used, The index starts from 1 (remember?)
      
      this.heap = new Node[capacity+1];
      this.size = 1;
      this.capacity = capacity;
      this.isMinHeap = isMinHeap;
      this.name = name;
      this.timer = 0;
  }

  public Node top(){
    return heap[1]; // FIX THIS
  }

  public void push(Node node){
      // Increase timer each time you push something into the Queue
      timer++;
      node.timestamp = timer; // Stamp the time number to the node
      
      // To do:
      // 1. Push the new node at the end of the array (via back pointer)
      // 2. Sift (percolate) it up the heap
      //      * Check priority of the current node with its parent
      //      * Swap the current node if the priority is higher than the parent
      //      * Repeat the process until reaching the root or there is no swap (Pls use while loop)
      // 3. Increase the heap size
      heap[size] = node;
      int csize = size++;
      
      while (csize != 1) {
          if (heap[csize].compare(heap[csize/2], isMinHeap)) {
              swap(csize, csize/2);
              csize /= 2;
          } else {
              break;
          }
      }
      
  }

  public Node pop(){
      
      // To do:
      // 1. Mark the root for return (Don't forget to return this node)
      // 2. Move the last node to the root (change pointer, set null)
      // 3. Decrease the heap size
      // 4. Sift (percolate) it down the heap
      //      * Check priority of the current node with both children
      //      * Swap the current node if the priority is lower than child
      //      * Repeat the process until the node has no child or there is no swap (Pls use while loop)
      
      if (isEmpty()) {
          System.out.println("The queue is empty");
      }

      Node topp = top();
      heap[1] = heap[size-1];
      heap[size--] = null;
      
      int csize = 1;
      while (csize * 2 < size || csize * 2 + 1 < size) {
          int hheap = csize;
          
          if (csize*2 < size) {
              if (!heap[hheap].compare(heap[csize*2], isMinHeap)) {
                  hheap = csize*2;
              } 
          }
          
          if (csize*2+1 < size) {
              if (!heap[hheap].compare(heap[csize*2+1], isMinHeap)) {
                  hheap = csize*2+1;
              }
          }
          
          if (heap[hheap].compare(heap[csize], isMinHeap)) {
              swap(csize, hheap);
          } else {
              break;
          }
          csize = hheap;
      }
      
      return topp; // FIX THIS

  }

  private void swap(int i, int j) {
      Node temp = heap[i];
      heap[i] = heap[j];
      heap[j] = temp;
  }

  public void printArray() {
        // No need to fix this function
        System.out.printf("-----------------\n%s Heap:\n", name);
        if (isEmpty()) System.out.print("Empty Heap");
        for (int i = 1; i < size; i++) {
            System.out.printf("%d] %s\n", i, heap[i].toString());
        }
        System.out.print("-----------------\n");
    }

  public boolean isEmpty() {
      return size == 1;
  }
}
