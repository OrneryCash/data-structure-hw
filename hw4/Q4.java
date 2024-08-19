/*ในหน้านี้ อาจารย์ได้นำโค้ดส่วนที่เป็น Node class ที่สร้างสมบูรณ์แล้ว มานำเสนอให้ นศ ได้ดู
ขอให้ นศ ทำความเข้าใจอย่างรวดเร็วแล้วกด Next ไปข้อถัดไปได้เลย ไม่ต้องแก้ไขอะไรในนี้นะครับ*/

public class Node {
  public int initialPower;
  public int enterDay;
  public int caretaker;

  Node next;

  public Node(int initPow, int day, int caretaker) {
    this.initialPower = initPow;
    this.enterDay = day;
    this.caretaker = caretaker;
  }

  public void PrintNode() {
    System.out.println("Entered Day: " + enterDay + 
      ", Initial Powered: " + initialPower + 
      ", Caretaker: " + caretaker);
  }
}
