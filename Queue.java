public class Queue {
  // Implement Queue using Linked List with tail
  OrderNode head;
  OrderNode tail;
  
  public void Push(OrderNode node){
    //START FIX HERE
        if (head == null && tail == null){
            head = node;
            tail = node;
        }else{
            tail.next = node;
            tail = tail.next;
        }
    //END FIX HERE
  }
  
  public void Pop(){
    //START FIX HERE
        if (head != null && tail != null){
            if (head != tail){
                OrderNode curr = head.next;
                head = curr;
            }else{
                head = null;
                tail = null;
            }
        } else {
            System.out.println("Error: Queue Underflow");
        }
    //END FIX HERE
  }
  
  public OrderNode Top(){
    //START FIX HERE
      return head;
    //END FIX HERE
  }
  
}
