/*จงสร้างคลาสที่ชื่อว่า Store ที่สามารถประมวลระบบร้านค้า ตามที่โจทย์กำหนดให้สมบูรณ์

เมื่อสมบูรณ์แล้ว ให้ Copy โค้ดเติมในช่องข้างล่างให้เหมาะสม

ตรวจสอบผลลัพธ์ให้ดี ว่าโค้ดคุณรันผ่าน Testcase ทุกอัน (รวมทั้งที่อาจารย์ซ่อนไว้ด้วย) ว่าผ่านทุกอันรึเปล่า

และเมื่อ Submit โค้ดในหน้านี้เสร็จแล้วอย่าลืมส่งรายชื่อเพื่อนในกลุ่มใน Link Assignment (สีแดง) ด้วย (สำคัญมาก)

* ให้คอมเม้นต์อธิบายการทำงานของฟังก์ชันที่สำคัญ หากการคอมเม้นต์มีน้อยเกินไปคะแนนของคุณจะถูกหัก 50 เปอร์เซ็นของคะแนนที่ได้*/

public class Store {
  private Queue queue;
  private String name;
  final int SouvenirEvery = 1000;
  
  public Store(String name) {
    this.name = name;
    queue = new Queue();
  }

  public void NewOrder(OrderDetail[] orderList) {
    //START FIX HERE ʕ·͡ᴥ·ʔ
      queue.Push(new OrderNode(null));
    //END FIX HERE ʕ♥ᴥ♥ʔ
  }

  public void Checkout() {

    double income = 0.0;
    double totalOrderPrice = 0.0;
    int souvenirGiveaway = 0;

    System.out.println("====================================================\n" + 
            "====================================================\n" + 
            name + " Checkout"+
            "\n====================================================");

    
    while (queue.Top() != null) {
      totalOrderPrice = 0.0;
      int souvenirOrder = 0;

      //START FIX HERE ʕっ•ᴥ•ʔっ┬─┬
      for(int i = 0; i < queue.Top().orderDetail.length; i++) {
        //Do something
      }

      //Do something

      //END FIX HERE ʕノ•ᴥ•ʔノ ︵ ┻━┻

      System.out.print("This order's total price: " + totalOrderPrice + " Baht. ");

      if (souvenirOrder > 1) {
        System.out.print("This order gets " + souvenirOrder + " cards.");
      }else if (souvenirOrder == 1) {
        System.out.print("This order gets " + souvenirOrder + " card.");
      }

      System.out.println("\n====================================================");


      
    }
    

    System.out.println("Total Income from this checkout: " 
    + income + " Baht." + 
    "\n====================================================");
    System.out.println("Total Souvenir Giveaway: " 
    + souvenirGiveaway 
    + "\n===================================================="
    + "\n====================================================");

    
  }

  
  public void ShowQueue() {

    OrderNode currentNode = queue.Top();
    System.out.print("--------------------------------------\n-----------------Head-----------------\n--------------------------------------\n");

    while (currentNode != null) {

        System.out.println("Order Amount = " + currentNode.orderDetail.length);

        currentNode.PrintOrderNode();

        currentNode = currentNode.next;
        System.out.println("--------------------------------------");

    }

    System.out.println("-----------------Tail-----------------\n--------------------------------------");
  }
}
