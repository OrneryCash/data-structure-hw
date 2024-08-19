public class HashiraCamp {
  private Stack stack;
  private String name;
  private int[] student;

  public HashiraCamp(String name, int[] arr) {
    this.name = name;
    this.student = arr;
    stack = new Stack();
  }

  public void PushToStack(int initialPower, int enterDay, int caretaker) { //adding new student to the camp
    //START FIX HERE
    stack.Push(new Node(initialPower, enterDay, caretaker));
    //END FIX HERE
  }

  public void SolveProblem() { //function that calculate amount of caretaker for newcomer each month
    // index of each element in array is the enter month
    // value in array is the initial power

    System.out.println(name); //print the name of the HashiraCamp
    for (int i = 0; i < student.length; i++) { //loop for adding newcomer and calculate newcomer's caretaker
      //START FIX HERE
      int count = 0; //create a count variable  that reset to 0 every month
      if (stack.IsEmpty()) { //check if stack is empty
        //START FIX HERE
        //when stack is empty push a new student to stack without finding his caretaker 
        PushToStack(student[i], i, 0);
        //END FIX HERE
      }else {
        //START FIX HERE
        //when stack is not empty
        int currInitialPower = student[i]; //create currInitialPower variable to contain latest student's Initial power
        Node prev = stack.Top(); //create a Node name prev to contain latest student before newcomer
        while (currInitialPower < prev.initialPower + (i - prev.enterDay)) { //loop that continue while's latest student initial power lower than previous student's initial power  
          count += 1 + prev.caretaker; //change count variable by 1 plus the caretaker(s) of previous student if condition of loop is true 
          stack.Pop(); //pop the newcomer
          if (!stack.IsEmpty()) { //check if stack is empty
            //when stack is not empty after pop the lastest student,then set previous student to be head of stack 
            prev = stack.Top();
          } else { 
            //when stack is empty break out of this loop
            break;
          }
        }
        PushToStack(student[i], i, count);  //push every students and their caretakers amount to stack
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

      stack.Top().PrintNode(); //print head node
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
  
  public void ShowStack() { //function that print all node in stack
    Node currentNode = stack.Top(); //create node name currentNode that run through the stack (set its first address to head)
    System.out.print("head -> "); 
    while (currentNode != null) { //loop for printing each node in the stack
      currentNode.PrintNode();
      currentNode = currentNode.next;
    }
    System.out.println(" -> tail");
  }

}