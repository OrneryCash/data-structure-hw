class Node { //
  String name; // Declare the variable name as a string
  int value; // Declare the variable value as an int
  long timestamp; // Declare the variable timestamp as a long

  public Node(String name, int value) { // Constructor to initialize name and value for the node
      this.name = name; // Assign the provided name to the 'name' variable
      this.value = value; // Assign the provided value to the 'value' variable
  }
// This function will return true if Priority(thisNode) > Priority(otherNode)
// minHeap: the lower the value, the higher the priority
// maxHeap: the lower the value, the lower the priority
// If same value, the smaller the timestamp is, the higher the priority will be
  public boolean compare(Node other, boolean isMinHeap) {
    if (this.value == other.value) { // If values are equal, compare based on timestamp.
        return this.timestamp < other.timestamp; // Return true if this node's timestamp is earlier, indicating it has higher priority.
    }else { //In addition to that
        if (isMinHeap) { //For Min-Heap
            return this.value < other.value; //return true if this node's value is smaller.
        }else { //In addition to that
            return this.value > other.value; //return true if this node's value is larger.
        }
    }
  }

  public Node(){} // Dummy constructor, no need to edit

  // No need to edit, this function is for print node
  @Override
  public String toString() { // Returns a string representation of the node in the format: Customer: [name], Value: [value], Timestamp: [timestamp]
      return "Customer: " + name + ", Value: " + Integer.toString(value) + ", Timestamp: " + Long.toString(timestamp);
  }
}
