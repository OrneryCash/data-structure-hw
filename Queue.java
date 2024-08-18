public class Queue {
  // Implement Queue using Linked List with tail
  OrderNode head;
  OrderNode tail;
  
  public void Push(OrderNode node){ // Pushing a node that contain orders into queue
    //START FIX HERE
        if (head == null && tail == null){ // check if node is empty
        //when there is no node in Linked list change head and tail address to node address
            head = node;
            tail = node;
        }else{
          //when node is not empty push it to the back of Linked list and change it to tail
            tail.next = node;
            tail = tail.next;
        }
    //END FIX HERE
  }
  
  public void Pop(){ // pop out the first node of Linked list
    //START FIX HERE
        if (head != null && tail != null){ //check if Linked list is empty
            if (head != tail){ //check if there is only 1 node in LinkedList
              //when there are more than 1 node in Linked List change head address to its next node
                OrderNode curr = head.next;
                head = curr;
            }else{
              //if there is only 1 node in Linked List change head and tail address to null
                head = null;
                tail = null;
            }
        } else {
            System.out.println("Error: Queue Underflow"); //If Linked List is empty, then print Error:Queue Undeflow
        }
    //END FIX HERE
  }
  
  public OrderNode Top(){ //get the head of Linked List 
    //START FIX HERE
      return head;
    //END FIX HERE
  }
  
}
