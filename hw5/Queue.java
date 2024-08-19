public class Queue {
    Node[] arr; // circular array
    int capacity;
    int front;
    int back;
    int size;
    
    public Queue(int cap){
        this.arr = new Node[cap];
        this.capacity = cap;
        this.front = 0;
        this.back = 0;
        this.size = 0;
    }
    
    public void enqueue(Node node){
        if (!isFull()){
            // do something
            arr[back++] = node;
            if (back == capacity) {
                back = 0;
            }
            size++;
            
        }else{
            System.out.println("Queue Overflow!!!");
        }
    }
    
    public Node dequeue(){
        
        if (!isEmpty()){
            // do something
            Node tmp = arr[front++];
            if (front == capacity) {
                front = 0;
            }
            size--;
            return tmp;
            
        }else{
            System.out.println("Queue Underflow!!!");
        }
        return null; // fix this (out of place)
    }
    
    public boolean isEmpty(){
        return size == 0; // fix this
    }
    
    public boolean isFull(){
        return size == capacity; // fix this
    }
    
    public void printCircularIndices(){
        System.out.println("Front index = " + front + " Back index = " + back);
    }
    
    public void printQueue(){
        if (!isEmpty()){
            System.out.print("[Front] ");
            int curr = front;
            for (int i = 0; i < size; i++) {
                System.out.print(arr[curr++].data + " ");
                if (curr == capacity) {
                    curr = 0;
                }
            }
            System.out.println("[Back]");
        }else{
            System.out.println("Empty Queue!!!");
        }
    }
}