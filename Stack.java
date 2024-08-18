public class Stack {
  // Implement Stack using Linked List without tail
  Node head;
  
  public void Push(Node node){ //function which adds node to the front of Linked List 
    //START FIX HERE
        if (head == null){ //check if Linked list is empty
            //When list is empty change head address to node
            head = node;
        }else{
            //When list is not empty 
            node.next = head; //change node next node address to head
            head = node; //change head address to node address
        }
    // END FIX HERE
  }
  
  public void Pop(){ //function which delete node at the front of Linked list (Last out)
    //START FIX HERE
        if (!IsEmpty()){ //check if Linked list is empty
            //if true then change head address to its next node address;
            head = head.next;
        }else{ //if Linked List is not empty print Error: Stack Underflow
            System.out.println("Error: Stack Underflow");
        }
    // END FIX HERE
  }
  
  public Node Top(){ //function which return Linked List first node (view first node)
    //START FIX HERE
        return head;
    // END FIX HERE
  }

  public Boolean IsEmpty() { //function which check if Linked List is empty
    //START FIX HERE
        return head == null;
    // END FIX HERE
  }

  
  
}