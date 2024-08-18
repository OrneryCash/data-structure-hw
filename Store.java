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
      queue.Push(new OrderNode(orderList));
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
        OrderDetail curr = queue.Top().orderDetail[i];
        totalOrderPrice += curr.item.GetPrice() * curr.amount;
      }

      //Do something
      queue.Pop();
      souvenirOrder = (int) (totalOrderPrice / 1000);
      souvenirGiveaway += souvenirOrder;
      income += totalOrderPrice;

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
