/*จงสร้างคลาสที่ชื่อว่า Queue ที่สามารถบรรจุ Node ไว้ตามหลักการ FIFO ตามที่โจทย์กำหนดให้สมบูรณ์

ข้อนี้โจทย์บังคับให้คุณสร้าง Singly Linked List with tail เพื่อเป็น Queue

เมื่อสมบูรณ์แล้ว ให้ Copy โค้ดเติมในช่องข้างล่างให้เหมาะสม

ตรวจสอบผลลัพธ์ให้ดี ว่าโค้ดคุณรันผ่าน Testcase ทุกอัน (รวมทั้งที่อาจารย์ซ่อนไว้ด้วย) ว่าผ่านทุกอันรึเปล่า

และเมื่อ Submit โค้ดในหน้านี้เสร็จแล้วอย่าลืมส่งรายชื่อเพื่อนในกลุ่มใน Link Assignment (สีแดง) ด้วย (สำคัญมาก)

* ให้คอมเม้นต์อธิบายการทำงานของฟังก์ชันที่สำคัญ หากการคอมเม้นต์มีน้อยเกินไปคะแนนของคุณจะถูกหัก 50 เปอร์เซ็นของคะแนนที่ได้*/


public class Queue {
  // Implement Queue using Linked List with tail
  OrderNode head;
  OrderNode tail;
  
  public void Push(OrderNode node){
    //START FIX HERE
        if (head == null){
            // Do something (Empty list)
        }else{
            // Do something (Non-empty list)
        }
    //END FIX HERE
  }
  
  public void Pop(){
    //START FIX HERE
        if (head != null){
            if (head != tail){
                // Do something (List of many nodes)
            }else{
                // Do something (List of a single node)
            }
        }
    //END FIX HERE
  }
  
  public OrderNode Top(){
    //START FIX HERE
      return null;
    //END FIX HERE
  }
  
}
