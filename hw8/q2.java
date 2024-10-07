public class Heap {
  private Node[] heap; // Array to store the heap nodes
  private int size; // The current number of nodes in the heap
  private int capacity; // The maximum number of nodes the heap can hold
  private boolean isMinHeap; // Flag to determine whether it's a Min-Heap (true/false)
  private String name; // Name or identifier for the heap
  private long timer; //long of timer

  public Heap(boolean isMinHeap, int capacity, String name) { //
      // Initialize the heap here
      // Don't forget that we will build the binary heap using...
      // ... the concept of "Complete binary tree based on the heapay implementation"
      // ... The 0 index will not be used, The index starts from 1 (remember?)
      
      this.heap = new Node[capacity+1]; // Create a new array of Nodes with size capacity + 1
      this.size = 1; // Start with size 1
      this.capacity = capacity; // Store the maximum capacity of the heap
      this.isMinHeap = isMinHeap; // Set whether this heap is a Min-Heap (true) or Max-Heap (false)
      this.name = name; // Assign the provided name to the heap
      this.timer = 0; //Set timer 0
  }

  public Node top(){
    return heap[1]; // Return the top node of the heap, which is at index 1
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
      
      while (csize != 1) { // Continue until the node is at the root or no swaps are needed
          if (heap[csize].compare(heap[csize/2], isMinHeap)) { // If the current node is smaller (for Min-Heap) or larger (for Max-Heap) than its parent
              swap(csize, csize/2);  //swap them
              csize /= 2; // Move up to the parent's index
          } else { //In addition to that
              break; // Stop 
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
      
      if (isEmpty()) { //If Empty
          System.out.println("The queue is empty"); //print "The queue is empty"
      }

      Node topp = top(); // Store the top node
      heap[1] = heap[size-1]; // Move the last node to the root position
      heap[size--] = null; // Decrease the heap size and make it null
      
      int csize = 1; // Start csize from the 1
      while (csize * 2 < size || csize * 2 + 1 < size) { 
          int hheap = csize; // Initialize hheap to the csize
          
          if (csize*2 < size) { // Check if there is a left child
              if (!heap[hheap].compare(heap[csize*2], isMinHeap)) { //If left child has higher priority
                  hheap = csize*2; // Update hheap
              } 
          }
          
          if (csize*2+1 < size) { // Check if there is a right child
              if (!heap[hheap].compare(heap[csize*2+1], isMinHeap)) { //If right child has higher priority
                  hheap = csize*2+1; // Update hheap
              }
          }
          
          if (heap[hheap].compare(heap[csize], isMinHeap)) { // If the current node is not in the correct position
              swap(csize, hheap); //swap it with the higher priority child
          } else {  //In addition to that
              break; // Stop
          }
          csize = hheap; //Change the of csize let it be hheap
      }
      
      return topp; //Return topp

  }

  private void swap(int i, int j) { // Swap the nodes at indices i and j in the heap array
      Node temp = heap[i]; // Store the node at index i in a temp variable
      heap[i] = heap[j]; // Move the node at index j to index i
      heap[j] = temp; // Place the temp node into index j
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
