public class DynamicArray {
  private int[] arr;
  private int capacity;
  private int size; // Last element can be indexed at size-1
  
  public DynamicArray(int cap){ // Class Constructor
      this.arr = new int[cap];
      this.capacity = cap;
      this.size = 0;
  }
  
  public void PushBack(int data){
      // START FIX CODE HERE
      if (size >= capacity) {
        capacity *= 2;
        int[] tmp = new int[capacity];
        for (int i = 0; i < size; i++) {
          tmp[i] = arr[i];
        }
        arr = tmp;
      }
      arr[size] = data;
      size++;
      // END CODE HERE
  }
  public int PopBack(){
      // START FIX CODE HERE
      if (IsEmpty()) {
        System.out.println("ERROR");
        return 0;
      }
      int tmp = arr[size-1];
      size--;
      return tmp;
  }

  public int Get(int i){
      // START FIX CODE HERE
      if (i < 0 || i > size-1) {
        System.out.println("ERROR");
        return 0;
      }
      return arr[i];
      // END CODE HERE
  }

  public void Set(int i, int value){
      // START FIX CODE HERE
      if (i < 0 || i > size-1) {
        System.out.println("ERROR");
      } else {
        arr[i] = value;
      }
      // END CODE HERE
  }
  
  public void Remove(int i){
      // START FIX CODE HERE
      if (i < 0 || i > size-1) {
        System.out.println("ERROR");
      } else {
        for (int j = i; j < size-1; j++) {
            arr[j] = arr[j+1];
        }
        size--;
      }
      // END CODE HERE
  }
  
  public boolean IsEmpty(){
      // START FIX CODE HERE
      return size == 0;
      // END CODE HERE
  }
  
  public int GetSize(){
      // START FIX CODE HERE
      return size;
      // END CODE HERE
  }
  
  public void PrintStructure(){
    // START FIX CODE HERE
    System.out.print("Size = " + size + ", Cap = " + capacity + ", arr = [ ");
    if (!IsEmpty()) {
        for (int i = 0; i < size-1; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.print(arr[size-1]);
        System.out.println(" ]");
    } else {
        System.out.println("]");
    }
      // END CODE HERE
  } 
}
