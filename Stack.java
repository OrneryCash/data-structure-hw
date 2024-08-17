public class Stack {
  // Implement Stack using Linked List without tail
  Node head;
  
  public void Push(Node node){
    //START FIX HERE
        if (head == null){
            // Do something
            head = node;
        }else{
            // Do something else
            node.next = head;
            head = node;
        }
    // END FIX HERE
  }
  
  public void Pop(){
    //START FIX HERE
        if (!IsEmpty()){
            // Do something
            head = head.next;
        }else{
            System.out.println("Error: Stack Underflow");
        }
    // END FIX HERE
  }
  
  public Node Top(){
    //START FIX HERE
        return head;
    // END FIX HERE
  }

  public Boolean IsEmpty() {
    //START FIX HERE
        return head == null;
    // END FIX HERE
  }

  
  
}