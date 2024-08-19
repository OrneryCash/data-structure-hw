/*จงสร้างคลาสที่ชื่อว่า HashiraCamp ที่ทำหน้าที่รับข้อมูลลูกศิษย์ที่เข้าศึกษาในสำนัก และประมวลผลโจทย์ ตามที่โจทย์กำหนดให้สมบูรณ์

สามารถดูรายละเอียดโจทย์ในการบ้านสีแดง ข้อที่ 2

เมื่อสมบูรณ์แล้ว ให้ Copy โค้ดเติมในช่องข้างล่างให้เหมาะสม

ตรวจสอบผลลัพธ์ให้ดี ว่าโค้ดคุณรันผ่าน Testcase ทุกอัน (รวมทั้งที่อาจารย์ซ่อนไว้ด้วย) ว่าผ่านทุกอันรึเปล่า

และเมื่อ Submit โค้ดในหน้านี้เสร็จแล้วอย่าลืมส่งรายชื่อเพื่อนในกลุ่มใน Link Assignment (สีแดง) ด้วย (สำคัญมาก)

* ให้คอมเม้นต์อธิบายการทำงานของฟังก์ชันที่สำคัญ หากการคอมเม้นต์มีน้อยเกินไปคะแนนของคุณจะถูกหัก 50 เปอร์เซ็นของคะแนนที่ได้
* จะลองตอบ Time Complexity ในนี้ก็ได้นะไม่มีผลต่อการให้คะแนนในส่วนการบ้านสีเหลือง*/

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
    stack.Push(new Node(0, 0, 0));
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
        
        //END FIX HERE
      }else {
        //START FIX HERE
        
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
    System.out.println("Θ(log(n))");
    System.out.println("Θ(n)");
    System.out.println("Θ(n^2)");
    System.out.println("Θ(n^3)");
    System.out.println("Θ(2^n)");
    System.out.println("Θ(n!)");
    // Choose the best O time complexity for this problem
    System.out.println("O(log(n))");
    System.out.println("O(n)");
    System.out.println("O(n^2)");
    System.out.println("O(n^3)");
    System.out.println("O(2^n)");
    System.out.println("O(n!)");
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
