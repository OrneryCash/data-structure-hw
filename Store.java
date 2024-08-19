public class Store {
  private Queue queue;
  private String name;
  final int SouvenirEvery = 1000;
  
  public Store(String name) { //constructor for creating store with a name that user want
    this.name = name;
    queue = new Queue();
  }

  public void NewOrder(OrderDetail[] orderList) { //function which adds new order to queue
    //START FIX HERE ʕ·͡ᴥ·ʔ
      queue.Push(new OrderNode(orderList));
    //END FIX HERE ʕ♥ᴥ♥ʔ
  }

  public void Checkout() { //function for checking out all of the order and calculate amount of income and souvenir giveaway 

    double income = 0.0;
    double totalOrderPrice = 0.0;
    int souvenirGiveaway = 0;

    System.out.println("====================================================\n" + 
            "====================================================\n" + 
            name + " Checkout"+
            "\n====================================================");

    
    while (queue.Top() != null) { //loop which continue until there aren't any order in queue
      totalOrderPrice = 0.0;
      int souvenirOrder = 0;

      //START FIX HERE ʕっ•ᴥ•ʔっ┬─┬
      for(int i = 0; i < queue.Top().orderDetail.length; i++) { //loop for finding total order price
        //changing totalOrrderPrice by merging order's item price using a node name curr to run through order node's detail
        OrderDetail curr = queue.Top().orderDetail[i];
        totalOrderPrice += curr.item.GetPrice() * curr.amount;
      }

      //Do something
      queue.Pop(); //pop head of queue every time totalOrderPrice is calculated
      souvenirOrder = (int) (totalOrderPrice / 1000); //calculate souvenir giveaway quantity of this order
      souvenirGiveaway += souvenirOrder; //calculate all souvenir giveaway from all of order
      income += totalOrderPrice; //calculate income from all of order

      //END FIX HERE ʕノ•ᴥ•ʔノ ︵ ┻━┻

      System.out.print("This order's total price: " + totalOrderPrice + " Baht. "); //print out this order's total price

      if (souvenirOrder > 1) { //check if souvenir order value is more than 1 to use a word cards after souvenirOrder value
        System.out.print("This order gets " + souvenirOrder + " cards.");
      }else if (souvenirOrder == 1) { //check if souvenir order value is 1 to use a word card after souvenirOrder value
        System.out.print("This order gets " + souvenirOrder + " card.");
      }

      System.out.println("\n====================================================");


      
    }
    

    System.out.println("Total Income from this checkout: " //print income from this checkout
    + income + " Baht." + 
    "\n====================================================");
    System.out.println("Total Souvenir Giveaway: " //print total souvenir giveaway
    + souvenirGiveaway 
    + "\n===================================================="
    + "\n====================================================");

    
  }

  
  public void ShowQueue() { //show all nodes in queue

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
