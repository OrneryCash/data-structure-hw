public class HashiraCamp {
  private Stack stack;
  private String name;
  private int[] student;

  public HashiraCamp(String name, int[] arr) {
    this.name = name;
    this.student = arr;
    stack = new Stack();
  }

  public void PushToStack(int initialPower, int enterDay, int caretaker) {
    //START FIX HERE
    stack.Push(new Node(initialPower, enterDay, caretaker));
    //END FIX HERE
  }

  public void SolveProblem() {
    // index of each element in array is the enter month
    // value in array is the initial power

    System.out.println(name);
    for (int i = 0; i < student.length; i++) {
      //START FIX HERE
      int count = 0;
      if (stack.IsEmpty()) {
        //START FIX HERE
        PushToStack(student[i], i, 0);
        //END FIX HERE
      }else {
        //START FIX HERE
        int currInitialPower = student[i];
        Node prev = stack.Top();
        while (currInitialPower < prev.initialPower + (i - prev.enterDay)) {
          count += 1 + prev.caretaker;
          stack.Pop();
          if (!stack.IsEmpty()) {
            prev = stack.Top();
          } else {
            break;
          }
        }
        PushToStack(student[i], i, count);
        //END FIX HERE
      }
      
      // You can use this For-Loop method but believe me, it is not necessary.
      for (int j = i-1; j >= 0; j--) {
        //START FIX HERE when you have no choice 	(╥﹏╥)
        
        //END FIX HERE ʕっ•ᴥ•ʔっ
      }

      //Print the number of caretakers for new student
      // System.out.println("Entered Day:" + i + 
      //   ", Initial Powered: " +  student[i] + 
      //   ", Caretaker: " + count);

      stack.Top().PrintNode();
    }
  }

  public void ShowTimeComplexity() {
    // Choose the best Θ time complexity for this problem
    // System.out.println("Θ(log(n))");
    System.out.println("Θ(n)");
    // System.out.println("Θ(n^2)");
    // System.out.println("Θ(n^3)");
    // System.out.println("Θ(2^n)");
    // System.out.println("Θ(n!)");
    // Choose the best O time complexity for this problem
    // System.out.println("O(log(n))");
    // System.out.println("O(n)");
    System.out.println("O(n^2)");
    // System.out.println("O(n^3)");
    // System.out.println("O(2^n)");
    // System.out.println("O(n!)");
  }
  
  public void ShowStack() {
    Node currentNode = stack.Top();
    System.out.print("head -> ");
    while (currentNode != null) {
      currentNode.PrintNode();
      currentNode = currentNode.next;
    }
    System.out.println(" -> tail");
  }

}