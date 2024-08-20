public class Queue { //create a class queue that implement circular array
    Node[] arr; // circular array
    int capacity;
    int front;
    int back;
    int size;
    
    public Queue(int cap){ //create constructor that create array that has capacity as input 
        this.arr = new Node[cap]; 
        this.capacity = cap;
        this.front = 0;
        this.back = 0;
        this.size = 0;
    }
    
    public void enqueue(Node node){ //function that enqueue a node into queue
        if (!isFull()){ //check if queue is not empty
            //when queue is not full
            arr[back++] = node; //set index back+1 of array to contain node   
            if (back == capacity) { //check if back is at the last index of array
                back = 0; //set back into index 0 of array
            }
            size++; //increase size 
            
        }else{ //if queue is empty print Queue Overflow
            System.out.println("Queue Overflow!!!");
        }
    }
    
    public Node dequeue(){ //function that dequeue a node from queue
        
        if (!isEmpty()){ //check if queue is not empty
            // do something
            Node tmp = arr[front++]; //create a node name tmp to contain node at index front+1 of array 
            if (front == capacity) { //check if front is at the last index of array 
                front = 0; //set front into index 0 of array
            }
            size--; //decrease size
            return tmp; //return tmp 
            
        }else{ //if queue is empty print Queue Underflow
            System.out.println("Queue Underflow!!!");
        }
        return null; // fix this (out of place)
    }
    
    public boolean isEmpty(){ //function that return if size is 0
        return size == 0; // fix this
    }
    
    public boolean isFull(){ //function that return if size equal capacity
        return size == capacity; // fix this
    }
    
    public void printCircularIndices(){ //function that print front and back index of array
        System.out.println("Front index = " + front + " Back index = " + back);
    }
    
    public void printQueue(){ //function that print queue
        if (!isEmpty()){ //check if queue is not empty
            System.out.print("[Front] "); 
            int curr = front; //create integer name curr to contain value of front
            for (int i = 0; i < size; i++) { //loop that continue until i equal size of member in array 
                System.out.print(arr[curr++].data + " ");
                if (curr == capacity) { //check if curr equal capacity
                    curr = 0; //if curr is the last index of array set it to the first index of array 
                }
            }
            System.out.println("[Back]");
        }else{ //if queue is empty print Empty Queue
            System.out.println("Empty Queue!!!");
        }
    }
}