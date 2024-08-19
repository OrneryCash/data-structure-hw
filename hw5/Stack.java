public class Stack {
    Node[] arr; // regular array
    int capacity;
    int size;

    public Stack(int cap){
        this.arr = new Node[cap];
        this.capacity = cap;
        this.size = 0;
    }
    
    public void push(Node node){
        if (!isFull()){
            // do something
            arr[size++] = node;
        }else{
            System.out.println("Stack Overflow!!!");
        }
    }
    public Node pop(){
        if (!isEmpty()){
            // do something
            Node tmp = arr[--size];
            return tmp;
        }else{
            System.out.println("Stack Underflow!!!");
        }
        return null; // fix this (out of place)
    }
    public boolean isFull(){
        return size == capacity; // fix this
    }
    public boolean isEmpty(){
        return size == 0; // fix this
    }
    
    public void printStack(){
        if (!isEmpty()) {
            System.out.print("[Bottom] ");
            // do something here
            for (int i = 0; i < size; i++) {
                System.out.print(arr[i].data + " ");
            }
            System.out.println("[Top]");
        } else {
            System.out.println("Empty Stack!!!");
        }
    }
}