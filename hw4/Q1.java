ในหน้านี้ อาจารย์ได้นำโค้ดส่วนที่เป็น Enum Item, OrderDetail class และ OrderNode class ที่สร้างสมบูรณ์แล้ว มานำเสนอให้ นศ ได้ดู
ขอให้ นศ ทำความเข้าใจอย่างรวดเร็วแล้วกด Next ไปข้อถัดไปได้เลย ไม่ต้องแก้ไขอะไรในนี้นะครับ

อธิบายเพิ่มเติม

* Item ทำหน้าที่เก็บข้อมูลรายการสินค้าได้แก่ ชื่อสินค้า และ ราคาของสินค้า

* OrderDetail ทำหน้าที่บรรจุข้อมูลของรายการสินค้า โดยมีข้อมูล item (Item) และ amount (int) จำนวนสินค้า

* OrderNode ทำหน้าที่บรรจุ List ของ รายการสินค้าในแต่ละ Order ไว้


enum Item {
  CAPPUCCINO("Cappuccino", 320.0),
  AMERICANO("Americano", 300.0),
  ESPRESSO("Espresso", 330.0),
  EARLGREY("Earl Grey Tea", 230.0),
  MATCHA("Pure Matcha Latte", 370.0),
  QUICHE("Quiche", 200.0),
  PAINSUISSE("Pain Suisse", 250.0),
  CROQUEMONSIEUR("Chicken Ham Croque Monsieur", 250.0),
  CROISSANT("Chicken Ham Cheese Croissant", 300.0),
  SANDWICH("Duo Delight Sandwich", 180.0),
  KEYCHAIN("Full Body Keychain", 500.0),
  STICKER("Sticker Collection", 300.0),
  KEYCAP("Coffeepanda keycap", 360.0),
  DOLL("Full Body Doll", 1000.0);

  private String name;
  private double price;

  // Define a constructor that takes two arguments
  private Item(String name, double price) {
      this.name = name;
      this.price = price;
  }

  // Define getters for the attributes
  public String GetName() {
      return name;
  }

  public Double GetPrice() {
      return price;
  }
}

public class OrderDetail {
  public Item item;
  public int amount;

  public OrderDetail(Item item, int amount) {
    this.item = item;
    this.amount = amount;
  }

  public String PrintDetail() {
    return item.GetName() + " x" + amount + " = "+ item.GetPrice() * amount +" Baht";
  }
}


public class OrderNode {
  public OrderDetail[] orderDetail;
  OrderNode next;
  
  public OrderNode(OrderDetail[] orderDetail) {
    this.orderDetail = orderDetail;
  }

  public void PrintOrderNode() {
    for(int i = 0; i < orderDetail.length; i++) {

      System.out.println((i+1) + ". " + orderDetail[i].PrintDetail());
    }
  }
}

