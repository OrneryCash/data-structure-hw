public class SinglyLinkedList {
    Node head;
    String listName;
    
    public SinglyLinkedList(String name){
        this.listName = name;
        head = null;
    }
    
    public void PopTail() {
	//START FIX HERE
        if (IsEmpty()){
            System.out.println("ERROR");
        }else{
            Node curr = head;
            if (curr.next != null) {
                while (curr.next.next != null) {
                    curr = curr.next;
                }
                curr.next = null;
            } else {
                head = null;
            }
        }
        //END FIX HERE
    }
    
    public void PopHead(){
	//START FIX HERE
        if (IsEmpty()){
            System.out.println("ERROR");
        }else{
            head = head.next;
        }
        //END FIX HERE
    }
    
    public Node GetHead(){
	//START FIX HERE
        if (IsEmpty()){
            System.out.println("ERROR");
            return new Node("Empty List!");
        } else {
            return head;
        }
        //END FIX HERE
    }
    
    public Node GetTail(){ 
	//START FIX HERE
        if (IsEmpty()){
            System.out.println("ERROR");
            return new Node("Empty List!");
        } else {
            Node curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            return curr;
        }
        //END FIX HERE
    }
    
    public void PushHead(Node node){
	//START FIX HERE
        if (IsEmpty()){
            head = node;
        } else {
            node.next = head;
            head = node;
        }
        //END FIX HERE
    }
    
    public void PushTail(Node node) {
	//START FIX HERE
        if (IsEmpty()){
            head = node;
        } else {
            Node curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = node;
        }
        //END FIX HERE
    }

    public Node FindNode(int id){
	//START FIX HERE
        if (IsEmpty()){
            return new Node("Empty List!");
        } else {
            Node curr = head;
            while (curr != null) {
                if (curr.heroId == id) {
                    return curr;
                }
                curr = curr.next;
            }
            return new Node("Hero Not Found!");
        }
        //END FIX HERE
    }
    
    public Node EraseNode(int id){
	//START FIX HERE
        if (IsEmpty()){
            System.out.println("ERROR");
            return new Node("Empty List!");
        } else {
            Node curr = head;
            if (curr.heroId == id) {
                head = curr.next;
                return curr;
            }
            while (curr.next != null) {
                if (curr.next.heroId == id) {
                    Node tmp = curr.next;
                    curr.next = curr.next.next;
                    return tmp;
                }
                curr = curr.next;
            }
            return new Node("Hero Not Found!");
        }
        //END FIX HERE
    }
    
    public void AddNodeAfter(Node node1, Node node2){
        //START FIX HERE
        node2.next = node1.next;
        node1.next = node2;
        //END FIX HERE
    }
    
    public void AddNodeBefore(Node node1, Node node2){
        //START FIX HERE
        Node curr = head;
        if (curr == node1) {
            node2.next = node1;
            head = node2;
        } else {
            while (curr.next != node1) {
                curr = curr.next;
            }
            node2.next = node1;
            curr.next = node2; 
        }
        //END FIX HERE
    }
    
    public boolean IsEmpty(){
        //START FIX HERE
        return head == null;
        //END FIX HERE
    }
    public void Merge(SinglyLinkedList list){
        //START FIX HERE
        Node curr = head;
        while (curr.next != null) {
            curr = curr.next;
        }
        curr.next = list.head;
        //END FIX HERE        
    }
    
    public void PrintStructure(){
        //START FIX HERE
        System.out.print(this.listName + ": head -> ");
        if (IsEmpty()) {
            System.out.println("null");
        } else {
            Node curr = head;
            while (curr.next != null) {
                System.out.print("{" + curr.heroId + "} -> ");
                curr = curr.next;
            }
            System.out.println("{" + curr.heroId + "} -> null");
        }
        //END FIX HERE
    }
    
    public Node GetHighestHPHero(){
	//START FIX HERE
        if (IsEmpty()) {
            return new Node("Empty List!");
        } else {
            Node curr = head;
            Node maxHPHero = curr;
            curr = curr.next;
            while (curr != null) {
                if (curr.hp >= maxHPHero.hp) {
                    maxHPHero = curr;
                }
                curr = curr.next;
            }
            return maxHPHero;
        }
        //END FIX HERE
    }
    
    public double GetMiddleHP(){
        //START FIX HERE
        if (IsEmpty()) {
            return 0.0;
        }
        int size = 0;
        Node curr = head;
        while (curr != null) {
            size++;
            curr = curr.next;
        }
        int curr_size = 0;
        curr = head;
        double midHP = 0.0;
        if (size % 2 == 0) {
            while (curr != null) {
                curr_size++;
                if (curr_size == size / 2) {
                    midHP = (curr.hp + curr.next.hp) / 2.0;
                    break;
                }
                curr = curr.next;
            }
        } else {
            while (curr != null) {
                curr_size++;
                if (curr_size == size / 2 + 1) {
                    midHP = curr.hp;
                    break;
                }
                curr = curr.next;
            }
        }
        return midHP;
        //END FIX HERE
    }

    public void PrintHeroWithType(Attribute att){
        if (IsEmpty()){
            System.out.println("Empty List!");
            return;
        }
        //START FIX HERE
        int n=0;
        Node curr = head;
        while (curr != null) {
            if (curr.att == att) {
                n++;
            }
            curr = curr.next;
        }

        if (n == 0) {
            System.out.println("There is no hero with this attribute");
        } else if (n == 1) {
            System.out.printf("Print Hero With This Attribute: %s has %d hero\n",att, n);
        } else {
            System.out.printf("Print Hero With This Attribute: %s has %d heroes\n",att, n);
        }

        int i = 1;
        curr = head;
        while (curr != null) {
            if (curr.att == att) {
                System.out.printf("%d. HeroID: %d , Name: %s , HP: %.1f, Attribute: %s\n", i, curr.heroId, curr.name, curr.hp, curr.att);
                i++;
            }
            curr = curr.next;
        }
        //END FIX HERE
    }
}