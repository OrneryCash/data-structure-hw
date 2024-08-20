public class Stack { //create class stack 
    Node[] arr; // regular array
    int capacity;
    int size;

    public Stack(int cap){ //create constructor that create array for stack which its capacity is input 
        this.arr = new Node[cap];
        this.capacity = cap;
        this.size = 0;
    }
    
    public void push(Node node){//funciton that push node into array
        if (!isFull()){ //check if stack is not full
            // do something
            arr[size++] = node; //when stack is not full set index size+1 of array to contain node 
        }else{//when stack is full, then print Stack Overflow
            System.out.println("Stack Overflow!!!");
        }
    }
    public Node pop(){ //function that pop node from array 
        if (!isEmpty()){ //check if stack is not empty
            // do something
            Node tmp = arr[--size]; //create node name tmp to contain node in the last index of array 
            return tmp; //return node that pop
        }else{ //when stack is empty, then print Stack Underflow
            System.out.println("Stack Underflow!!!");
        }
        return null; // fix this (out of place)
    }
    public boolean isFull(){ //function that check if size is full 
        return size == capacity; // fix this
    }
    public boolean isEmpty(){//function that check if size is empty 
        return size == 0; // fix this
    }
    
    public void printStack(){ //print all of node in stack 
        if (!isEmpty()) {//check if stack is not empty
            System.out.print("[Bottom] ");
            // do something here
            for (int i = 0; i < size; i++) { //loop that continue until i equal size of array 
                System.out.print(arr[i].data + " "); //print data of array index i 
            }
            System.out.println("[Top]");
        } else {//check if stack is empty, then print Empty Stack!!!
            System.out.println("Empty Stack!!!");
        }
    }
}